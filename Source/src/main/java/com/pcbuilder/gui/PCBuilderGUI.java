package com.pcbuilder.gui;

import com.pcbuilder.database.*;
import com.pcbuilder.models.*;
import com.pcbuilder.patterns.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * Main GUI Application cho PC Builder
 * Sử dụng Java Swing để xây dựng giao diện
 */
public class PCBuilderGUI extends JFrame {
    private ComponentDAO dao;
    private BasePCConfiguration currentConfig;
    
    // Combo boxes cho việc chọn linh kiện
    private JComboBox<com.pcbuilder.models.Component> cpuCombo;
    private JComboBox<com.pcbuilder.models.Component> mainboardCombo;
    private JComboBox<com.pcbuilder.models.Component> ramCombo;
    private JComboBox<com.pcbuilder.models.Component> vgaCombo;
    private JComboBox<com.pcbuilder.models.Component> storageCombo;
    private JComboBox<com.pcbuilder.models.Component> psuCombo;
    private JComboBox<com.pcbuilder.models.Component> caseCombo;
    private JComboBox<com.pcbuilder.models.Component> coolerCombo;
    
    // Checkboxes cho các dịch vụ (Decorator Pattern)
    private JCheckBox warrantyCheckBox;
    private JCheckBox assemblyCheckBox;
    private JCheckBox installationCheckBox;
    private JCheckBox discountCheckBox;
    
    // Text areas
    private JTextArea configTextArea;
    private JLabel totalPriceLabel;
    
    // Warranty years spinner
    private JSpinner warrantyYearsSpinner;
    
    public PCBuilderGUI() {
        // Khởi tạo DAO và configuration
        dao = new ComponentDAO();
        currentConfig = new BasePCConfiguration();
        
        // Setup JFrame
        setTitle("PC Builder - Ứng dụng xây dựng cấu hình máy tính");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Initialize components
        initComponents();
        
        // Load data from database
        loadData();
    }
    
    private void initComponents() {
        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Title
        JLabel titleLabel = new JLabel("XÂY DỰNG CẤU HÌNH MÁY TÍNH", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(new EmptyBorder(10, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Center panel - Split into left (components) and right (summary)
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(600);
        
        // Left panel - Component selection
        JPanel leftPanel = createComponentSelectionPanel();
        JScrollPane leftScroll = new JScrollPane(leftPanel);
        splitPane.setLeftComponent(leftScroll);
        
        // Right panel - Configuration summary
        JPanel rightPanel = createSummaryPanel();
        splitPane.setRightComponent(rightPanel);
        
        mainPanel.add(splitPane, BorderLayout.CENTER);
        
        // Bottom panel - Total price and actions
        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createComponentSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Chọn linh kiện"));
        
        // CPU
        panel.add(createComponentRow("CPU:", cpuCombo = new JComboBox<>()));
        
        // Mainboard
        panel.add(createComponentRow("Mainboard:", mainboardCombo = new JComboBox<>()));
        
        // RAM
        panel.add(createComponentRow("RAM:", ramCombo = new JComboBox<>()));
        
        // VGA
        panel.add(createComponentRow("VGA:", vgaCombo = new JComboBox<>()));
        
        // Storage
        panel.add(createComponentRow("Ổ cứng:", storageCombo = new JComboBox<>()));
        
        // PSU
        panel.add(createComponentRow("Nguồn:", psuCombo = new JComboBox<>()));
        
        // Case
        panel.add(createComponentRow("Case:", caseCombo = new JComboBox<>()));
        
        // Cooler
        panel.add(createComponentRow("Tản nhiệt:", coolerCombo = new JComboBox<>()));
        
        // Services section (Decorator Pattern)
        panel.add(Box.createVerticalStrut(20));
        panel.add(createServicesPanel());
        
        return panel;
    }
    
    private JPanel createComponentRow(String label, JComboBox<com.pcbuilder.models.Component> combo) {
        JPanel row = new JPanel(new BorderLayout(5, 5));
        row.setBorder(new EmptyBorder(5, 5, 5, 5));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        
        JLabel labelComponent = new JLabel(label);
        labelComponent.setPreferredSize(new Dimension(100, 25));
        labelComponent.setFont(new Font("Arial", Font.BOLD, 12));
        
        combo.addActionListener(e -> updateConfiguration());
        
        row.add(labelComponent, BorderLayout.WEST);
        row.add(combo, BorderLayout.CENTER);
        
        return row;
    }
    
    private JPanel createServicesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Dịch vụ bổ sung (Decorator Pattern)"));
        
        // Warranty
        JPanel warrantyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        warrantyCheckBox = new JCheckBox("Bảo hành mở rộng");
        warrantyCheckBox.addActionListener(e -> {
            warrantyYearsSpinner.setEnabled(warrantyCheckBox.isSelected());
            updateConfiguration();
        });
        warrantyPanel.add(warrantyCheckBox);
        warrantyPanel.add(new JLabel("Số năm:"));
        warrantyYearsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        warrantyYearsSpinner.setEnabled(false);
        warrantyYearsSpinner.addChangeListener(e -> updateConfiguration());
        warrantyPanel.add(warrantyYearsSpinner);
        panel.add(warrantyPanel);
        
        // Assembly
        assemblyCheckBox = new JCheckBox("Dịch vụ lắp ráp và test (+500,000 VNĐ)");
        assemblyCheckBox.addActionListener(e -> updateConfiguration());
        panel.add(assemblyCheckBox);
        
        // Installation
        installationCheckBox = new JCheckBox("Cài đặt Windows & phần mềm (+300,000 VNĐ)");
        installationCheckBox.addActionListener(e -> updateConfiguration());
        panel.add(installationCheckBox);
        
        // Discount
        discountCheckBox = new JCheckBox("Áp dụng giảm giá 10% (Khách hàng thân thiết)");
        discountCheckBox.addActionListener(e -> updateConfiguration());
        panel.add(discountCheckBox);
        
        return panel;
    }
    
    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new TitledBorder("Cấu hình đã chọn"));
        
        configTextArea = new JTextArea();
        configTextArea.setEditable(false);
        configTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        configTextArea.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(configTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // Total price
        totalPriceLabel = new JLabel("TỔNG GIÁ: 0 VNĐ", SwingConstants.CENTER);
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalPriceLabel.setForeground(new Color(220, 20, 60));
        panel.add(totalPriceLabel, BorderLayout.NORTH);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton resetButton = new JButton("Làm mới");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.addActionListener(e -> resetConfiguration());
        buttonPanel.add(resetButton);
        
        JButton detailButton = new JButton("Xem chi tiết");
        detailButton.setFont(new Font("Arial", Font.PLAIN, 14));
        detailButton.addActionListener(e -> showDetailDialog());
        buttonPanel.add(detailButton);
        
        JButton exportButton = new JButton("Xuất cấu hình");
        exportButton.setFont(new Font("Arial", Font.PLAIN, 14));
        exportButton.addActionListener(e -> exportConfiguration());
        buttonPanel.add(exportButton);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void loadData() {
        // Load CPUs
        List<CPU> cpus = dao.getAllCPUs();
        cpuCombo.addItem(null); // Add empty option
        for (CPU cpu : cpus) {
            cpuCombo.addItem(cpu);
        }
        
        // Load Mainboards
        List<Mainboard> mainboards = dao.getAllMainboards();
        mainboardCombo.addItem(null);
        for (Mainboard mb : mainboards) {
            mainboardCombo.addItem(mb);
        }
        
        // Load RAMs
        List<RAM> rams = dao.getAllRAMs();
        ramCombo.addItem(null);
        for (RAM ram : rams) {
            ramCombo.addItem(ram);
        }
        
        // Load VGAs
        List<VGA> vgas = dao.getAllVGAs();
        vgaCombo.addItem(null);
        for (VGA vga : vgas) {
            vgaCombo.addItem(vga);
        }
        
        // Load Storages
        List<Storage> storages = dao.getAllStorages();
        storageCombo.addItem(null);
        for (Storage storage : storages) {
            storageCombo.addItem(storage);
        }
        
        // Load PSUs
        List<PSU> psus = dao.getAllPSUs();
        psuCombo.addItem(null);
        for (PSU psu : psus) {
            psuCombo.addItem(psu);
        }
        
        // Load Cases
        List<Case> cases = dao.getAllCases();
        caseCombo.addItem(null);
        for (Case pcCase : cases) {
            caseCombo.addItem(pcCase);
        }
        
        // Load Coolers
        List<Cooler> coolers = dao.getAllCoolers();
        coolerCombo.addItem(null);
        for (Cooler cooler : coolers) {
            coolerCombo.addItem(cooler);
        }
    }
    
    private void updateConfiguration() {
        // Create new base configuration
        currentConfig = new BasePCConfiguration();
        
        // Set selected components
        currentConfig.setCpu((CPU) cpuCombo.getSelectedItem());
        currentConfig.setMainboard((Mainboard) mainboardCombo.getSelectedItem());
        currentConfig.setRam((RAM) ramCombo.getSelectedItem());
        currentConfig.setVga((VGA) vgaCombo.getSelectedItem());
        currentConfig.setStorage((Storage) storageCombo.getSelectedItem());
        currentConfig.setPsu((PSU) psuCombo.getSelectedItem());
        currentConfig.setPcCase((Case) caseCombo.getSelectedItem());
        currentConfig.setCooler((Cooler) coolerCombo.getSelectedItem());
        
        // Apply decorators based on checkboxes
        PCConfiguration finalConfig = currentConfig;
        
        if (warrantyCheckBox.isSelected()) {
            int years = (Integer) warrantyYearsSpinner.getValue();
            finalConfig = new WarrantyDecorator(finalConfig, years);
        }
        
        if (assemblyCheckBox.isSelected()) {
            finalConfig = new AssemblyServiceDecorator(finalConfig);
        }
        
        if (installationCheckBox.isSelected()) {
            finalConfig = new InstallationServiceDecorator(finalConfig);
        }
        
        if (discountCheckBox.isSelected()) {
            finalConfig = new DiscountDecorator(finalConfig, 10.0, "Khách hàng thân thiết");
        }
        
        // Update display
        configTextArea.setText(finalConfig.getDescription());
        totalPriceLabel.setText(String.format("TỔNG GIÁ: %,.0f VNĐ", finalConfig.getPrice()));
    }
    
    private void resetConfiguration() {
        cpuCombo.setSelectedIndex(0);
        mainboardCombo.setSelectedIndex(0);
        ramCombo.setSelectedIndex(0);
        vgaCombo.setSelectedIndex(0);
        storageCombo.setSelectedIndex(0);
        psuCombo.setSelectedIndex(0);
        caseCombo.setSelectedIndex(0);
        coolerCombo.setSelectedIndex(0);
        
        warrantyCheckBox.setSelected(false);
        assemblyCheckBox.setSelected(false);
        installationCheckBox.setSelected(false);
        discountCheckBox.setSelected(false);
        warrantyYearsSpinner.setEnabled(false);
        
        updateConfiguration();
    }
    
    private void showDetailDialog() {
        JDialog dialog = new JDialog(this, "Chi tiết cấu hình", true);
        dialog.setSize(600, 700);
        dialog.setLocationRelativeTo(this);
        
        JTextArea detailArea = new JTextArea(currentConfig.getDetailedDescription());
        detailArea.setEditable(false);
        detailArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        detailArea.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(detailArea);
        dialog.add(scrollPane);
        
        dialog.setVisible(true);
    }
    
    private void exportConfiguration() {
        // Kiểm tra xem đã chọn linh kiện chưa
        if (currentConfig.getCpu() == null && currentConfig.getMainboard() == null && 
            currentConfig.getRam() == null && currentConfig.getVga() == null) {
            JOptionPane.showMessageDialog(this,
                "Vui lòng chọn ít nhất một linh kiện trước khi xuất cấu hình!",
                "Thông báo",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Tạo file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu cấu hình");
        
        // Đặt tên file mặc định với timestamp
        String defaultFileName = "CauHinh_PC_" + 
            new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date()) + ".txt";
        fileChooser.setSelectedFile(new java.io.File(defaultFileName));
        
        // Chỉ cho phép lưu file .txt
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            
            // Đảm bảo file có đuôi .txt
            if (!fileToSave.getName().endsWith(".txt")) {
                fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".txt");
            }
            
            try {
                // Tạo nội dung xuất file với format đẹp
                String content = generateExportContent();
                
                // Ghi file
                try (java.io.FileWriter writer = new java.io.FileWriter(fileToSave)) {
                    writer.write(content);
                }
                
                // Hiển thị thông báo thành công
                int result = JOptionPane.showConfirmDialog(this,
                    "Xuất cấu hình thành công!\nFile: " + fileToSave.getName() + 
                    "\n\nBạn có muốn mở file không?",
                    "Thành công",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Mở file nếu người dùng chọn Yes
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        java.awt.Desktop.getDesktop().open(fileToSave);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this,
                            "Không thể mở file. Vui lòng mở thủ công tại:\n" + fileToSave.getAbsolutePath(),
                            "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    "Lỗi khi xuất file: " + ex.getMessage(),
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
    
    private String generateExportContent() {
        StringBuilder content = new StringBuilder();
        
        // Header
        content.append("================================================================================\n");
        content.append("                    BÁO GIÁ CẤU HÌNH MÁY TÍNH\n");
        content.append("                        PC BUILDER\n");
        content.append("================================================================================\n\n");
        
        // Thông tin ngày xuất
        String dateTime = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        content.append("Ngày xuất: ").append(dateTime).append("\n\n");
        
        content.append("================================================================================\n");
        content.append("                        LINH KIỆN ĐÃ CHỌN\n");
        content.append("================================================================================\n\n");
        
        // Chi tiết từng linh kiện
        if (currentConfig.getCpu() != null) {
            content.append(currentConfig.getCpu().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getMainboard() != null) {
            content.append(currentConfig.getMainboard().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getRam() != null) {
            content.append(currentConfig.getRam().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getVga() != null) {
            content.append(currentConfig.getVga().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getStorage() != null) {
            content.append(currentConfig.getStorage().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getPsu() != null) {
            content.append(currentConfig.getPsu().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getPcCase() != null) {
            content.append(currentConfig.getPcCase().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        if (currentConfig.getCooler() != null) {
            content.append(currentConfig.getCooler().getDetails()).append("\n");
            content.append("--------------------------------------------------------------------------------\n\n");
        }
        
        // Dịch vụ bổ sung (nếu có)
        content.append("================================================================================\n");
        content.append("                        DỊCH VỤ BỔ SUNG\n");
        content.append("================================================================================\n\n");
        
        boolean hasService = false;
        
        if (warrantyCheckBox.isSelected()) {
            int years = (Integer) warrantyYearsSpinner.getValue();
            double cost = currentConfig.getPrice() * 0.05 * years;
            content.append(String.format("✓ Bảo hành mở rộng %d năm: %,d VNĐ\n", years, (int)cost));
            hasService = true;
        }
        
        if (assemblyCheckBox.isSelected()) {
            content.append("✓ Dịch vụ lắp ráp và test: 500,000 VNĐ\n");
            hasService = true;
        }
        
        if (installationCheckBox.isSelected()) {
            content.append("✓ Cài đặt Windows & phần mềm: 300,000 VNĐ\n");
            hasService = true;
        }
        
        if (discountCheckBox.isSelected()) {
            double discountAmount = currentConfig.getPrice() * 0.10;
            content.append(String.format("✓ Giảm giá 10%% (Khách hàng thân thiết): -%,d VNĐ\n", (int)discountAmount));
            hasService = true;
        }
        
        if (!hasService) {
            content.append("Không có dịch vụ bổ sung.\n");
        }
        
        content.append("\n");
        
        // Tổng giá
        content.append("================================================================================\n");
        content.append("                        TỔNG KẾT GIÁ TRỊ\n");
        content.append("================================================================================\n\n");
        
        // Tính giá với decorator pattern
        PCConfiguration finalConfig = currentConfig;
        double basePrice = currentConfig.getPrice();
        
        if (warrantyCheckBox.isSelected()) {
            int years = (Integer) warrantyYearsSpinner.getValue();
            finalConfig = new WarrantyDecorator(finalConfig, years);
        }
        
        if (assemblyCheckBox.isSelected()) {
            finalConfig = new AssemblyServiceDecorator(finalConfig);
        }
        
        if (installationCheckBox.isSelected()) {
            finalConfig = new InstallationServiceDecorator(finalConfig);
        }
        
        if (discountCheckBox.isSelected()) {
            finalConfig = new DiscountDecorator(finalConfig, 10.0, "Khách hàng thân thiết");
        }
        
        content.append(String.format("Tổng giá linh kiện:          %,d VNĐ\n", (int)basePrice));
        content.append(String.format("TỔNG THANH TOÁN:             %,d VNĐ\n", (int)finalConfig.getPrice()));
        
        content.append("\n================================================================================\n");
        content.append("                        GHI CHÚ\n");
        content.append("================================================================================\n\n");
        
        content.append("- Giá trên đã bao gồm VAT\n");
        content.append("- Bảo hành theo chính sách của từng hãng\n");
        content.append("- Cấu hình có thể thay đổi theo nhu cầu\n");
        content.append("- Liên hệ để được tư vấn chi tiết\n\n");
        
        content.append("================================================================================\n");
        content.append("                    Cảm ơn quý khách đã tin tưởng!\n");
        content.append("                        PC BUILDER TEAM\n");
        content.append("================================================================================\n");
        
        return content.toString();
    }
    
    public static void main(String[] args) {
        // Set Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show GUI
        SwingUtilities.invokeLater(() -> {
            PCBuilderGUI gui = new PCBuilderGUI();
            gui.setVisible(true);
        });
    }
}
