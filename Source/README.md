# PC Builder - Ứng dụng xây dựng cấu hình máy tính

## Mô tả dự án
Ứng dụng Java Swing cho phép người dùng xây dựng cấu hình máy tính từ các linh kiện như CPU, Mainboard, RAM, VGA, Ổ cứng, Nguồn, Case, và Tản nhiệt. Ứng dụng áp dụng các mẫu thiết kế (Design Patterns) để giải quyết các vấn đề trong lập trình hướng đối tượng.

## Công nghệ sử dụng
- **Ngôn ngữ**: Java 11+
- **GUI Framework**: Java Swing
- **Database**: SQLite
- **Build Tool**: Maven
- **Design Patterns**: Singleton, Decorator

## Kiến trúc dự án

### 1. Design Patterns được áp dụng

#### Singleton Pattern
- **Class**: `DatabaseManager`
- **Mục đích**: Đảm bảo chỉ có một instance duy nhất quản lý kết nối database
- **Lợi ích**: 
  - Tiết kiệm tài nguyên
  - Tránh conflict khi nhiều phần của ứng dụng truy cập database
  - Quản lý kết nối tập trung

#### Decorator Pattern
- **Classes**: 
  - `PCConfiguration` (Interface)
  - `BasePCConfiguration` (Component)
  - `ConfigurationDecorator` (Abstract Decorator)
  - `WarrantyDecorator`, `AssemblyServiceDecorator`, `InstallationServiceDecorator`, `DiscountDecorator` (Concrete Decorators)
- **Mục đích**: Thêm các tính năng bổ sung vào cấu hình mà không thay đổi cấu trúc cơ bản
- **Lợi ích**:
  - Mở rộng chức năng linh hoạt
  - Tuân theo nguyên tắc Open/Closed
  - Dễ dàng thêm/bớt tính năng

### 2. Cấu trúc thư mục

```
MTK/
├── Source/                      # Mã nguồn
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── pcbuilder/
│   │                   ├── models/           # Các class model (OOP)
│   │                   │   ├── Component.java
│   │                   │   ├── CPU.java
│   │                   │   ├── Mainboard.java
│   │                   │   ├── RAM.java
│   │                   │   ├── VGA.java
│   │                   │   ├── Storage.java
│   │                   │   ├── PSU.java
│   │                   │   ├── Case.java
│   │                   │   └── Cooler.java
│   │                   ├── database/         # Database layer
│   │                   │   ├── DatabaseManager.java (Singleton)
│   │                   │   └── ComponentDAO.java
│   │                   ├── patterns/         # Design Patterns
│   │                   │   ├── PCConfiguration.java
│   │                   │   ├── BasePCConfiguration.java
│   │                   │   ├── ConfigurationDecorator.java
│   │                   │   ├── WarrantyDecorator.java
│   │                   │   ├── AssemblyServiceDecorator.java
│   │                   │   ├── InstallationServiceDecorator.java
│   │                   │   └── DiscountDecorator.java
│   │                   ├── gui/              # Giao diện người dùng
│   │                   │   └── PCBuilderGUI.java
│   │                   └── Main.java         # Entry point
│   └── pom.xml                 # Maven configuration
├── Database/                   # Database files
│   ├── schema.sql             # Database schema
│   ├── sample_data.sql        # Dữ liệu mẫu
│   └── pcbuilder.db           # SQLite database (sẽ được tạo tự động)
├── Executable/                # File thực thi
│   ├── PCBuilder.jar          # JAR file
│   └── run.bat               # Script chạy ứng dụng
├── Doc/                       # Tài liệu
│   └── BaoCaoDoAn.docx       # Báo cáo đồ án
└── GitHub_Info.txt           # Thông tin GitHub
```

## Hướng dẫn cài đặt và chạy

### Yêu cầu hệ thống
- Java JDK 11 trở lên
- Maven 3.6+ (để build từ source)

### Cách 1: Chạy từ file JAR (Đơn giản)
1. Mở thư mục `Executable/`
2. Double-click vào `run.bat` (Windows)
3. Hoặc chạy lệnh: `java -jar PCBuilder.jar`

### Cách 2: Build từ source code
1. Mở terminal/command prompt
2. Di chuyển đến thư mục `Source/`
3. Chạy lệnh build:
   ```
   mvn clean package
   ```
4. File JAR sẽ được tạo trong thư mục `Source/target/`
5. Copy file `PCBuilder.jar` vào thư mục `Executable/`
6. Chạy ứng dụng

## Tính năng chính

### 1. Chọn linh kiện
- CPU, Mainboard, RAM, VGA, Ổ cứng, Nguồn, Case, Tản nhiệt
- Hiển thị thông tin chi tiết của từng linh kiện
- Tự động tính tổng giá trị cấu hình

### 2. Dịch vụ bổ sung (Decorator Pattern)
- **Bảo hành mở rộng**: Tùy chọn 1-5 năm (5% giá trị/năm)
- **Dịch vụ lắp ráp**: Lắp ráp và kiểm tra cấu hình (+500,000 VNĐ)
- **Cài đặt phần mềm**: Windows và drivers (+300,000 VNĐ)
- **Giảm giá**: Dành cho khách hàng thân thiết (10%)

### 3. Quản lý cấu hình
- Xem tóm tắt cấu hình
- Xem chi tiết từng linh kiện
- Reset cấu hình
- Xuất cấu hình (coming soon)

## Database Schema

### Các bảng trong database:
- `cpu`: Thông tin CPU
- `mainboard`: Thông tin mainboard
- `ram`: Thông tin RAM
- `vga`: Thông tin card đồ họa
- `storage`: Thông tin ổ cứng
- `psu`: Thông tin nguồn
- `pc_case`: Thông tin vỏ máy
- `cooler`: Thông tin tản nhiệt

## Nguyên tắc OOP được áp dụng

### 1. Encapsulation (Đóng gói)
- Tất cả các thuộc tính trong model classes đều là `private`
- Sử dụng getter/setter để truy cập

### 2. Inheritance (Kế thừa)
- Tất cả các model classes kế thừa từ `Component` abstract class
- Tái sử dụng code và thuộc tính chung

### 3. Abstraction (Trừu tượng)
- `Component` là abstract class với method `getDetails()` abstract
- Mỗi subclass implement method này theo cách riêng

### 4. Polymorphism (Đa hình)
- Decorator Pattern cho phép xử lý nhiều loại configuration khác nhau thông qua interface chung
- ComboBox có thể chứa bất kỳ subclass nào của Component

## Tác giả
[Tên sinh viên]
[MSSV]
[Lớp]

## Giảng viên hướng dẫn
[Tên giảng viên]

## Môn học
Mẫu thiết kế (Design Patterns)

## Năm học
2024-2025
