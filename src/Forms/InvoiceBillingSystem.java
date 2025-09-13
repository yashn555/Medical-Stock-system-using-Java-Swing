package Forms;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoiceBillingSystem extends JFrame {
    private JTextField searchBar;
    private JList<String> productList;
    private DefaultListModel<String> productListModel;
    private JTable invoiceTable;
    private DefaultTableModel invoiceTableModel;
    private JLabel totalLabel;
    private JButton printButton;
    private JButton backButton;
    private JButton removeButton;
    private JButton clearButton;
    private JButton newCustomerButton;
    private JButton manageProductsButton;
    private JLabel customerLabel;
    private Connection connection;
    private int currentInvoiceId = 1; // Starting invoice ID

    public InvoiceBillingSystem() {
        // Initialize components
        setTitle("Invoice Billing System");
        
        // Create BILLS directory if it doesn't exist
        File billsDir = new File("BILLS");
        if (!billsDir.exists()) {
            billsDir.mkdir();
        }

        // Main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Top panel with customer info and search
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        
        // Customer info panel
        JPanel customerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        customerLabel = new JLabel("Customer: Walk-in Customer");
        customerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        newCustomerButton = createButton("New Customer");
        customerPanel.add(customerLabel);
        customerPanel.add(newCustomerButton);
        topPanel.add(customerPanel, BorderLayout.WEST);
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        searchBar = new JTextField(25);
        searchBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchBar.setToolTipText("Search products...");
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchBar);
        manageProductsButton = createButton("Manage Products");
        searchPanel.add(manageProductsButton);
        topPanel.add(searchPanel, BorderLayout.EAST);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // Center panel with products and invoice
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Products panel
        JPanel productsPanel = new JPanel(new BorderLayout());
        productsPanel.setBorder(BorderFactory.createTitledBorder("Available Products"));
        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        productList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setFixedCellHeight(30);
        JScrollPane productScrollPane = new JScrollPane(productList);
        productScrollPane.setPreferredSize(new Dimension(350, 400));
        productsPanel.add(productScrollPane, BorderLayout.CENTER);
        
        // Invoice panel
        JPanel invoicePanel = new JPanel(new BorderLayout());
        invoicePanel.setBorder(BorderFactory.createTitledBorder("Invoice Items"));
        invoiceTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Integer.class : (columnIndex == 3 ? Double.class : String.class);
            }
        };
        invoiceTableModel.addColumn("Product Name");
        invoiceTableModel.addColumn("Price (₹)");
        invoiceTableModel.addColumn("Quantity");
        invoiceTableModel.addColumn("Subtotal (₹)");
        
        invoiceTable = new JTable(invoiceTableModel);
        invoiceTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        invoiceTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        invoiceTable.setRowHeight(30);
        invoiceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        invoiceTable.setAutoCreateRowSorter(true);
        JScrollPane invoiceScrollPane = new JScrollPane(invoiceTable);
        invoiceScrollPane.setPreferredSize(new Dimension(450, 400));
        invoicePanel.add(invoiceScrollPane, BorderLayout.CENTER);
        
        centerPanel.add(productsPanel);
        centerPanel.add(invoicePanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Bottom panel with totals and buttons
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        
        // Totals panel
        JPanel totalsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        totalLabel = new JLabel("Total: ₹0.00");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalsPanel.add(totalLabel);
        bottomPanel.add(totalsPanel, BorderLayout.WEST);
        
        // Action buttons panel
        JPanel actionButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        removeButton = createButton("Remove Selected (Del)");
        clearButton = createButton("Clear All (Esc)");
        printButton = createButton("Print Bill (Shift+P)");
        backButton = createButton("Back to Main");
        
        actionButtonsPanel.add(removeButton);
        actionButtonsPanel.add(clearButton);
        actionButtonsPanel.add(printButton);
        actionButtonsPanel.add(backButton);
        bottomPanel.add(actionButtonsPanel, BorderLayout.CENTER);
        
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);

        // Database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
            System.exit(1);
        }

        // Key bindings
        setupKeyBindings();

        // Event listeners
        setupEventListeners();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1024, 768));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(180, 35));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return button;
    }

    private void setupKeyBindings() {
        // Shift+P for printing
        InputMap inputMap = printButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = printButton.getActionMap();
        
        KeyStroke shiftP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.SHIFT_DOWN_MASK);
        inputMap.put(shiftP, "printBill");
        actionMap.put("printBill", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInvoice();
            }
        });

        // Enter in search bar moves to product list
        searchBar.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (productListModel.size() > 0) {
                        productList.requestFocus();
                        productList.setSelectedIndex(0);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && productListModel.size() > 0) {
                    productList.requestFocus();
                    productList.setSelectedIndex(0);
                }
            }
        });

        // Product list navigation
        productList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleProductSelection();
                } else if (e.getKeyCode() == KeyEvent.VK_UP && productList.getSelectedIndex() == 0) {
                    searchBar.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    searchBar.requestFocus();
                }
            }
        });

        // Invoice table navigation
        invoiceTable.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    removeSelectedItem();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    clearInvoiceTable();
                }
            }
        });
    }

    private void setupEventListeners() {
        // Search functionality
        searchBar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { search(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { search(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { search(); }
            
            private void search() {
                searchProduct(searchBar.getText());
            }
        });

        // Double click on product list
        productList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    handleProductSelection();
                }
            }
        });

        // Button actions
        printButton.addActionListener(e -> printInvoice());
        backButton.addActionListener(e -> {
            MainPanel MB = new MainPanel();
            MB.setVisible(true);
            dispose();
        });
        removeButton.addActionListener(e -> removeSelectedItem());
        clearButton.addActionListener(e -> clearInvoiceTable());
        newCustomerButton.addActionListener(e -> selectCustomer());
        manageProductsButton.addActionListener(e -> manageProducts());
    }

    private void selectCustomer() {
        String customerName = JOptionPane.showInputDialog(this, "Enter customer name:", "Select Customer", JOptionPane.PLAIN_MESSAGE);
        if (customerName != null && !customerName.trim().isEmpty()) {
            customerLabel.setText("Customer: " + customerName);
        }
    }

    private void manageProducts() {
        JOptionPane.showMessageDialog(this, "Product management feature would open here in a full ERP system.", 
                                   "Manage Products", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleProductSelection() {
        String selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            String quantityString = JOptionPane.showInputDialog(this, 
                "Enter quantity for " + selectedProduct + ":", "Quantity", JOptionPane.QUESTION_MESSAGE);
            if (quantityString != null && !quantityString.trim().isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityString);
                    if (quantity > 0) {
                        addProductToInvoice(selectedProduct, quantity);
                        updateProductQuantity(selectedProduct, quantity);
                    } else {
                        JOptionPane.showMessageDialog(this, "Quantity must be a positive integer.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid quantity entered. Please enter a valid number.");
                }
            }
        }
    }

    private void removeSelectedItem() {
        int selectedRow = invoiceTable.getSelectedRow();
        if (selectedRow >= 0) {
            String productName = (String) invoiceTableModel.getValueAt(selectedRow, 0);
            int quantity = (int) invoiceTableModel.getValueAt(selectedRow, 2);
            
            try {
                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE products SET quantity = quantity + ? WHERE product_name = ?");
                statement.setInt(1, quantity);
                statement.setString(2, productName);
                statement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to update product quantity.");
            }
            
            invoiceTableModel.removeRow(selectedRow);
            updateTotal();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to remove.");
        }
    }

    private void searchProduct(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT product_name FROM products WHERE product_name LIKE '%" + query + "%'");
            productListModel.clear();
            while (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                productListModel.addElement(productName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to search for products.");
        }
    }

    private void addProductToInvoice(String productName, int quantity) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM products WHERE product_name = ? AND quantity >= ?");
            statement.setString(1, productName);
            statement.setInt(2, quantity);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double price = resultSet.getDouble("price_per_unit");
                double subtotal = price * quantity;
                Object[] rowData = {productName, price, quantity, subtotal};
                invoiceTableModel.addRow(rowData);
                updateTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient quantity available in the Stock for " + productName + ".");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while adding product to invoice.");
        }
    }

    private void updateTotal() {
        double total = 0;
        for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
            total += (Double) invoiceTableModel.getValueAt(i, 3);
        }
        totalLabel.setText("Total: ₹" + String.format("%.2f", total));
    }

    private void clearInvoiceTable() {
        if (invoiceTableModel.getRowCount() > 0) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to clear the entire invoice?", 
                "Confirm Clear", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                    String productName = (String) invoiceTableModel.getValueAt(i, 0);
                    int quantity = (Integer) invoiceTableModel.getValueAt(i, 2);
                    
                    try {
                        PreparedStatement statement = connection.prepareStatement(
                            "UPDATE products SET quantity = quantity + ? WHERE product_name = ?");
                        statement.setInt(1, quantity);
                        statement.setString(2, productName);
                        statement.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Failed to update product quantity for " + productName);
                    }
                }
                
                invoiceTableModel.setRowCount(0);
                totalLabel.setText("Total: ₹0.00");
            }
        }
    }
    private int generateUniqueBillId() {
    int maxAttempts = 100; // Increased from 10 to 100
    int attempts = 0;
    
    while (attempts < maxAttempts) {
        // Generate random 5-digit number (10000-99999)
        int newId = 10000 + (int)(Math.random() * 90000);
        
        // Check if ID exists in database
        try (PreparedStatement checkStmt = connection.prepareStatement(
                "SELECT bill_id FROM printed_bills WHERE bill_id = ?")) {
            checkStmt.setInt(1, newId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (!rs.next()) {
                    return newId; // Unique ID found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // If there's an error checking, try again with new ID
        }
        
        attempts++;
    }
    
    // If we couldn't find a unique ID after many attempts
    throw new RuntimeException("Failed to generate unique bill ID after " + maxAttempts + " attempts");
}

    private void printInvoice() {
    if (invoiceTableModel.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No items in the invoice to print.");
        return;
    }
    
    try {
        // Generate random 5-digit bill ID (10000-99999)
        currentInvoiceId = 10000 + (int)(Math.random() * 90000);
        String customerName = customerLabel.getText().replace("Customer: ", "").trim();
        String safeCustomerName = customerName.replaceAll("[^a-zA-Z0-9.-]", "_");
        String PDF_PATH = "BILLS/Invoice_" + currentInvoiceId + "_" + safeCustomerName + ".pdf";
        
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(PDF_PATH));
        document.open();
        
        // Add invoice header
        com.itextpdf.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Paragraph title = new Paragraph("INVOICE #" + currentInvoiceId, titleFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        
        // Add customer info
        document.add(new Paragraph("\nCustomer: " + customerName));
        document.add(new Paragraph("Date: " + new java.util.Date() + "\n"));
        
        // Add items table
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{3, 1, 1, 1});
        
        table.addCell("Product Name");
        table.addCell("Price (₹)");
        table.addCell("Quantity");
        table.addCell("Subtotal (₹)");
        
        for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
            table.addCell((String) invoiceTableModel.getValueAt(i, 0));
            table.addCell(String.format("%.2f", (Double) invoiceTableModel.getValueAt(i, 1)));
            table.addCell(String.valueOf(invoiceTableModel.getValueAt(i, 2)));
            table.addCell(String.format("%.2f", (Double) invoiceTableModel.getValueAt(i, 3)));
        }
        
        document.add(table);
        
        // Add total - Fixed the error by creating the font first
        double total = getTotalAmount();
        com.itextpdf.text.Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
        document.add(new Paragraph("\nTotal Amount: ₹" + String.format("%.2f", total), boldFont));
        
        document.close();
        
        JOptionPane.showMessageDialog(this, "Invoice saved as: " + PDF_PATH);
        storePrintedBillInDatabase();
        clearInvoiceTable();
    } catch (FileNotFoundException | DocumentException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error occurred while saving the invoice as PDF: " + e.getMessage());
    }
}

private void storePrintedBillInDatabase() {
    try {
        connection.setAutoCommit(false); // Start transaction
        
        // First verify the ID is still unique
        try (PreparedStatement checkStmt = connection.prepareStatement(
                "SELECT bill_id FROM printed_bills WHERE bill_id = ?")) {
            checkStmt.setInt(1, currentInvoiceId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    // If ID exists, generate a new one
                    currentInvoiceId = generateUniqueBillId();
                }
            }
        }

        // Now insert records
        double total = getTotalAmount();
        String customerName = customerLabel.getText().replace("Customer: ", "").trim();
        
        String sql = "INSERT INTO printed_bills (bill_id, product_name, price, quantity, subtotal, total, customer_name) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                statement.setInt(1, currentInvoiceId);
                statement.setString(2, (String) invoiceTableModel.getValueAt(i, 0));
                statement.setDouble(3, (Double) invoiceTableModel.getValueAt(i, 1));
                statement.setInt(4, (Integer) invoiceTableModel.getValueAt(i, 2));
                statement.setDouble(5, (Double) invoiceTableModel.getValueAt(i, 3));
                statement.setDouble(6, total);
                statement.setString(7, customerName);
                statement.addBatch(); // Use batch insert for performance
            }
            statement.executeBatch();
        }
        
        connection.commit(); // Commit transaction
        JOptionPane.showMessageDialog(this, "Invoice stored with ID: " + currentInvoiceId);
        
    } catch (SQLException ex) {
        try {
            connection.rollback(); // Rollback on error
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Failed to store invoice. Please try again.\nError: " + ex.getMessage());
    } finally {
        try {
            connection.setAutoCommit(true); // Reset auto-commit
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    private double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
            total += (Double) invoiceTableModel.getValueAt(i, 3);
        }
        return total;
    }

    private void updateProductQuantity(String productName, int quantity) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE products SET quantity = quantity - ? WHERE product_name = ?");
            statement.setInt(1, quantity);
            statement.setString(2, productName);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to update product quantity.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            InvoiceBillingSystem frame = new InvoiceBillingSystem();
            frame.setVisible(true);
        });
    }
}