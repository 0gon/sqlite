@echo off
rem 경로, 코멘트 출력 오프
rem rem 주석 사용

rem echo 코멘트 출력
rem echo. 한줄 띄우기
echo.
echo.
echo start!
cd /d %~dp0
sqlite3.exe database.db ^
".output database.txt" ".dump" ".exit"
echo finish!






rem 스크립트 종료 후 cmd 종료 비활성화
rem pause