package com.brightrich.smsgateway.ui;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.brightrich.smsgateway.pojo.Status;
import com.brightrich.smsgateway.service.Dao;
import com.brightrich.smsgateway.service.ReadSMSService;

public class SMSGatewayView extends javax.swing.JFrame {
    private Connection conn = null;
    private Status status;

    /** Creates new form SMSGatewayView */
    public SMSGatewayView() {
        initComponents();
        status = new Status();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIndikator1 = new IndicatorPanel();
        jPanel1 = new javax.swing.JPanel();
        buttonStart = new javax.swing.JButton();
        buttonViewMessage = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        panelStatus1 = new StatusPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMS Gateway Beta Version");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        buttonStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/control.png"))); // NOI18N
        buttonStart.setText("Start Service");
        buttonStart.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonStart.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonViewMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/pesan.png"))); // NOI18N
        buttonViewMessage.setText("View Message");
        buttonViewMessage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonViewMessage.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonViewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonViewMessageActionPerformed(evt);
            }
        });

        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/control_power.png"))); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonExit.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonViewMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
            .addComponent(buttonExit, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(buttonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonViewMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Log Inbound SMS"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        logArea.setColumns(20);
        logArea.setFont(new java.awt.Font("Tahoma", 0, 10));
        logArea.setLineWrap(true);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelStatus1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/phone.png"))); // NOI18N
        jLabel1.setText("<html><h1>Control Panel");
        jPanel3.add(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelIndikator1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, 0, 118, Short.MAX_VALUE)
                    .addComponent(panelIndikator1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-507)/2, (screenSize.height-391)/2, 507, 391);
    }// </editor-fold>//GEN-END:initComponents

private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
	ReadSMSService.t.interrupt();
    System.exit(0);    
}//GEN-LAST:event_buttonKeluarActionPerformed

private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
    try{
        conn = Dao.createConnection();
    }catch(Exception e){
        panelStatus1.setConnectionStatus(
                StatusPanel.CONNECTION_ERROR, 
                "Error connecting to DB");
        return;
    }

    if(conn == null){
        return;
    }
    
    ReadSMSService smsService = new ReadSMSService(conn, logArea);
    smsService.setStatus(status);
    try {
        smsService.startService();                                           
        panelIndikator1.setStatus(status);
        panelStatus1.setConnectionStatus(
                StatusPanel.CONNECTED, 
                "Service ready");
    } catch (Exception ex) {
    	ex.printStackTrace();
        panelStatus1.setConnectionStatus(
                StatusPanel.CONNECTED, 
                "Erros while starting the service");
    }
}//GEN-LAST:event_buttonStartActionPerformed

private void buttonViewMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLihatPesanActionPerformed
    if(conn == null ){
        JOptionPane.showMessageDialog(this, "Please Start the service first!!");
        return;
    }
    InboxDialogue inboxDlg = new InboxDialogue(this, true);
    inboxDlg.setConn(conn);
    inboxDlg.setVisible(true);
}//GEN-LAST:event_buttonLihatPesanActionPerformed


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        try{
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SMSGatewayView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonViewMessage;
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logArea;
    private IndicatorPanel panelIndikator1;
    private StatusPanel panelStatus1;
    // End of variables declaration//GEN-END:variables

}
