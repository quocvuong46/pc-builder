@echo off
echo ========================================
echo   PC BUILDER - BUILD SCRIPT
echo ========================================
echo.

REM Kiểm tra Java
echo [1/4] Kiem tra Java...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java chua duoc cai dat!
    pause
    exit /b 1
)
echo [OK] Java da san sang

REM Kiểm tra Maven
echo [2/4] Kiem tra Maven...
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Maven chua duoc cai dat!
    echo Vui long cai dat Maven: https://maven.apache.org/download.cgi
    pause
    exit /b 1
)
echo [OK] Maven da san sang

REM Build project
echo [3/4] Build project...
cd Source
call mvn clean package
if %errorlevel% neq 0 (
    echo [ERROR] Build that bai!
    cd ..
    pause
    exit /b 1
)
echo [OK] Build thanh cong

REM Copy JAR file
echo [4/4] Copy file JAR...
copy target\PCBuilder.jar ..\Executable\PCBuilder.jar
if %errorlevel% neq 0 (
    echo [ERROR] Khong the copy file JAR!
    cd ..
    pause
    exit /b 1
)
echo [OK] Copy thanh cong

cd ..
echo.
echo ========================================
echo   BUILD HOAN THANH!
echo ========================================
echo.
echo File JAR: Executable\PCBuilder.jar
echo.
echo TINH NANG MOI:
echo  - Xuat cau hinh ra file .txt
echo  - Format dep, san sang de in
echo  - Mo file tu dong sau khi xuat
echo.
echo De chay ung dung: 
echo   - Windows: Executable\run.bat
echo   - Command: java -jar Executable\PCBuilder.jar
echo.
pause
