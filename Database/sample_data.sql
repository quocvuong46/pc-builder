-- ================================================
-- SAMPLE DATA FOR PC BUILDER DATABASE
-- Dữ liệu mẫu cho ứng dụng xây dựng cấu hình máy tính
-- ================================================

-- CPU Data
INSERT INTO cpu (name, manufacturer, price, specifications, socket, cores, base_clock) VALUES
('Intel Core i9-13900K', 'Intel', 13500000, '24 nhân 32 luồng, cache 36MB', 'LGA1700', 24, '3.0 GHz'),
('Intel Core i7-13700K', 'Intel', 10500000, '16 nhân 24 luồng, cache 30MB', 'LGA1700', 16, '3.4 GHz'),
('Intel Core i5-13600K', 'Intel', 8000000, '14 nhân 20 luồng, cache 24MB', 'LGA1700', 14, '3.5 GHz'),
('AMD Ryzen 9 7950X', 'AMD', 15000000, '16 nhân 32 luồng, cache 80MB', 'AM5', 16, '4.5 GHz'),
('AMD Ryzen 7 7700X', 'AMD', 9500000, '8 nhân 16 luồng, cache 40MB', 'AM5', 8, '4.5 GHz'),
('AMD Ryzen 5 7600X', 'AMD', 7000000, '6 nhân 12 luồng, cache 38MB', 'AM5', 6, '4.7 GHz');

-- Mainboard Data
INSERT INTO mainboard (name, manufacturer, price, specifications, socket, chipset, form_factor, max_ram) VALUES
('ASUS ROG MAXIMUS Z790 HERO', 'ASUS', 13000000, 'PCIe 5.0, DDR5, WiFi 6E', 'LGA1700', 'Z790', 'ATX', 128),
('MSI MAG Z790 TOMAHAWK', 'MSI', 8500000, 'PCIe 5.0, DDR5, WiFi 6E', 'LGA1700', 'Z790', 'ATX', 128),
('Gigabyte B760M DS3H', 'Gigabyte', 3500000, 'PCIe 4.0, DDR5', 'LGA1700', 'B760', 'Micro-ATX', 64),
('ASUS ROG STRIX X670E-E', 'ASUS', 15000000, 'PCIe 5.0, DDR5, WiFi 6E', 'AM5', 'X670E', 'ATX', 128),
('MSI PRO B650-P', 'MSI', 4500000, 'PCIe 4.0, DDR5', 'AM5', 'B650', 'ATX', 128),
('Gigabyte X670 AORUS ELITE', 'Gigabyte', 7500000, 'PCIe 5.0, DDR5, WiFi 6', 'AM5', 'X670', 'ATX', 128);

-- RAM Data
INSERT INTO ram (name, manufacturer, price, specifications, type, capacity, speed) VALUES
('Corsair Vengeance RGB 32GB (2x16GB)', 'Corsair', 3500000, 'RGB lighting, XMP 3.0', 'DDR5', 32, '6000MHz'),
('G.Skill Trident Z5 RGB 32GB (2x16GB)', 'G.Skill', 4000000, 'RGB lighting, XMP 3.0', 'DDR5', 32, '6400MHz'),
('Kingston Fury Beast 16GB (2x8GB)', 'Kingston', 1800000, 'Low profile, XMP ready', 'DDR5', 16, '5200MHz'),
('Corsair Dominator Platinum 64GB (2x32GB)', 'Corsair', 8500000, 'Premium RGB, XMP 3.0', 'DDR5', 64, '6200MHz'),
('TeamGroup T-Force Delta RGB 32GB (2x16GB)', 'TeamGroup', 3000000, 'RGB lighting', 'DDR5', 32, '6000MHz'),
('ADATA XPG Lancer 16GB (2x8GB)', 'ADATA', 1600000, 'Low profile', 'DDR5', 16, '5200MHz');

-- VGA Data
INSERT INTO vga (name, manufacturer, price, specifications, chipset, vram, memory_type) VALUES
('NVIDIA RTX 4090 ASUS ROG STRIX', 'ASUS', 55000000, 'Ray Tracing, DLSS 3.0', 'RTX 4090', 24, 'GDDR6X'),
('NVIDIA RTX 4080 MSI GAMING X TRIO', 'MSI', 35000000, 'Ray Tracing, DLSS 3.0', 'RTX 4080', 16, 'GDDR6X'),
('NVIDIA RTX 4070 Ti Gigabyte GAMING OC', 'Gigabyte', 25000000, 'Ray Tracing, DLSS 3.0', 'RTX 4070 Ti', 12, 'GDDR6X'),
('AMD RX 7900 XTX Sapphire NITRO+', 'Sapphire', 30000000, 'Ray Tracing, FSR 3.0', 'RX 7900 XTX', 24, 'GDDR6'),
('AMD RX 7800 XT PowerColor Red Devil', 'PowerColor', 18000000, 'Ray Tracing, FSR 3.0', 'RX 7800 XT', 16, 'GDDR6'),
('NVIDIA RTX 4060 Ti ASUS DUAL', 'ASUS', 13000000, 'Ray Tracing, DLSS 3.0', 'RTX 4060 Ti', 8, 'GDDR6');

-- Storage Data
INSERT INTO storage (name, manufacturer, price, specifications, type, capacity, read_speed, write_speed) VALUES
('Samsung 990 PRO 2TB', 'Samsung', 5500000, 'PCIe 4.0 NVMe, V-NAND', 'NVMe SSD', 2000, '7450 MB/s', '6900 MB/s'),
('WD Black SN850X 1TB', 'Western Digital', 3000000, 'PCIe 4.0 NVMe, Gaming', 'NVMe SSD', 1000, '7300 MB/s', '6300 MB/s'),
('Crucial P3 Plus 1TB', 'Crucial', 2000000, 'PCIe 4.0 NVMe', 'NVMe SSD', 1000, '5000 MB/s', '3600 MB/s'),
('Kingston NV2 500GB', 'Kingston', 1200000, 'PCIe 4.0 NVMe', 'NVMe SSD', 500, '3500 MB/s', '2100 MB/s'),
('Seagate Barracuda 2TB', 'Seagate', 1500000, '7200 RPM, SATA 6Gb/s', 'HDD', 2000, '220 MB/s', '220 MB/s'),
('Samsung 870 EVO 1TB', 'Samsung', 2500000, 'SATA 6Gb/s, V-NAND', 'SATA SSD', 1000, '560 MB/s', '530 MB/s');

-- PSU Data
INSERT INTO psu (name, manufacturer, price, specifications, wattage, efficiency, modular) VALUES
('Corsair RM1000x', 'Corsair', 5000000, '80+ Gold, Full Modular', 1000, '80+ Gold', 1),
('ASUS ROG Thor 850W', 'ASUS', 6500000, '80+ Platinum, Full Modular, OLED Display', 850, '80+ Platinum', 1),
('Cooler Master V850 SFX Gold', 'Cooler Master', 4000000, '80+ Gold, Full Modular, SFX', 850, '80+ Gold', 1),
('Thermaltake Toughpower GF1 750W', 'Thermaltake', 3000000, '80+ Gold, Full Modular', 750, '80+ Gold', 1),
('MSI MPG A650GF', 'MSI', 2500000, '80+ Gold, Full Modular', 650, '80+ Gold', 1),
('be quiet! Pure Power 11 600W', 'be quiet!', 2000000, '80+ Gold, Semi Modular', 600, '80+ Gold', 0);

-- Case Data
INSERT INTO pc_case (name, manufacturer, price, specifications, form_factor, color, has_rgb) VALUES
('Lian Li O11 Dynamic EVO', 'Lian Li', 4500000, 'Tempered Glass, USB-C', 'Mid Tower', 'Black', 1),
('NZXT H7 Flow', 'NZXT', 3500000, 'Tempered Glass, High Airflow', 'Mid Tower', 'White', 1),
('Corsair 4000D Airflow', 'Corsair', 2500000, 'Tempered Glass, High Airflow', 'Mid Tower', 'Black', 0),
('Fractal Design Meshify C', 'Fractal Design', 2000000, 'Tempered Glass, Compact', 'Mid Tower', 'Black', 0),
('Cooler Master MasterBox TD500', 'Cooler Master', 2800000, 'Tempered Glass, RGB Front Panel', 'Mid Tower', 'White', 1),
('be quiet! Pure Base 500DX', 'be quiet!', 3000000, 'Tempered Glass, Silent', 'Mid Tower', 'Black', 1);

-- Cooler Data
INSERT INTO cooler (name, manufacturer, price, specifications, type, socket, fan_size) VALUES
('Noctua NH-D15', 'Noctua', 2500000, 'Dual tower, Premium quality', 'Air', 'LGA1700/AM5', 140),
('be quiet! Dark Rock Pro 4', 'be quiet!', 2000000, 'Dual tower, Silent', 'Air', 'LGA1700/AM5', 135),
('Deepcool AK620', 'Deepcool', 1500000, 'Dual tower, High performance', 'Air', 'LGA1700/AM5', 120),
('Corsair iCUE H150i Elite', 'Corsair', 4500000, '360mm AIO, RGB', 'AIO', 'LGA1700/AM5', 120),
('NZXT Kraken X63', 'NZXT', 3500000, '280mm AIO, LCD Display', 'AIO', 'LGA1700/AM5', 140),
('Arctic Liquid Freezer II 240', 'Arctic', 2500000, '240mm AIO, Value', 'AIO', 'LGA1700/AM5', 120);
