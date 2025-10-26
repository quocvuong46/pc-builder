-- ================================================
-- PC BUILDER DATABASE SCHEMA
-- SQLite Database cho ứng dụng xây dựng cấu hình máy tính
-- ================================================

-- Bảng CPU
CREATE TABLE IF NOT EXISTS cpu (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    socket VARCHAR(50),
    cores INTEGER,
    base_clock VARCHAR(50)
);

-- Bảng Mainboard
CREATE TABLE IF NOT EXISTS mainboard (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    socket VARCHAR(50),
    chipset VARCHAR(100),
    form_factor VARCHAR(50),
    max_ram INTEGER
);

-- Bảng RAM
CREATE TABLE IF NOT EXISTS ram (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    type VARCHAR(50),
    capacity INTEGER,
    speed VARCHAR(50)
);

-- Bảng VGA
CREATE TABLE IF NOT EXISTS vga (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    chipset VARCHAR(100),
    vram INTEGER,
    memory_type VARCHAR(50)
);

-- Bảng Storage (Ổ cứng)
CREATE TABLE IF NOT EXISTS storage (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    type VARCHAR(50),
    capacity INTEGER,
    read_speed VARCHAR(50),
    write_speed VARCHAR(50)
);

-- Bảng PSU (Nguồn)
CREATE TABLE IF NOT EXISTS psu (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    wattage INTEGER,
    efficiency VARCHAR(50),
    modular BOOLEAN
);

-- Bảng PC Case (Vỏ máy)
CREATE TABLE IF NOT EXISTS pc_case (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    form_factor VARCHAR(50),
    color VARCHAR(50),
    has_rgb BOOLEAN
);

-- Bảng Cooler (Tản nhiệt)
CREATE TABLE IF NOT EXISTS cooler (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    price REAL NOT NULL,
    specifications TEXT,
    type VARCHAR(50),
    socket VARCHAR(100),
    fan_size INTEGER
);
