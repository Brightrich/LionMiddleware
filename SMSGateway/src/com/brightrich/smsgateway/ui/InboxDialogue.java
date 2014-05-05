package com.brightrich.smsgateway.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class InboxDialogue extends javax.swing.JDialog {
    private Connection conn;

    /** Creates new form DialogPesanMasuk */
    public InboxDialogue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setConn(Connection conn){
        this.conn = conn;
        try {
            
            String sql = "SELECT * FROM SMS_IN";
            PreparedStatement prepare = conn.prepareStatement(sql);

            ResultSet res = prepare.executeQuery();
            res.last();
            int n = res.getRow();
            
            Object[][] data = new Object[n][7];
            int p = 0;
            
            res.beforeFirst();
            
            while (res.next()) {
                data[p][0] = res.getInt(1);
                data[p][1] = res.getString(2);
                data[p][2] = res.getString(3);
                data[p][3] = res.getString(4);
                data[p][4] = res.getString(5);
                data[p][5] = res.getString(6);
                data[p][6] = res.getDate(7);
                p++;
            }
            
            TabelModel model = new TabelModel();
            model.addData(data);
            
            messageTable.setModel(model);
            
            //modifikasi lebar kolom
            messageTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            messageTable.getColumnModel().getColumn(1).setPreferredWidth(255);
            messageTable.getColumnModel().getColumn(2).setPreferredWidth(55);
            messageTable.getColumnModel().getColumn(3).setPreferredWidth(255);
            messageTable.getColumnModel().getColumn(4).setPreferredWidth(55);
            messageTable.getColumnModel().getColumn(5).setPreferredWidth(55);
            messageTable.getColumnModel().getColumn(6).setPreferredWidth(55);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inbox");

        messageTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(messageTable);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-449)/2, (screenSize.height-422)/2, 449, 422);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable messageTable;
    // End of variables declaration//GEN-END:variables

    class TabelModel extends AbstractTableModel {
        String[] kolomHeader = {
                "Id SMS","SMS", "No SMS", "PDU",
                "Encoding", "Id Gtateway", "Tanggal"};
        Object[][] data;
        
        public void addData(Object[][] obj){
            data = obj;
            fireTableDataChanged();
        }
        
        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return kolomHeader.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return kolomHeader[column];
        }
    }
}
