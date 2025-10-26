@echo off
echo ========================================
echo   KHOI TAO DATABASE
echo   PC Builder Application
echo ========================================
echo.

REM Kiểm tra SQLite
where sqlite3 >nul 2>&1
if %errorlevel% neq 0 (
    echo [INFO] SQLite3 command line chua duoc cai dat.
    echo [INFO] Database se duoc tu dong tao khi chay ung dung.
    echo.
    pause
    exit /b 0
)

REM Xóa database cũ nếu có
if exist Database\pcbuilder.db (
    echo [INFO] Tim thay database cu. Xoa database cu...
    del Database\pcbuilder.db
)

REM Tạo database mới
echo [INFO] Tao database moi...
sqlite3 Database\pcbuilder.db < Database\init_database.sql

if %errorlevel% equ 0 (
    echo [OK] Database da duoc tao thanh cong!
    echo [OK] File: Database\pcbuilder.db
) else (
    echo [ERROR] Co loi khi tao database!
)

echo.
pause
