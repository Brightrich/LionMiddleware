package com.brightrich.util;

import java.util.HashMap;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class QueueSender {

	private final static String QUEUE_NAME = "OUTBOUNDQ";
	private final static String HOST = "localhost";
	
	public static void sendMessageToInboundQueue(HashMap<String,String> msg) throws Exception{
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(HOST);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    //channel.queueDeclare(QUEUE_NAME, false, false, false, null);	
	    
	    
	    channel.basicPublish("", QUEUE_NAME, null, SerializationUtils.serialize(msg));
	    
	    System.out.println(" [x] Sent '" + msg.toString() + "'");
	    
	    channel.close();
	    connection.close();
	}
	
	
	public static void main(String[] args) throws Exception{
		QueueSender qs = new QueueSender();		
		HashMap<String,String> msg = new HashMap<String,String>();
		msg.put("msisdn","+6281286041588");
		msg.put("message","Hello World!!! Welcome to RabbitMq!!!");
		qs.sendMessageToInboundQueue(msg);
	}
	
}
