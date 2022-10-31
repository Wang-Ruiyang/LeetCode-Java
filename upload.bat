@echo off
 
title GIT一键提交
color 3
echo 当前目录是：%cd%
echo;
 
echo 开始添加变更：git add .
git add .
echo;
 
set /p declation=输入提交的commit信息:
git commit -m "%declation%"
echo;
 
echo 本地分支拉取远程主分支：git pull origin master
git pull origin master
echo;
 
echo 执行完毕！
echo;
 
pause