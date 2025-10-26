package com.pcbuilder;

import com.pcbuilder.database.DatabaseManager;
import com.pcbuilder.gui.PCBuilderGUI;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Main Application Entry Point
 */
public class Main {
    public static void main(String[] args) {
        // Initialize database
        System.out.println("Khởi tạo database...");
        initializeDatabase();
        
        // Launch GUI
        System.out.println("Khởi động ứng dụng...");
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            PCBuilderGUI gui = new PCBuilderGUI();
            gui.setVisible(true);
        });
    }
    
    private static void initializeDatabase() {
        try {
            DatabaseManager dbManager = DatabaseManager.getInstance();
            Connection conn = dbManager.getConnection();
            
            // Check if tables exist
            Statement stmt = conn.createStatement();
            try {
                stmt.executeQuery("SELECT COUNT(*) FROM cpu");
                System.out.println("Database đã tồn tại.");
            } catch (Exception e) {
                // Tables don't exist, create them
                System.out.println("Tạo database mới...");
                executeSQLFile(conn, "../Database/schema.sql");
                executeSQLFile(conn, "../Database/sample_data.sql");
                System.out.println("Database đã được tạo thành công!");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khởi tạo database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void executeSQLFile(Connection conn, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Statement stmt = conn.createStatement()) {
            
            StringBuilder sql = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                line = line.trim();
                
                // Skip comments and empty lines
                if (line.isEmpty() || line.startsWith("--")) {
                    continue;
                }
                
                sql.append(line).append(" ");
                
                // Execute when semicolon is found
                if (line.endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql = new StringBuilder();
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi thực thi SQL file " + filePath + ": " + e.getMessage());
        }
    }
}
