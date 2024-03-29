/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uirun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class viewPurchase extends javax.swing.JFrame {

    List med = new ArrayList();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/medicine";
    static final String USER = "root";
    static final String PASS = "";

    public viewPurchase() {
        initComponents();
        String medicName = null;
        String quantity = null;
        String price = null;

        String count = ("SELECT SUM(p.quantity * m.price) AS totalPrice FROM tblpurchase p LEFT JOIN tblmedicine m ON p.idMedicine = m.idMedicine");
        String retrieveMed = String.format("Select COUNT(idPurchase) from tblpurchase");
        String retrievePurchased = String.format("Select m.medicineName, p.quantity, m.price FROM tblpurchase p LEFT JOIN tblmedicine m ON p.idMedicine = m.idMedicine");
        Connection conn = null;
        Statement stmt = null;
//        String retrieveQuery;
//        retrieveQuery = String.format("SELECT * from `medic`");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrievePurchased);
            while (rsAccount.next()) {
                medicName = rsAccount.getString("medicineName");
                quantity = rsAccount.getString("quantity");
                price = rsAccount.getString("price");
//                System.out.println(medicName + " " + brandName + " " + genName + " " + price);
                med.add(medicName);
                med.add(quantity);
                med.add(price);
            }
            ResultSet resultSet = stmt.executeQuery(retrieveMed);
            resultSet.next();
            int rowcount = resultSet.getInt(1);
            System.out.println(rowcount);
            int x = 0;
//            medTable.addRowSelectionInterval(0, rowcount);
//            System.out.println(medTable.getRowCount());
            System.out.println("asdf");
            for (int row = 0; row < rowcount; row++) {
                for (int col = 0; col < medTable.getColumnCount(); col++) {
//                    System.out.println(medTable.getValueAt(row, col));
                    medTable.setValueAt(med.get(x), row, col);
                    x++;
                }
            }
            ResultSet resultSetCount = stmt.executeQuery(count);
            resultSetCount.next();
            totalPrice.setText(resultSetCount.getString("totalPrice"));
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        appName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        search = new java.awt.TextField();
        jSeparator2 = new javax.swing.JSeparator();
        Flixotide = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        medicineName2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        appName.setFont(new java.awt.Font("Sitka Small", 1, 40)); // NOI18N
        appName.setText(" Laurex Pharma");
        appName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appNameMouseClicked(evt);
            }
        });

        search.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Flixotide.setBackground(new java.awt.Color(153, 153, 153));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("OK");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        medicineName2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        medicineName2.setText("----Purchase----");

        medTable.setBackground(new java.awt.Color(204, 204, 204));
        medTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Medicine Name", "Quantity Purchased", "Price"
            }
        ));
        jScrollPane7.setViewportView(medTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Total Price:");

        totalPrice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        totalPrice.setText("...");

        javax.swing.GroupLayout FlixotideLayout = new javax.swing.GroupLayout(Flixotide);
        Flixotide.setLayout(FlixotideLayout);
        FlixotideLayout.setHorizontalGroup(
            FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlixotideLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlixotideLayout.createSequentialGroup()
                        .addComponent(medicineName2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FlixotideLayout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
            .addGroup(FlixotideLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(totalPrice)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FlixotideLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7)
                    .addContainerGap()))
        );
        FlixotideLayout.setVerticalGroup(
            FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlixotideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medicineName2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(29, 29, 29))
            .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FlixotideLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );

        jLabel2.setFont(new java.awt.Font("Wide Latin", 1, 48)); // NOI18N
        jLabel2.setText("Medicines");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Flixotide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Flixotide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        search.getText();
        search.setText("");
    }//GEN-LAST:event_searchActionPerformed

    private void appNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appNameMouseClicked
        String identity = null;
        String retrieveQueryPharmacist = String.format("Select pharmaIdentity from tblPharma");
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQueryPharmacist);
            rsAccount.next();
            identity = rsAccount.getString("pharmaIdentity");
            if (identity.equals("1")) {
                new dashboardPharmacist().setVisible(true);
                this.setVisible(false);
            } else {
                new dashboard().setVisible(true);
                this.setVisible(false);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_appNameMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        //Not Final
        String identity = null;
        String retrieveQueryPharmacist = String.format("Select pharmaIdentity from tblPharma");
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQueryPharmacist);
            rsAccount.next();
            identity = rsAccount.getString("pharmaIdentity");
            if (identity.equals("1")) {
                new dashboardPharmacist().setVisible(true);
                this.setVisible(false);
            } else {
                new dashboard().setVisible(true);
                this.setVisible(false);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        med.clear();
    }//GEN-LAST:event_jButton6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewPurchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewPurchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Flixotide;
    private javax.swing.JLabel appName;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable medTable;
    private javax.swing.JLabel medicineName2;
    private java.awt.TextField search;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
}
