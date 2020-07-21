# 租户模块

| 租户模式 | 描述 | 优点 | 缺点  | 
|---|---|---|---|
| NONE（非租户模式) | 没有租户 | 简单、适合独立系统 | 缺少租户系统的优点 | 
| COLUMN（字段模式) | 租户共用一个数据库，在业务表中增加字段来区分 | 简单、不复杂、开发无感知 | 数据隔离性差、安全性差、数据备份和恢复困难、 | 
| SCHEMA（独立schema) | 每个租户独立一个 数据库(schema)，执行sql时，动态在表名前增加schema | 简单、开发无感知、数据隔离性好 | 配置文件中必须配置数据库的root账号、不支持复杂sql和 sql嵌套自定义函数 | 
| DATASOURCE(独立数据源) | 每个租户独立一个 数据库(数据源)，执行代码时，动态切换数据源 | 可独立部署数据库，数据隔离性好、扩展性高、故障影响小 | 相对复杂、开发需要注意切换数据源时的事务问题、需要较多的数据库 |

| 模式\描述  | 表中有无租户字段 | 实体类中有无租户字段 | 分布式事务| 有几个数据库 |  
|---|---|---|---|---|
| NONE | 无 | 无 | 支持 | cloud_defaults | 
| COLUMN | 有 | 无 | 支持 | cloud_defaults |
| SCHEMA | 无 | 无 | 支持 | cloud_defaults、cloud_base_{tenant} |
| DATASOURCE | 无 | 无 | 支持 | cloud_defaults、cloud_base_{tenant} |

```
cloud:
  data:
    multiTenantType:  
```
有4个选项：
1.NONE：非租户模式
2.COLUMN：字段模式
3.SCHEMA：独立schema模式
4.DATASOURCE：独立数据源模式

# 4个sql脚本的区别：
1. cloud_zipkin.sql: zipkin需要使用的数据库，无论使用那种模式，请独立创建 cloud_zipkin 数据库，并导入 cloud_zipkin.sql 
2. cloud_defaults.sql：默认库，用于存放全局表，如租户信息、定时信息等
3. cloud_base_0000.sql：租户库，用于存放内置租户：0000 的业务表。（跟 cloud_column.sql 的区别在于没有 tenant_code 字段 ）
4. cloud_column.sql：租户库，用于存放所有租户的业务表。（跟 cloud_base_0000.sql 的区别在于每个表都有 tenant_code 字段 ）

# 下面介绍4种模式如何创建数据库：(cloud_zipkin.sql 4种模式都要单独导入 cloud_zipin 库！)
## NONE
1. 创建数据库： cloud_defaults
2. 向 cloud_none 库导入 cloud_defaults.sql 
3. 向 cloud_none 库导入 cloud_base_0000.sql 

## COLUMN
1. 创建数据库： cloud_defaults
2. 向 cloud_column 库导入 cloud_defaults.sql 
3. 向 cloud_column 库导入 cloud_column.sql 

## SCHEMA
1. 创建数据库： cloud_defaults 和 cloud_base_0000
2. 向 cloud_defaults 库导入 cloud_defaults.sql 
3. 向 cloud_base_0000 库导入 cloud_base_0000.sql 

## DATASOURCE
1. 创建数据库： cloud_defaults 和 cloud_base_0000
2. 向 cloud_defaults 库导入 cloud_defaults.sql 
3. 向 cloud_base_0000 库导入 cloud_base_0000.sql 
