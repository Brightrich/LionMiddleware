package com.brightrich.smsgateway.service;

import java.util.Map;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import org.apache.commons.lang3.SerializationUtils;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;

public class QueueReceiver implements Runnable{

    private final static String QUEUE_NAME = "OUTBOUNDQ";
    static boolean finished = false;       

    public static void startJMSListenerService() throws Exception{
    	ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
        
        while (!finished) {
          try{
          QueueingConsumer.Delivery delivery = consumer.nextDelivery();
          //String message = new String(delivery.getBody());
          Map obj = (Map)SerializationUtils.deserialize(delivery.getBody());
          System.out.println(" [x] Received '" + obj.get("message") + "' from: " + obj.get("msisdn"));
          
          sendResponse(Service.getInstance(), (String)obj.get("msisdn"), (String)obj.get("message"));
          } catch(InterruptedException ie){
        	  System.out.println("Thread interrupted and will be gracefully stopped");
        	  finished = true;
          }
        }
    }
    
    public static void sendResponse(Service service, String recepientNumber, String message) throws Exception
	{
		
		/*System.out.println("Example: Send message from a serial gsm modem.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());*/				
		
		// Send a message synchronously.
		OutboundMessage msg = new OutboundMessage(recepientNumber, message);
		service.sendMessage(msg);
		System.out.println(msg);
				
		System.out.println("Now Sleeping - Hit <enter> to terminate.");
		
		
	}
    
    
    public static void main(String[] argv) throws Exception {

    /*ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    
    QueueingConsumer consumer = new QueueingConsumer(channel);
    channel.basicConsume(QUEUE_NAME, true, consumer);
    
    while (true) {
      QueueingConsumer.Delivery delivery = consumer.nextDelivery();
      //String message = new String(delivery.getBody());
      Map obj = (Map)SerializationUtils.deserialize(delivery.getBody());
      System.out.println(" [x] Received '" + obj.get("message") + "' from: " + obj.get("msisdn"));
    }*/
    	
    	QueueReceiver.sendResponse(Service.getInstance(), "+62817113289", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

  }

	@Override
	public void run() {
		try {			
			startJMSListenerService();					
		} catch (Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Gracefully stop the listener thread");
		return;
	}
}