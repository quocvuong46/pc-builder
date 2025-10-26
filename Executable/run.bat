@echo off
echo ========================================
echo   PC BUILDER APPLICATION
echo   Ung dung xay dung cau hinh may tinh
echo ========================================
echo.

REM Kiểm tra Java
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java chua duoc cai dat!
    echo Vui long cai dat Java JDK 11 tro len.
    echo Download tai: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)

echo [INFO] Dang khoi dong ung dung...
echo.

REM Chạy ứng dụng
java -jar PCBuilder.jar

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Co loi xay ra khi chay ung dung!
    pause
    exit /b 1
)

pause
