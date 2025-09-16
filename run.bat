@echo off
REM Set source and output directories
set SRC=src
set BIN=bin

REM Create bin folder if not exists
if not exist %BIN% mkdir %BIN%

REM Compile all .java files into bin folder
javac -d %BIN% %SRC%\*.java %SRC%\model\*.java %SRC%\service\*.java %SRC%\util\*.java

REM Run the Main class
java -cp %BIN% Main

pause
