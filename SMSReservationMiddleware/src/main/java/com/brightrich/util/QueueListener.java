package com.brightrich.util;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.brightrich.dao.BookingResultDao;
import com.brightrich.dao.InquiryResultDao;
import com.brightrich.dao.SMSMessageDao;
import com.brightrich.model.SMSMessage;
import com.brightrich.service.Worker;



@Configuration
public class QueueListener {			
	
	private SMSMessageDao smsMessageDao;
	private static InquiryResultDao inquiryResultDao;
	private static BookingResultDao bookingResultDao;	
	Logger log = LoggerFactory.getLogger(QueueListener.class);
	
	public void setSmsMessageDao(SMSMessageDao smsMessageDao) {
		this.smsMessageDao = smsMessageDao;
	}
	
	public void setInquiryResultDao(InquiryResultDao inquiryResultDao) {
		this.inquiryResultDao = inquiryResultDao;
	}
    
    public void setBookingResultDao(BookingResultDao bookingResultDao) {
		this.bookingResultDao = bookingResultDao;
	}
	
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory());
        container.setQueueNames("INBOUNDQ");
        container.setMessageListener(exampleListener());
        return container;
    }

    

	@Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory =
            new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public MessageListener exampleListener() {
        return new MessageListener() {
            public void onMessage(Message message) {
            	Map<String, String> msgMap = (Map<String, String>) SerializationUtils.deserialize(message.getBody());
                //System.out.println("received message from: " + msgMap.get("msisdn") + " says: " + msgMap.get("message"));
                log.info("received message from: " + msgMap.get("msisdn") + " says: " + msgMap.get("message"));
                
                SMSMessage msg = new SMSMessage();
                msg.setMessage(msgMap.get("message"));
                msg.setMsisdn(msgMap.get("msisdn"));
                msg.setReceivedDate(new Date());
                
                try{
                smsMessageDao.saveTransaction(msg);
                } catch (Exception e){
                	e.printStackTrace();
                }
                
                /*HashMap<String, String> responseMap = null;
                String response = "";*/
                
                //System.out.println("STEPS = BEGIN FLIGHT PROCESS");
                log.info("create new worker to proceed");
                new Thread(new Worker(msg.getMessage(),msg.getMsisdn(),null, inquiryResultDao, bookingResultDao)).start();
               
                
            }
        };
    }           
    
}