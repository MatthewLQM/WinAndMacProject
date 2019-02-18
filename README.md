# WinAndMacProject 
在Windows和Mac电脑上，都可以通过Clone的方式直接运行的SpringBoot程序
## TODO List
+ 打包并部署到开发服务器上
+ 联系人导出到 Excel 的功能
## Doing List
+ 准备功能性质的开发，第一个功能：[联系人系统](docs/contact.md)
+ 建立一套日志系统，暂时使用简单的 LOG 方式
## Done List
+ 使用 MyBatis 实现连接数据库的功能
+ 初始化一个 SpringBoot 的工程，使用 Gradle 作为工程构建工具
+ 使用 SpringBoot 简单的连接数据库，实现丑陋的增删改查
+ 使用了 thymeleaf 作为前端的解决方案
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
### 2019.02.17
加入了 MyBatis 的支持，使用注解的方式实现 Mapper；
完成了联系人功能的简单实现，暂时没有 Update 的功能。
### 2019.02.18
加入联系人功能的 Update 功能；
加入了联系人的详情页，使整体的功能好看了一些。