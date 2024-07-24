<!-- 封面 -->

> 引用来源：[Markdown 入门教程](https://www.imooc.com/wiki/markdownlesson/markdownoverview.html)

# Markdown 综合实例

# 摘要

这里插入任意的文本内容。

...

这里插入任意的文本内容。

**关键词**：编辑器，格式化，Markdown。

# 目录

[TOC]

# 第一章 绪论

## 1.1 课题背景

[这是一段正文内容]

> 引用他人的论点论据，用来佐证本文的背景及意义。
> 
> ——引文出处，适当增加尾注[^1]

[这是一段正文内容]

## 1.2 信息化管理

## 1.3 系统设计目的和内容

[^1]: 绪论尾注 1 的内容。

# 第二章 需求分析

## 2.1 可行性分析

### 2.1.1 技术可行性

同类产品技术解决方案：

- XX 公司实现的产品，用了 XX 技术；
- XX 公司实现的产品，用了 XX 技术；
- XX 公司实现的产品，用了 XX 技术。

### 2.1.2 经济可行性

```mermaid
pie title 市场分析
    "已改造" : 386
    "未改造" : 85
```

<center>图1：市场分析图</center>

### 2.1.3 管理可行性

## 2.2 需求分析

### 2.2.1 功能需求

- 功能点1
  - 子功能点 1-1
  - 子功能点 1-2
  - 子功能点 1-3
- 功能点2
  - 子功能点 2-1
  - 子功能点 2-2
- 功能点3

### 2.2.2 环境需求

| 需求项  | 需求指标      |
| ---- | --------- |
| 操作系统 | CentOS 7  |
| 数据库  | Mysql 5.7 |
| 内存   | 8G        |
| 硬盘   | 100G      |

## 2.3 数据项分析

数据表整理

| 数据对象 | 简述        | 来源   | 核心数据项  | 主键  |
| ---- | --------- | ---- | ------ | --- |
| 管理员表 | 保存系统管理员信息 | 注册   | 登录名    | 登录名 |
| 学生表  | 保存学员信息    | 批量导入 | 姓名、学号  | 学号  |
| 老师表  | 保存教职工信息   | 批量导入 | 姓名、职工号 | 职工号 |
| 部门表  | 保存部门、班级信息 | 批量导入 | 名称、编号  | 编号  |

# 第三章 概要设计

## 3.1 数据表设计

**管理员表**

管理员表的描述文字。

*表1：管理员表结构*

| 列名       | 数据类型        | 长度  | 非空  | 主键  |
| -------- | ----------- | --- | --- | --- |
| id       | UUID        | 64  | √   | √   |
| account  | VARCHAR(32) | 32  | √   |     |
| password | VARCHAR(32) | 32  |     |     |

**学生信息表**

学生信息表的描述文字。

*表2：管理员表结构*

| 列名   | 数据类型        | 长度  | 非空  | 主键  |
| ---- | ----------- | --- | --- | --- |
| id   | UUID        | 64  | √   | √   |
| name | VARCHAR(32) | 32  | √   |     |
| age  | Integer     | 8   |     |     |

## 3.2 数据表关系图

```mermaid
classDiagram
    学员表 --> 部门表 : 关联
    职工表    --> 部门表 : 关联
    class 学员表 {
    id
    部门 ID <fk>
    }
    class 职工表 {
    id
    部门 ID <fk>
    }
    class 部门表 {
    id
    }
```

<center>图3-1：数据关系表</center>

## 3.3 功能结构图

```mermaid
graph LR
    XX管理系统 --> 管理员登录
    管理员登录 --> 系统设置
    管理员登录 --> 学员管理
  管理员登录 --> 教师管理
     管理员登录 --> 部门管理
     部门管理 --> 增加
     部门管理 --> 修改
     部门管理 --> 删除
     部门管理 --> 批量导入
```

<center>图3-2：功能结构图</center>

# 第四章 功能实现

## 4.1 后台代码实现

```java
public class Starter {
    public static void main(String[] args) {
      System.out.println("Hello world");
  }
}
```

## 4.2 前端代码实现

前端 HTML 代码：

```html
<!DOCTYPE HTML>
<html>
  <head></head>
  <body>
    <p>Hello world.</p>
  </body>
</html>
```

前端脚本代码：

```javascript
function main() {
    alert("Hello world!");
}

window.onload = main;
```

## 4.3 配置文件代码

properties 类型的配置文件：

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/helloworld?characterEncoding=utf8
jdbc.username=root
jdbc.password=root
```

## 4.4 运行及启动日志

```bash
java Starter
---
Hello world
```

网页截图：

![](../images/4-1.png)

<center>图4-1：访问效果图</center>

# 第五章 系统测试

## 5.1 功能点完成情况对照

- [x] 数据库创建
- [x] 后端开发
- [x] 前端开发
- [x] 接口联调
- [ ] 日志归档

## 5.2 测试结果

| 功能点    | 是否测试                         | 是否通过                         | 备注  |
| ------ | ---------------------------- | ---------------------------- | --- |
| 登录     | <font color="green">√</font> | <font color="green">√</font> | 无   |
| 登出     | <font color="green">√</font> | <font color="red">×</font>   | 无   |
| 增加学员信息 | <font color="red">×</font>   | <font color="red">×</font>   | 无   |

# 结束语

<!-- 纯文字部分 -->

# 致谢

<!-- 纯文字部分 -->

正文某处[^1]

正文某处[^2]

正文某处[^3]

# 参考 文献

[^1]: XXX，图书管理系统设计。北京：北京大学出版社，2008。
[^2]: XXX，师生管理系统设计。北京：清华大学出版社，2009。
[^3]: XXX，软件工程（三）。北京：邮电大学出版社，2019。 