package Forms;
import ChangePassword.ChangePassword;
import Companies.CompaniesPanel;
import Createuser.CreateUser;
import Forms.Medicines.MedicinesPanel;
import NewSalesRecord.NewSalesRecord;
import ProductCategory.AddCategory;
import SalesRecord.SalesRecord;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;
public class MainPanel extends javax.swing.JFrame  {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
    public MainPanel() {
        initComponents();
        conn = ConnectionToDatabase.connectToDb();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        updateTable();       
    }
     public void close(){
        WindowEvent we = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    private void updateTable(){
   
        try{
          String sql = "SELECT  product_name as 'Product Name',company_name as 'Company Name',product_category as 'Product Category',quantity as 'Quantity',price_per_unit as 'Price Per Unit' FROM products";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            medicineTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        medicineBtn = new javax.swing.JButton();
        companiesBtn = new javax.swing.JButton();
        viewSalesRecordsBtn = new javax.swing.JButton();
        newSalesBtn = new javax.swing.JButton();
        changePasswordBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        createUserBtn = new javax.swing.JButton();
        addNewProductCategoryBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        newSalesBtn1 = new javax.swing.JButton();
        newSalesBtn2 = new javax.swing.JButton();
        viewSalesRecordsBtn1 = new javax.swing.JButton();
        viewSalesRecordsBtn2 = new javax.swing.JButton();
        viewSalesRecordsBtn3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });
        getContentPane().add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 173, 360, 30));

        medicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        medicineTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(medicineTable);
        medicineTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 1340, 580));

        medicineBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        medicineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Drug-basket-icon.png"))); // NOI18N
        medicineBtn.setText("Medicines");
        medicineBtn.setIconTextGap(20);
        medicineBtn.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Drug-basket-icon.png"))); // NOI18N
        medicineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineBtnActionPerformed(evt);
            }
        });
        getContentPane().add(medicineBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 270, 50));

        companiesBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        companiesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/companies-icon.png"))); // NOI18N
        companiesBtn.setText("Companies");
        companiesBtn.setIconTextGap(20);
        companiesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companiesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(companiesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 270, 50));

        viewSalesRecordsBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        viewSalesRecordsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/sales-report-icon.png"))); // NOI18N
        viewSalesRecordsBtn.setText("View Sale Records");
        viewSalesRecordsBtn.setIconTextGap(20);
        viewSalesRecordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalesRecordsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(viewSalesRecordsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 270, 50));

        newSalesBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        newSalesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/shop-cart-add-icon.png"))); // NOI18N
        newSalesBtn.setText("New Sales");
        newSalesBtn.setIconTextGap(20);
        newSalesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSalesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(newSalesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 270, 60));

        changePasswordBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        changePasswordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Apps-system-software-update-icon.png"))); // NOI18N
        changePasswordBtn.setText("Change Password");
        changePasswordBtn.setIconTextGap(20);
        changePasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordBtnActionPerformed(evt);
            }
        });
        getContentPane().add(changePasswordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 270, 60));

        logOutBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Apps-session-logout-icon.png"))); // NOI18N
        logOutBtn.setText("Log Out");
        logOutBtn.setIconTextGap(20);
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        getContentPane().add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 70, 290, 60));

        createUserBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        createUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Actions-list-add-user-icon.png"))); // NOI18N
        createUserBtn.setText("Create User");
        createUserBtn.setIconTextGap(20);
        createUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserBtnActionPerformed(evt);
            }
        });
        getContentPane().add(createUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 670, 270, 60));

        addNewProductCategoryBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addNewProductCategoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/category-item-icon.png"))); // NOI18N
        addNewProductCategoryBtn.setText("Add New Product Category");
        addNewProductCategoryBtn.setIconTextGap(20);
        addNewProductCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewProductCategoryBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addNewProductCategoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 270, 60));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Search Product");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/1496840183_si-duo-test-tube.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setText("Medical Store Management System");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 73, 627, -1));

        newSalesBtn1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        newSalesBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/shop-cart-add-icon.png"))); // NOI18N
        newSalesBtn1.setText("BILLING ");
        newSalesBtn1.setIconTextGap(20);
        newSalesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSalesBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(newSalesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 250, 50));

        newSalesBtn2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        newSalesBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/shop-cart-add-icon.png"))); // NOI18N
        newSalesBtn2.setText("MARG BILLING ");
        newSalesBtn2.setIconTextGap(20);
        newSalesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSalesBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(newSalesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 70, 270, 50));

        viewSalesRecordsBtn1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        viewSalesRecordsBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/sales-report-icon.png"))); // NOI18N
        viewSalesRecordsBtn1.setText("View Sale Records");
        viewSalesRecordsBtn1.setIconTextGap(20);
        viewSalesRecordsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalesRecordsBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(viewSalesRecordsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 270, 50));

        viewSalesRecordsBtn2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        viewSalesRecordsBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/sales-report-icon.png"))); // NOI18N
        viewSalesRecordsBtn2.setText("View Sale Records");
        viewSalesRecordsBtn2.setIconTextGap(20);
        viewSalesRecordsBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalesRecordsBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(viewSalesRecordsBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 270, 50));

        viewSalesRecordsBtn3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        viewSalesRecordsBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/sales-report-icon.png"))); // NOI18N
        viewSalesRecordsBtn3.setText("View Sale Records");
        viewSalesRecordsBtn3.setIconTextGap(20);
        viewSalesRecordsBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalesRecordsBtn3ActionPerformed(evt);
            }
        });
        getContentPane().add(viewSalesRecordsBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 270, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void medicineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineBtnActionPerformed
          MedicinesPanel mp = new MedicinesPanel();
        close();
        mp.setVisible(true);
    }//GEN-LAST:event_medicineBtnActionPerformed

    private void companiesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companiesBtnActionPerformed
        CompaniesPanel cp = new CompaniesPanel();
        close();
        cp.setVisible(true);
    }//GEN-LAST:event_companiesBtnActionPerformed

    private void viewSalesRecordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalesRecordsBtnActionPerformed
        SalesRecord sr = new SalesRecord();
        close();
        sr.setVisible(true);
    }//GEN-LAST:event_viewSalesRecordsBtnActionPerformed

    private void newSalesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSalesBtnActionPerformed
        NewSalesRecord nsr =  new NewSalesRecord();
        close();
        nsr.setVisible(true);
    }//GEN-LAST:event_newSalesBtnActionPerformed

    private void changePasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordBtnActionPerformed
        ChangePassword cp = new ChangePassword();
        close();
        cp.setVisible(true);
    }//GEN-LAST:event_changePasswordBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        Login l  = new Login();
        close();
        l.setVisible(true);
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void createUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserBtnActionPerformed
        CreateUser cu = new CreateUser();
        close();
        cu.setVisible(true);
    }//GEN-LAST:event_createUserBtnActionPerformed

    private void addNewProductCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewProductCategoryBtnActionPerformed
           AddCategory ac = new AddCategory();
           ac.setVisible(true);
    }//GEN-LAST:event_addNewProductCategoryBtnActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
              try{
          String sql = "SELECT  product_name as 'Product Name',company_name as 'Company Name',product_category as 'Product Category',quantity as 'Quantity',price_per_unit as 'Price Per Unit' FROM products WHERE product_name LIKE '%"+ searchTxt.getText() +"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            medicineTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void newSalesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSalesBtn1ActionPerformed
        // TODO add your handling code here:
        InvoiceBillingSystem IB= new InvoiceBillingSystem();
        IB.setVisible(true);
    IB.setLocationRelativeTo(null);
    dispose();    
    }//GEN-LAST:event_newSalesBtn1ActionPerformed

    private void newSalesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSalesBtn2ActionPerformed
        // TODO add your handling code here:
        String url = "https://emarg.net/CompanyLogin/CompanyLogin"; 
    
    // Check if the Desktop API is supported
    if (Desktop.isDesktopSupported()) {
        Desktop desktop = Desktop.getDesktop();
        try {
            // Open the default browser with the specified URL
            desktop.browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Failed to open browser: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Desktop API is not supported.");
    }

    }//GEN-LAST:event_newSalesBtn2ActionPerformed

    private void viewSalesRecordsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalesRecordsBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewSalesRecordsBtn1ActionPerformed

    private void viewSalesRecordsBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalesRecordsBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewSalesRecordsBtn2ActionPerformed

    private void viewSalesRecordsBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalesRecordsBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewSalesRecordsBtn3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               /* if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewProductCategoryBtn;
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JButton companiesBtn;
    private javax.swing.JButton createUserBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton medicineBtn;
    private javax.swing.JTable medicineTable;
    private javax.swing.JButton newSalesBtn;
    private javax.swing.JButton newSalesBtn1;
    private javax.swing.JButton newSalesBtn2;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton viewSalesRecordsBtn;
    private javax.swing.JButton viewSalesRecordsBtn1;
    private javax.swing.JButton viewSalesRecordsBtn2;
    private javax.swing.JButton viewSalesRecordsBtn3;
    // End of variables declaration//GEN-END:variables

    
}
