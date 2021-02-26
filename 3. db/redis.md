## 基础
- redis介绍
- redis高性能的原因
- redis应用场景
- redis支持的数据类型
- redis zset有哪些实现（压缩列表、跳表和字典）
- redis string有哪些实现（简单动态字符串、整数值embstr编码）
- redis list有哪些实现（压缩列表、双端链表、快速列表）
- redis hash有哪些实现（压缩列表、字典）
- redis set有哪些实现（整数集合、字典）

## 集群
- redis持久化有哪些模式
- RDB备份过程
- RDB优缺点
- AOF备份过程
- AOF重写原理
- 主从复制实现原理
- 全量同步过程（同步快照阶段、同步写缓冲阶段、同步增量阶段）
- redis哨兵进程的作用
- redis哨兵故障判断原理
- redis-cluster概念
- redis分布式锁（单机锁和红锁）

## 常见问题
- 缓存穿透的概念和解决方案
- 缓存雪崩的概念和解决方案
- 缓存击穿（热点缓存）的概念和解决方案
- 缓存双写一致性
- redis内存占满了怎么办（增加内存、内存淘汰策略、集群）
- 惰性删除和主动删除
- 为什么要用跳表，而不用红黑树