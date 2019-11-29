/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uirun;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dashboardPharmacist extends javax.swing.JFrame {

    List med = new ArrayList();
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/medicine";
    static final String USER = "root";
    static final String PASS = "";

    public dashboardPharmacist() {
        initComponents();
        med.clear();
        String medName = medicineName.getText();
//        String pass = passInput.getText();
        String medicName = null;
        String brandName = null;
        String genName = null;
        String price = null;

//        String retrieveQuery = String.format("INSERT INTO medic(firstName,age,lastName,userName,password) VALUES ('%s','%d','%s','%s','%s')", firstname, age, lastname,userName,logpass);
        String retrieveQuery = String.format("Select medicineName, brandName, genericName, price from tblMedicine where medicineType='%s'", medName);
        String retrieveMed = String.format("Select COUNT(medicineName) from tblMedicine where medicineType='%s'", medName);
        Connection conn = null;
        Statement stmt = null;

//        String retrieveQuery;
//        retrieveQuery = String.format("SELECT * from `medic`");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQuery);
            while (rsAccount.next()) {
                medicName = rsAccount.getString("medicineName");
                brandName = rsAccount.getString("brandName");
                genName = rsAccount.getString("genericName");
                price = rsAccount.getString("price");
//                System.out.println(medicName + " " + brandName + " " + genName + " " + price);
                med.add(medicName);
                med.add(brandName);
                med.add(genName);
                med.add(price);
            }
            ResultSet resultSet = stmt.executeQuery(retrieveMed);
            resultSet.next();
            int rowcount = resultSet.getInt(1);
            int x = 0;
            for (int row = 0; row < rowcount; row++) {
                for (int col = 0; col < medTable.getColumnCount(); col++) {
//                    System.out.println(medTable.getValueAt(row, col));
                    medTable.setValueAt(med.get(x), row, col);
                    x++;
                }
            }
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
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        search = new java.awt.TextField();
        jSeparator2 = new javax.swing.JSeparator();
        Flixotide = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnCough = new javax.swing.JButton();
        btnAllergy = new javax.swing.JButton();
        btnHeadache = new javax.swing.JButton();
        btnBodyPain = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        medicineName = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("View Purchase");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 40)); // NOI18N
        jLabel1.setText(" Laurex Pharma");

        search.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Flixotide.setBackground(new java.awt.Color(153, 153, 153));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("View Purchase");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        btnCough.setText("Cough");
        btnCough.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCoughMouseClicked(evt);
            }
        });

        btnAllergy.setText("Allergy");
        btnAllergy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAllergyMouseClicked(evt);
            }
        });

        btnHeadache.setText("Headache");
        btnHeadache.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHeadacheMouseClicked(evt);
            }
        });

        btnBodyPain.setText("Body Pain");
        btnBodyPain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBodyPainMouseClicked(evt);
            }
        });

        medTable.setBackground(new java.awt.Color(204, 204, 204));
        medTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Medicine Name", "Brand Name", "Generic Name", "Price"
            }
        ));
        jScrollPane2.setViewportView(medTable);

        medicineName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        medicineName.setText("Cough");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Purchase");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("View All Purchased");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setText("Add Medicine");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setText("Update Medicine");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FlixotideLayout = new javax.swing.GroupLayout(Flixotide);
        Flixotide.setLayout(FlixotideLayout);
        FlixotideLayout.setHorizontalGroup(
            FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlixotideLayout.createSequentialGroup()
                .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FlixotideLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlixotideLayout.createSequentialGroup()
                                .addComponent(btnCough, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBodyPain, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHeadache, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAllergy, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(FlixotideLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(81, 81, 81))
                    .addGroup(FlixotideLayout.createSequentialGroup()
                        .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FlixotideLayout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(medicineName))
                            .addGroup(FlixotideLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logout)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FlixotideLayout.setVerticalGroup(
            FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlixotideLayout.createSequentialGroup()
                .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCough, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBodyPain, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllergy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHeadache, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(medicineName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(logout)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FlixotideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton2)
                    .addComponent(jButton8))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Wide Latin", 1, 48)); // NOI18N
        jLabel2.setText("Medicines");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Flixotide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnCoughMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCoughMouseClicked
        med.clear();
        medicineName.setText("Cough");
        String medName = medicineName.getText();
        String medicName = null;
        String brandName = null;
        String genName = null;
        String price = null;

//        String retrieveQuery = String.format("INSERT INTO medic(firstName,age,lastName,userName,password) VALUES ('%s','%d','%s','%s','%s')", firstname, age, lastname,userName,logpass);
        String retrieveQuery = String.format("Select medicineName, brandName, genericName, price from tblMedicine where medicineType='%s'", medName);
        String retrieveMed = String.format("Select COUNT(medicineName) from tblMedicine where medicineType='%s'", medName);
        Connection conn = null;
        Statement stmt = null;

//        String retrieveQuery;
//        retrieveQuery = String.format("SELECT * from `medic`");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQuery);
            while (rsAccount.next()) {
                medicName = rsAccount.getString("medicineName");
                brandName = rsAccount.getString("brandName");
                genName = rsAccount.getString("genericName");
                price = rsAccount.getString("price");
//                System.out.println(medicName + " " + brandName + " " + genName + " " + price);
                med.add(medicName);
                med.add(brandName);
                med.add(genName);
                med.add(price);
            }
            ResultSet resultSet = stmt.executeQuery(retrieveMed);
            resultSet.next();
            int rowcount = resultSet.getInt(1);
            int x = 0;
            for (int row = 0; row < rowcount; row++) {
                for (int col = 0; col < medTable.getColumnCount(); col++) {
//                    System.out.println(medTable.getValueAt(row, col));
                    medTable.setValueAt(med.get(x), row, col);
                    x++;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnCoughMouseClicked

    private void btnBodyPainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBodyPainMouseClicked
        med.clear();
        medicineName.setText("Body Pain");
        String medName = "bodyPain";
        String medicName = null;
        String brandName = null;
        String genName = null;
        String price = null;

//        String retrieveQuery = String.format("INSERT INTO medic(firstName,age,lastName,userName,password) VALUES ('%s','%d','%s','%s','%s')", firstname, age, lastname,userName,logpass);
        String retrieveQuery = String.format("Select medicineName, brandName, genericName, price from tblMedicine where medicineType='%s'", medName);
        String retrieveMed = String.format("Select COUNT(medicineName) from tblMedicine where medicineType='%s'", medName);
        Connection conn = null;
        Statement stmt = null;

//        String retrieveQuery;
//        retrieveQuery = String.format("SELECT * from `medic`");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQuery);
            while (rsAccount.next()) {
                medicName = rsAccount.getString("medicineName");
                brandName = rsAccount.getString("brandName");
                genName = rsAccount.getString("genericName");
                price = rsAccount.getString("price");
//                System.out.println(medicName + " " + brandName + " " + genName + " " + price);
                med.add(medicName);
                med.add(brandName);
                med.add(genName);
                med.add(price);
            }
            ResultSet resultSet = stmt.executeQuery(retrieveMed);
            resultSet.next();
            int rowcount = resultSet.getInt(1);
            int x = 0;
            for (int row = 0; row < rowcount; row++) {
                for (int col = 0; col < medTable.getColumnCount(); col++) {
//                    System.out.println(medTable.getValueAt(row, col));
                    medTable.setValueAt(med.get(x), row, col);
                    x++;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBodyPainMouseClicked

    private void btnHeadacheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHeadacheMouseClicked
        med.clear();
        medicineName.setText("Headache");
        String medName = medicineName.getText();
        String medicName = null;
        String brandName = null;
        String genName = null;
        String price = null;

//        String retrieveQuery = String.format("INSERT INTO medic(firstName,age,lastName,userName,password) VALUES ('%s','%d','%s','%s','%s')", firstname, age, lastname,userName,logpass);
        String retrieveQuery = String.format("Select medicineName, brandName, genericName, price from tblMedicine where medicineType='%s'", medName);
        String retrieveMed = String.format("Select COUNT(medicineName) from tblMedicine where medicineType='%s'", medName);
        Connection conn = null;
        Statement stmt = null;

//        String retrieveQuery;
//        retrieveQuery = String.format("SELECT * from `medic`");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQuery);
            while (rsAccount.next()) {
                medicName = rsAccount.getString("medicineName");
                brandName = rsAccount.getString("brandName");
                genName = rsAccount.getString("genericName");
                price = rsAccount.getString("price");
//                System.out.println(medicName + " " + brandName + " " + genName + " " + price);
                med.add(medicName);
                med.add(brandName);
                med.add(genName);
                med.add(price);
            }
            ResultSet resultSet = stmt.executeQuery(retrieveMed);
            resultSet.next();
            int rowcount = resultSet.getInt(1);
            int x = 0;
            for (int row = 0; row < rowcount; row++) {
                for (int col = 0; col < medTable.getColumnCount(); col++) {
//                    System.out.println(medTable.getValueAt(row, col));
                    medTable.setValueAt(med.get(x), row, col);
                    x++;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnHeadacheMouseClicked

    private void btnAllergyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAllergyMouseClicked
        med.clear();
        medicineName.setText("Allergies");
        String medName = medicineName.getText();
        String medicName = null;
        String brandName = null;
        String genName = null;
        String price = null;

//        String retrieveQuery = String.format("INSERT INTO medic(firstName,age,lastName,userName,password) VALUES ('%s','%d','%s','%s','%s')", firstname, age, lastname,userName,logpass);
        String retrieveQuery = String.format("Select medicineName, brandName, genericName, price from tblMedicine where medicineType='%s'", medName);
        String retrieveMed = String.format("Select COUNT(medicineName) from tblMedicine where medicineType='%s'", medName);
        Connection conn = null;
        Statement stmt = null;

//        String retrieveQuery;
//        retrieveQuery = String.format("SELECT * from `medic`");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rsAccount = stmt.executeQuery(retrieveQuery);
            while (rsAccount.next()) {
                medicName = rsAccount.getString("medicineName");
                brandName = rsAccount.getString("brandName");
                genName = rsAccount.getString("genericName");
                price = rsAccount.getString("price");
//                System.out.println(medicName + " " + brandName + " " + genName + " " + price);
                med.add(medicName);
                med.add(brandName);
                med.add(genName);
                med.add(price);
            }
            ResultSet resultSet = stmt.executeQuery(retrieveMed);
            resultSet.next();
            int rowcount = resultSet.getInt(1);
            int x = 0;
            for (int row = 0; row < rowcount; row++) {
                for (int col = 0; col < medTable.getColumnCount(); col++) {
//                    System.out.println(medTable.getValueAt(row, col));
                    medTable.setValueAt(med.get(x), row, col);
                    x++;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAllergyMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        String delete = ("DELETE FROM tblpurchase");
        String updateStatus = String.format("UPDATE tblPharma SET pharmaIdentity='%s'", 0);
        Object[] options = {"Yes",
            "No"};

        int answer = JOptionPane.showOptionDialog(this,
                "Do you really want to logout? ", "Quit:Continue",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (answer == JOptionPane.YES_OPTION) {
            Connection conn = null;
            Statement stmt = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                stmt.executeUpdate(delete);
                stmt.executeUpdate(updateStatus);
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            this.setVisible(false);
            new login().setVisible(true);
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        this.setVisible(false);
        new purchase().setVisible(true);
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
        new viewPurchase().setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        this.setVisible(false);
        new viewAllPurchased().setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        this.setVisible(false);
        new addMed().setVisible(true);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        this.setVisible(false);
        new updateMed().setVisible(true);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(dashboardPharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardPharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardPharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardPharmacist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardPharmacist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Flixotide;
    private javax.swing.JButton btnAllergy;
    private javax.swing.JButton btnBodyPain;
    private javax.swing.JButton btnCough;
    private javax.swing.JButton btnHeadache;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTable medTable;
    private javax.swing.JLabel medicineName;
    private java.awt.TextField search;
    // End of variables declaration//GEN-END:variables
}
