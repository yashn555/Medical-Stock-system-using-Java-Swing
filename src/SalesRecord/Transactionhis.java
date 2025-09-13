package SalesRecord;
import Forms.ConnectionToDatabase;
import Forms.MainPanel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JFrame;
public class Transactionhis extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int selectedBillId = -1;

    public Transactionhis() {
        initComponents();
        conn = ConnectionToDatabase.connectToDb();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        updateTable();
    }

    public void close() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }

    private void updateTable() {
        try {
            String sql = "SELECT bill_id as 'Bill ID', " +
                         "customer_name as 'Customer', " +
                         "product_name as 'Product', " +
                         "price as 'Price', " +
                         "quantity as 'Qty', " +
                         "subtotal as 'Subtotal', " +
                         "total as 'Total', " +
                         "bill_date as 'Date' " +
                         "FROM printed_bills " +
                         "ORDER BY bill_date DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            medicineTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

     private void searchTransactions() {
        String searchTerm = searchTxt.getText().trim();
        try {
            String sql = "SELECT bill_id as 'Bill ID', " +
                         "customer_name as 'Customer', " +
                         "product_name as 'Product', " +
                         "price as 'Price', " +
                         "quantity as 'Qty', " +
                         "subtotal as 'Subtotal', " +
                         "total as 'Total', " +
                         "bill_date as 'Date' " +
                         "FROM printed_bills " +
                         "WHERE product_name LIKE ? OR customer_name LIKE ? " +
                         "ORDER BY bill_date DESC";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + searchTerm + "%");
            pst.setString(2, "%" + searchTerm + "%");
            rs = pst.executeQuery();
            medicineTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void deleteRecord() {
        if (selectedBillId == -1) {
            JOptionPane.showMessageDialog(null, "Please select a record to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null, 
            "Are you sure you want to delete this record?", 
            "Delete", 
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM printed_bills WHERE bill_id = ?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, selectedBillId);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
                updateTable();
                selectedBillId = -1; // Reset selection
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error deleting record: " + e.getMessage());
            } finally {
                try {
                    if (pst != null) pst.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        delRecordBtn = new javax.swing.JButton();
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

        delRecordBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        delRecordBtn.setText("Delete Record");
        delRecordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delRecordBtnActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(delRecordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1057, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(delRecordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(483, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBtn))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delRecordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delRecordBtnActionPerformed
            deleteRecord();
              
    }//GEN-LAST:event_delRecordBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
searchTransactions();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        MainPanel mp = new MainPanel();
        close();
        mp.setVisible(true);
       
    }//GEN-LAST:event_backBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
  
    }//GEN-LAST:event_formMouseClicked

    private void medicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineTableMouseClicked
         try {
            int row = medicineTable.getSelectedRow();
            selectedBillId = Integer.parseInt(medicineTable.getModel().getValueAt(row, 0).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error selecting record: " + e.getMessage());
        }
    
         
    }//GEN-LAST:event_medicineTableMouseClicked

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactionhis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton delRecordBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable medicineTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
