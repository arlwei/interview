## 基本概念
- 谈谈你对kafka的理解
- 常见的使用场景
- kafka能实现高吞吐的原因
- broker、broker controller、topic、partition、segment、producer、consumer、consumer group概念
- partition replicas、partition leader、partition follower、ISR概念
- HW、LEO概念
- zk作用
- coordinator、rebalance概念
- zk上有哪些kafka相关节点

## kafka工作原理
- segment存储结构
- partition查找消息过程
- offset怎么写入
- 消息写入算法
- 消息路由策略
- HW截断机制
- 消息发送的可靠性机制（acks）
- 消费者消费过程解析
- partiton leader的选举范围
- 重复消费问题怎么解决

## 常见问题
- 如何保证消费有序
- 消费如何确定放到哪个分区
- partition初始编号是什么
- 能追加partition吗
- kafka的幂等性如何实现（ProducerID、SequenceNumber）