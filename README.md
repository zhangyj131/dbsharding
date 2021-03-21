

准备工作

创建db_0、db_1、db_2、db_3 、db_x数据库

```sql
CREATE DATABASE IF NOT EXISTS db_0 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_1 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_2 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_3 default charset utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS db_x default charset utf8 COLLATE utf8_general_ci;
```

在db_0、db_1、db_2、db_3库创建下面表  db_x 只创建t_order、t_order_item

```sql
CREATE TABLE `t_order` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order_0` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order_1` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order_2` (
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id` bigint(200) NOT NULL,
  `create_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


CREATE TABLE `t_order_item` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order_item_0` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order_item_1` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_order_item_2` (
  `item_id` bigint(100) NOT NULL,
  `order_id` bigint(200) NOT NULL,
  `order_no` varchar(200) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


--  db_x 只创建t_order、t_order_item、t_user
-- 其它库没有t_user
CREATE TABLE `t_user` (
  `user_id` bigint(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
```



```sql
-- 删除所有数据
use db_0;
delete from t_order;
delete from t_order_0;
delete from t_order_1;
delete from t_order_2;
delete from t_order_item;
delete from t_order_item_0;
delete from t_order_item_1;
delete from t_order_item_2;

use db_1;
delete from t_order;
delete from t_order_0;
delete from t_order_1;
delete from t_order_2;
delete from t_order_item;
delete from t_order_item_0;
delete from t_order_item_1;
delete from t_order_item_2;

use db_2;
delete from t_order;
delete from t_order_0;
delete from t_order_1;
delete from t_order_2;
delete from t_order_item;
delete from t_order_item_0;
delete from t_order_item_1;
delete from t_order_item_2;

use db_3;
delete from t_order;
delete from t_order_0;
delete from t_order_1;
delete from t_order_2;
delete from t_order_item;
delete from t_order_item_0;
delete from t_order_item_1;
delete from t_order_item_2;

use db_x;
delete from t_order;
delete from t_order_item;
delete from t_user;

```



