package com.brightrich.smsgateway.ui;

import javax.swing.ImageIcon;


public class StatusPanel extends javax.swing.JPanel {
    public static final int CONNECTION_ERROR = 0;
    public static final int CONNECTED = 1;
    public static final int BROKEN = 3;

    /** Creates new form PanelStatus */
    public StatusPanel() {
        initComponents();
    }
    
    public void setConnectionStatus(int status, String s){
        if(status == CONNECTION_ERROR ){
            jLabel1.setIcon(new ImageIcon(getClass()
                    .getResource("/com/brightrich/smsgateway/image/error.png")));
            jLabel1.setText(s);
        }else if(status == CONNECTED ){
            jLabel1.setIcon(new ImageIcon(getClass()
                    .getResource("/com/brightrich/smsgateway/image/mobile_phone.png")));
            jLabel1.setText(s);
        }else if(status == BROKEN ){
            jLabel1.setIcon(new ImageIcon(getClass()
                    .getResource("/com/brightrich/smsgateway/image/mobile_phone_off.png")));
            jLabel1.setText(s);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/mobile_phone_off.png"))); // NOI18N
        jLabel1.setText("No Service");
        add(jLabel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
