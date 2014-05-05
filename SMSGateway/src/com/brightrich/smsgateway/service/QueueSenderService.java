package com.brightrich.smsgateway.service;


import java.util.HashMap;

import org.apache.commons.lang3.SerializationUtils;

import com.brightrich.smsgateway.pojo.MessageObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class QueueSenderService {
	 
	private final static String QUEUE_NAME = "INBOUNDQ";
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
		QueueSenderService qs = new QueueSenderService();		
		HashMap<String,String> msg = new HashMap<String,String>();
		msg.put("msisdn","+6281286041588");
		msg.put("message","LION CGK DPS R 30 DEC MORNING - 31 DEC NIGHT ECONOMY 2");
		//msg.put("message","BOOKING O#1 R#3");
		//msg.put("message","PAX P1 MR Arga Hasril 3275081107850014#P2 MR Miko Guntur Garibaldi 327000123849245");
		//msg.put("message","PAY");
		qs.sendMessageToInboundQueue(msg);
	}
	 
}
