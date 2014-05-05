package com.brightrich.smsgateway.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JTextArea;

import org.smslib.AGateway;
import org.smslib.AGateway.GatewayStatuses;
import org.smslib.AGateway.Protocols;
import org.smslib.ICallNotification;
import org.smslib.IGatewayStatusNotification;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOutboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Message.MessageTypes;
import org.smslib.Service;
import org.smslib.modem.ModemGateway.IPProtocols;
import org.smslib.modem.SerialModemGateway;

import com.brightrich.smsgateway.pojo.Status;

public class ReadSMSService {
	
	private Status status = null;
	private JTextArea textArea;
	Service service;
	private Connection conn;
	
	public static Thread t;
	
	public ReadSMSService(Connection conn, JTextArea textArea) {
        this.conn = conn;
        this.textArea = textArea;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void startService() throws Exception {
        InboundMessageHandler inboundMessageHandler = new InboundMessageHandler();
        
        InboundCallHandler inboundCallHandler = new InboundCallHandler();
        
        GatewayStatusHandler gatewayStatusHandler = new GatewayStatusHandler();
        
        OutboundNotification outboundNotification = new OutboundNotification();
        
        this.service = Service.getInstance();

//      IPModemGateway gateway = new IPModemGateway("Motorola.COM3", 
//                "COM3", 
//                57600, 
//                "Motorola", 
//                "C380");
        
        SerialModemGateway gateway = new SerialModemGateway (
                "HUAWEI.COM7", 
                "COM7", 
                57600, 
                "VETTEL", 
                "3G");
        
        gateway.setIpProtocol(IPProtocols.BINARY);

        gateway.setProtocol(Protocols.PDU);

        gateway.setInbound(true);

        gateway.setOutbound(true);

        gateway.setSimPin("110785");

        this.service.setInboundMessageNotification(inboundMessageHandler);
        this.service.setCallNotification(inboundCallHandler);
        this.service.setGatewayStatusNotification(gatewayStatusHandler);        
        this.service.setOutboundMessageNotification(outboundNotification);
        
        gateway.getATHandler().setStorageLocations("SM");
        this.service.addGateway(gateway);
                
        this.service.startService();

        if(status != null ) {
            this.status.setManufacture(gateway.getManufacturer());
            this.status.setModel(gateway.getModel());
            this.status.setSerialNo(gateway.getSerialNo());
            this.status.setSimImsi(gateway.getImsi());
            this.status.setSignal(gateway.getSignalLevel());
            this.status.setBattery(gateway.getBatteryLevel());
        }
        
        t = new Thread(new QueueReceiver());
        t.start();
    }
    
    class InboundMessageHandler 
            implements IInboundMessageNotification {

        public void process(
                AGateway idGateway, 
                MessageTypes msgType, 
                InboundMessage inboundMsg) {
            if(msgType == MessageTypes.STATUSREPORT) return;
            
            System.out.println("Message retrieved : " + inboundMsg.getText());
            
            
            try {
            	
            	System.out.println("Trying to save message");
            	
                String sql = "INSERT INTO SMS_IN VALUES (NULL,?,?,?,?,?,?)";
                PreparedStatement prepare = conn.prepareStatement(sql);
                prepare.setString(1, inboundMsg.getText());
                prepare.setString(2, "+"+inboundMsg.getOriginator());
                //prepare.setString(3, inboundMsg.getPduUserData());
                prepare.setString(3, inboundMsg.getEncoding().name());
                prepare.setString(4, inboundMsg.getGatewayId());
                prepare.setDate(5, new java.sql.Date(inboundMsg.getDate().getTime()));
                prepare.setString(6, inboundMsg.getSmscNumber());
                
                prepare.executeUpdate();
                
                System.out.println("Message saved");
                
            } catch (SQLException ex) {
                System.out.println("Message failed to be saved");
                System.out.println(ex.getMessage());
            } catch (Exception ex){
            	ex.printStackTrace();
            }
            
            textArea.append("\nMessage Received:\n"+
            		inboundMsg.getOriginator() +"\n"+
            		inboundMsg.getText());
            textArea.append("\n-----------------------------");
            
            try {
                ReadSMSService.this.service.deleteMessage(inboundMsg);
            } catch (Exception e){
            	e.printStackTrace();
            }
            
            
            try {
            	HashMap<String, String> mapRequest = new HashMap<String,String>();
            	mapRequest.put("msisdn", "+"+inboundMsg.getOriginator());
            	mapRequest.put("message", inboundMsg.getText());
            	QueueSenderService.sendMessageToInboundQueue(mapRequest);            	            	            	
				//sendResponse(service, "+6281286041588", "Thank you for booking our flight");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    class InboundCallHandler implements ICallNotification {
        public void process(
                AGateway idGateway, 
                String noHP) {

        }		
    }
    
    class GatewayStatusHandler implements 
            IGatewayStatusNotification {
        public void process(
                AGateway idGateway, 
                GatewayStatuses statusLama, 
                GatewayStatuses statusBaru) {

        }		
    }
    
    class OutboundNotification implements IOutboundMessageNotification
	{
		public void process(AGateway gateway, OutboundMessage msg)
		{
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}
	}
    
    	
    
}
