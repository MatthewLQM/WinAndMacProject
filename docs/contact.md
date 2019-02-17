# 联系人管理系统 （Contact System）
需要实现联系人的增、删、改、查。
## 功能详解
 + 需要实现联系人信息的记录（增）
 + 需要实现联系人信息的修改（改）
 + 需要实现联系人信息的删除（删）
 + 需要实现联系人信息的查询（查）
 + 需要实现联系人信息的导出功能，暂定为导出为 Excel
## 页面要求
 + 要有一丢丢的颜色
 + 要有自适应排版，支持放大和缩小
## 联系人信息
联系人需要包含如下字段
 + ID(唯一标示)
 + 姓名
 + 英文名
 + 性别
 + 生日
 + 电话
 + 邮箱
 + 微信号
 + QQ号
 + 联系地址
 + 工作单位
 + 单位电话
 + 简要描述
 + 额外信息
## 建表语句
```sql
CREATE TABLE contact(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(16) NOT NULL,
    english_name VARCHAR(32),
    sex VARCHAR(16) NOT NULL,
    birthday DATE,
    phone VARCHAR(16),
    email VARCHAR(64),
    wechat VARCHAR(32),
    qq VARCHAR(16),
    address VARCHAR(512),
    company VARCHAR(512),
    company_phone VARCHAR(16),
    memo VARCHAR(1024),
    ext_info VARCHAR(1024)  
);
```