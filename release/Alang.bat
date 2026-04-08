@echo off
chcp 65001 > nul

if "%~1"=="" (
    echo Usage: alang file.alam
    exit /b
)

java -jar "%~dp0target\alang.jar" %*