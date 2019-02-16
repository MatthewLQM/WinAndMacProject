# WinAndMacProject 
在Windows和Mac电脑上，都可以通过Clone的方式直接运行的SpringBoot程序
## TODO List
+ 使用 MyBatis 实现连接数据库的功能
+ 准备功能性质的开发，第一个功能：[联系人系统](docs/contact.md)
## Doing List
+ 寻找前端的解决方案，暂时使用了 thymeleaf 作为前端的解决方案
+ 建立一套日志系统，暂时使用简单的 LOG 方式
## Done List
+ 初始化一个 SpringBoot 的工程，使用 Gradle 作为工程构建工具
+ + 使用 SpringBoot 简单的连接数据库，实现丑陋的增删改查
## Daily Record 
### 2019.02.13
初始化 Git 仓库。  
尝试使用MyBatis，但是失败，还没有成功的 Run 起来。意识到需要建立一套日志系统。     
发现前两次提交用的用户名和邮箱是错的。。愚蠢的我。
### 2019.02.14
利用 SpringBoot 的 JDBC，实现了简单的连接数据库的功能。
### 2019.02.15
拆分了 Service 层和 Repository 层，在 Repository 层增加了 JDBC 的实现。通过传参的方式，
实现了条件查询，但是还很简陋。
### 2019.02.16
加入了 thymeleaf 模板；
利用 JDBCTemplate 实现了数据库的增、删、查；
实现了一个简陋的前端界面。
加入了简单的 LOG 内容，在每次请求的时候都可以进行 LOG。