package Forms.Medicines;
import Forms.ConnectionToDatabase;
import Forms.MainPanel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JFrame;
public class MedicinesPanel extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
String productName,companyName,productCategory,quantity,price_per_unit;
 String tableClicked = "";
    public MedicinesPanel() {
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

        insertMedBtn = new javax.swing.JButton();
        updateMedBtn = new javax.swing.JButton();
        delMedBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        searchTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        insertMedBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        insertMedBtn.setText("Insert Medicines");
        insertMedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMedBtnActionPerformed(evt);
            }
        });

        updateMedBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        updateMedBtn.setText("Update Medicines");
        updateMedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMedBtnActionPerformed(evt);
            }
        });

        delMedBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        delMedBtn.setText("Delete Medicines");
        delMedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delMedBtnActionPerformed(evt);
            }
        });

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
        medicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicineTable);

        searchTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        searchBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1352, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(insertMedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateMedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delMedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(55, 55, 55)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(169, 169, 169)))
                    .addContainerGap(33, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(insertMedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(updateMedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(delMedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(234, 234, 234)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertMedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMedBtnActionPerformed
       InsertMedicines im = new InsertMedicines();
       close();
       im.setVisible(true);        
    }//GEN-LAST:event_insertMedBtnActionPerformed

    private void updateMedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMedBtnActionPerformed
            if ("".equals(tableClicked)){
                JOptionPane.showMessageDialog(null, "Please select a product to update!");
            }else{
                
                UpdateMedicines up = new UpdateMedicines();
                up.productName = this.productName;
                up.productNameTxt.setText(productName);
                up.companyNameTxt.setText(companyName);
                up.productCategoryTxt.setText(productCategory);
                up.productQuantityTxt.setText(quantity);
                up.productPriceTxt.setText(price_per_unit);
                close();
                up.setVisible(true);
            }
    }//GEN-LAST:event_updateMedBtnActionPerformed

    private void delMedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delMedBtnActionPerformed
         if ("".equals(tableClicked)){
                JOptionPane.showMessageDialog(null, "Please select a product to delete!");
         }else{
             int des = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?","Delete",JOptionPane.YES_NO_OPTION);
             if (des==0){
                   try{
                    String sql = "DELETE FROM products WHERE product_name='"+tableClicked+"'";
                    pst = conn.prepareStatement(sql);
                    pst.execute();
                    pst.close();
                    rs.close();
                    updateTable();
                    JOptionPane.showMessageDialog(null, "Product has been deleted!");
               }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
             } 
         }
    }//GEN-LAST:event_delMedBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

    }//GEN-LAST:event_searchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        MainPanel mp = new MainPanel();
        close();
        mp.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
  
    }//GEN-LAST:event_formMouseClicked

    private void medicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineTableMouseClicked
         try{
           int row = medicineTable.getSelectedRow();
            tableClicked = (medicineTable.getModel().getValueAt(row, 0).toString());
           String sql = "SELECT * FROM products WHERE product_name =  '"+ tableClicked +"'";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           if(rs.next()){
               productName = rs.getString("product_name");
               companyName = rs.getString("company_name");
               productCategory = rs.getString("product_category");
               quantity = rs.getString("quantity");
               price_per_unit = rs.getString("price_per_unit");
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }    
    }//GEN-LAST:event_medicineTableMouseClicked

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
            java.util.logging.Logger.getLogger(MedicinesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicinesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicinesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicinesPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicinesPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton delMedBtn;
    private javax.swing.JButton insertMedBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicineTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateMedBtn;
    // End of variables declaration//GEN-END:variables
}
