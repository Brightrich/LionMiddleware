package com.brightrich.smsgateway.ui;

import com.brightrich.smsgateway.pojo.Status;

public class IndicatorPanel extends javax.swing.JPanel {

    /** Creates new form PanelIndikator */
    public IndicatorPanel() {
        initComponents();
    }
    
    public void setStatus(Status s){
        signal.setText(s.getSignal() +" % ");
        battery.setText(s.getBattery() + " %");
        manufacture.setText("Modem Manufacture: "+s.getManufacture());
        model.setText("Model : "+s.getModel());
        serialNo.setText("Serial No/IMEY: "+s.getSerialNo());
        imsi.setText("SIM IMSI : " + s.getSimImsi());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        signal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        battery = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        manufacture = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        serialNo = new javax.swing.JLabel();
        imsi = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Keterangan Modem/HP"), javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/signal.png"))); // NOI18N
        jLabel1.setToolTipText("Signal");
        jPanel1.add(jLabel1);

        signal.setText("0%");
        jPanel1.add(signal);

        jLabel3.setText("||");
        jPanel1.add(jLabel3);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/brightrich/smsgateway/image/baterai.png"))); // NOI18N
        jLabel4.setToolTipText("Baterai");
        jPanel1.add(jLabel4);

        battery.setText("0%");
        jPanel1.add(battery);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        manufacture.setText("Modem Manufacture :");
        jPanel2.add(manufacture);

        model.setText("Modem Model :");
        jPanel2.add(model);

        serialNo.setText("Serial No :");
        jPanel2.add(serialNo);

        imsi.setText("SIM IMSI");
        jPanel2.add(imsi);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel battery;
    private javax.swing.JLabel imsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel manufacture;
    private javax.swing.JLabel model;
    private javax.swing.JLabel serialNo;
    private javax.swing.JLabel signal;
    // End of variables declaration//GEN-END:variables

}
