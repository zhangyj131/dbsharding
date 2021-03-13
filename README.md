采用多级模块

dbsharding	父工程

​		|-standard-sharding-jdbc 标准分片策略

​				|-precise-sharding-jdbc	精准分片

​						|-db-precise-sharding	精准分片-分库

​						|-table-precise-sharding	精准分片-分表

​				|-range-sharding-jdbc	范围分片

​						|-db-range-sharding	范围分片-分库

​						|-table-range-sharding	范围分片-分表

​		|-complex-sharding-jdbc	复合分片策略

​				|-db-complex-keys-sharding	复合分片-分库

​				|-table-complex-keys-sharding	复合分片-分表

​		|-inline-sharding-jdbc	行表达式策略

​				|-db-inline-sharding	行表达式-分库

​				|-table-inline-sharding	行表达式-分表

​		|-hint-sharding-jdbc	hint策略

​				|-db-hint-sharding	hint-分库

​				|-table-hint-sharding	hint-分表



准备工作

创建db_0、db_1、db_2、db_3 数据库

```sql
-- drop database db_0;
CREATE DATABASE IF NOT EXISTS db_0 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_1 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_2 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_3 default charset utf8 COLLATE utf8_general_ci;
```

在每个库创建下面表

```sql
CREATE TABLE `order_0` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `order_1` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `order_2` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


CREATE TABLE `order_item_0` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `order_item_1` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `order_item_2` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

```



​		

​	