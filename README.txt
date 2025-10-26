================================================================================
                    PC BUILDER APPLICATION
          Ứng dụng xây dựng cấu hình máy tính
================================================================================

ĐỒ ÁN CUỐI KỲ - MÔN: MẪU THIẾT KẾ (DESIGN PATTERNS)

================================================================================
                        GIỚI THIỆU DỰ ÁN
================================================================================

PC Builder là ứng dụng desktop Java giúp người dùng xây dựng cấu hình máy 
tính từ các linh kiện có sẵn. Ứng dụng áp dụng các Design Patterns:
- SINGLETON PATTERN: Quản lý database connection
- DECORATOR PATTERN: Thêm dịch vụ bổ sung (bảo hành, lắp ráp, giảm giá)

================================================================================
                        CẤU TRÚC THỨ MỤC
================================================================================

MTK/
├── Source/                      # Mã nguồn Java
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/pcbuilder/
│   │               ├── models/           # Classes linh kiện (OOP)
│   │               ├── database/         # Database manager (Singleton)
│   │               ├── patterns/         # Design patterns (Decorator)
│   │               ├── gui/             # Giao diện Swing
│   │               └── Main.java        # Entry point
│   ├── pom.xml                 # Maven configuration
│   └── README.md              # Tài liệu chi tiết
│
├── Database/                   # Database files
│   ├── schema.sql             # Database schema
│   ├── sample_data.sql        # Dữ liệu mẫu
│   └── pcbuilder.db          # SQLite database (tự động tạo)
│
├── Executable/                # File thực thi
│   ├── PCBuilder.jar         # JAR file (sau khi build)
│   ├── run.bat              # Script chạy (Windows)
│   └── HUONG_DAN.txt        # Hướng dẫn sử dụng
│
├── Doc/                       # Tài liệu
│   └── BaoCaoDoAn_Template.txt  # Template báo cáo
│
├── .gitignore                # Git ignore file
└── GitHub_Info.txt          # Thông tin GitHub

================================================================================
                    HƯỚNG DẪN BUILD VÀ CHẠY
================================================================================

BƯỚC 1: CHUẨN BỊ MÔI TRƯỜNG
----------------------------
1. Cài đặt Java JDK 11 trở lên
   Download: https://www.oracle.com/java/technologies/downloads/
   
2. Cài đặt Maven (nếu build từ source)
   Download: https://maven.apache.org/download.cgi
   
3. Kiểm tra cài đặt:
   java -version
   mvn -version

BƯỚC 2: BUILD DỰ ÁN
--------------------
1. Mở Command Prompt hoặc Terminal

2. Di chuyển đến thư mục Source:
   cd MTK/Source

3. Build project với Maven:
   mvn clean package

4. File JAR sẽ được tạo tại:
   MTK/Source/target/PCBuilder.jar

5. Copy file JAR vào thư mục Executable:
   - Windows: copy target\PCBuilder.jar ..\Executable\
   - Linux/Mac: cp target/PCBuilder.jar ../Executable/

BƯỚC 3: CHẠY ỨNG DỤNG
----------------------
Cách 1 (Windows): Double-click vào Executable/run.bat

Cách 2 (Tất cả OS):
   cd MTK/Executable
   java -jar PCBuilder.jar

Cách 3 (Nếu lỗi encoding tiếng Việt):
   java -Dfile.encoding=UTF-8 -jar PCBuilder.jar

BƯỚC 4: SỬ DỤNG ỨNG DỤNG
-------------------------
1. Ứng dụng sẽ tự động tạo database lần đầu chạy
2. Chọn linh kiện từ các ComboBox
3. Thêm dịch vụ bổ sung (tuỳ chọn)
4. Xem tổng giá và chi tiết cấu hình

================================================================================
                        TÍNH NĂNG CHÍNH
================================================================================

1. QUẢN LÝ LINH KIỆN
   - CPU: Intel/AMD với các thông số kỹ thuật
   - Mainboard: Socket, Chipset, Form Factor
   - RAM: DDR5, dung lượng, tốc độ
   - VGA: NVIDIA/AMD, VRAM, Ray Tracing
   - Storage: SSD NVMe, SATA, HDD
   - PSU: Công suất, hiệu suất 80+
   - Case: Form Factor, RGB
   - Cooler: Air/AIO cooling

2. DỊCH VỤ BỔ SUNG (DECORATOR PATTERN)
   - Bảo hành mở rộng: 1-5 năm (5% giá trị/năm)
   - Lắp ráp và test: +500,000 VNĐ
   - Cài đặt Windows: +300,000 VNĐ
   - Giảm giá 10%: Khách hàng thân thiết

3. TÍNH TOÁN GIÁ
   - Tự động tính tổng giá linh kiện
   - Áp dụng dịch vụ bổ sung
   - Hiển thị breakdown chi tiết

4. XUẤT CẤU HÌNH
   - Xuất cấu hình ra file .txt
   - Format đẹp, sẵn sàng để in
   - Tạo báo giá chuyên nghiệp
   - Mở file tự động sau khi xuất

================================================================================
                        DESIGN PATTERNS
================================================================================

1. SINGLETON PATTERN
   Class: DatabaseManager
   Mục đích: Đảm bảo chỉ 1 instance quản lý database connection
   Location: com.pcbuilder.database.DatabaseManager

2. DECORATOR PATTERN
   Interface: PCConfiguration
   Base Component: BasePCConfiguration
   Decorators:
   - WarrantyDecorator: Thêm bảo hành
   - AssemblyServiceDecorator: Thêm dịch vụ lắp ráp
   - InstallationServiceDecorator: Thêm dịch vụ cài đặt
   - DiscountDecorator: Áp dụng giảm giá
   Location: com.pcbuilder.patterns.*

================================================================================
                        CÔNG NGHỆ SỬ DỤNG
================================================================================

- Language: Java 11
- GUI: Java Swing
- Database: SQLite 3.42
- Build Tool: Maven
- JDBC Driver: sqlite-jdbc
- Design Patterns: Singleton, Decorator
- OOP: Encapsulation, Inheritance, Abstraction, Polymorphism

================================================================================
                        XỬ LÝ LỖI THƯỜNG GẶP
================================================================================

LỖI: "Java không được nhận dạng"
   → Cài đặt Java JDK và thêm vào PATH

LỖI: "Could not find or load main class"
   → Đảm bảo file JAR được build đúng cách
   → Chạy lại: mvn clean package

LỖI: "Database connection failed"
   → Đảm bảo thư mục Database/ tồn tại
   → Kiểm tra quyền ghi file

LỖI: Tiếng Việt hiển thị lỗi font
   → Chạy với: java -Dfile.encoding=UTF-8 -jar PCBuilder.jar

LỖI: "Maven not found"
   → Cài đặt Maven và thêm vào PATH
   → Hoặc sử dụng Maven wrapper: mvnw clean package

================================================================================
                        HƯỚNG DẪN PHÁT TRIỂN
================================================================================

THÊM LINH KIỆN MỚI:
1. Thêm class trong com.pcbuilder.models extends Component
2. Thêm method trong ComponentDAO
3. Tạo bảng mới trong schema.sql
4. Thêm ComboBox trong GUI

THÊM DECORATOR MỚI:
1. Tạo class extends ConfigurationDecorator
2. Override getPrice() và getDescription()
3. Thêm checkbox trong GUI
4. Apply decorator trong updateConfiguration()

THÊM DATABASE TABLE:
1. Thêm CREATE TABLE trong schema.sql
2. Thêm INSERT trong sample_data.sql
3. Tạo method trong ComponentDAO
4. Update model class tương ứng

================================================================================
                        THÔNG TIN LIÊN HỆ
================================================================================

Tác giả: [Điền tên]
MSSV: [Điền MSSV]
Email: [Điền email]
GitHub: [Điền link GitHub sau khi tạo repository]

Giảng viên: [Điền tên GV]
Môn học: Mẫu thiết kế (Design Patterns)
Năm học: 2024-2025

================================================================================
                        GHI CHÚ QUAN TRỌNG
================================================================================

1. Giữ nguyên cấu trúc thư mục khi chạy ứng dụng
2. Không di chuyển riêng lẻ các file
3. Database sẽ được tạo tự động lần đầu chạy
4. Backup database trước khi chỉnh sửa
5. Đọc file README.md trong Source/ để biết thêm chi tiết
6. Template báo cáo trong Doc/ cần được format lại thành Word
7. Cập nhật thông tin GitHub sau khi tạo repository

================================================================================
                        KIỂM TRA HOÀN THÀNH
================================================================================

☐ Java JDK đã được cài đặt
☐ Maven đã được cài đặt (nếu build từ source)
☐ Project build thành công (mvn clean package)
☐ File PCBuilder.jar đã được tạo
☐ Ứng dụng chạy được và hiển thị GUI
☐ Database được tạo tự động
☐ Có thể chọn linh kiện và tính giá
☐ Decorator pattern hoạt động (dịch vụ bổ sung)
☐ Đã đọc và hiểu cấu trúc code
☐ Đã chuẩn bị nội dung báo cáo

================================================================================
                        KẾT THÚC
================================================================================

Chúc bạn thành công với đồ án!

Để biết thêm chi tiết, vui lòng xem:
- Source/README.md: Tài liệu kỹ thuật đầy đủ
- Doc/BaoCaoDoAn_Template.txt: Template báo cáo
- GitHub_Info.txt: Hướng dẫn tạo repository GitHub
- Executable/HUONG_DAN.txt: Hướng dẫn chạy nhanh

================================================================================
