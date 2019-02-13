# 数据库配置
1. 使用 MySql 数据库作为要连接的数据库
2. 数据库的用户名、密码均设置为 root
3. 使用的 database 名称为 springboot
4. mac 下启动 mysql 的命令： `mysql.server start`
5. mac 下连接 mysql 的命令： `mysql -u root -p`，然后输入密码
## 表
### 1. 测试表
表名： test_table   
建表语句：
``` sql
CREATE TABLE test_table(
    id bigint NOT NULL PRIMARY KEY,
    name varchar(64) NOT NULL
);
```
插入第一条测试数据：
``` sql
INSERT INTO test_table VALUES(1, 'zeyuan');
```

