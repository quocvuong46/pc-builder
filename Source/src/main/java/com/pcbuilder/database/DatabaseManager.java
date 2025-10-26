package com.pcbuilder.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseManager - Áp dụng Singleton Pattern
 * Đảm bảo chỉ có một instance duy nhất kết nối đến database
 * Đây là pattern quan trọng trong quản lý tài nguyên database
 */
public class DatabaseManager {
    // Instance duy nhất (Singleton)
    private static DatabaseManager instance;
    
    // Connection object
    private Connection connection;
    
    // Database configuration
    // Sử dụng đường dẫn tuyệt đối hoặc tương đối từ thư mục chạy
    private static final String DB_URL = "jdbc:sqlite:../Database/pcbuilder.db";
    private static final String DRIVER = "org.sqlite.JDBC";

    /**
     * Private constructor - ngăn việc tạo instance từ bên ngoài
     * Đây là đặc điểm chính của Singleton Pattern
     */
    private DatabaseManager() {
        try {
            // Load SQLite JDBC driver
            Class.forName(DRIVER);
            // Tạo kết nối
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Kết nối database thành công!");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy SQLite JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối database: " + e.getMessage());
        }
    }

    /**
     * Method để lấy instance duy nhất (Singleton Pattern)
     * Synchronized để thread-safe
     */
    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    /**
     * Lấy connection object
     */
    public Connection getConnection() {
        try {
            // Kiểm tra và tạo lại connection nếu bị đóng
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy connection: " + e.getMessage());
        }
        return connection;
    }

    /**
     * Đóng connection
     */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Đã đóng kết nối database.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi đóng connection: " + e.getMessage());
        }
    }

    /**
     * Ngăn việc clone instance (bảo vệ Singleton Pattern)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cannot clone singleton instance");
    }
}
