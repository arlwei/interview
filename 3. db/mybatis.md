## 基础知识
- mybatis和hibernate区别
- mybatis最常见的使用方法
- '#{}'和'${}'的区别
- 主键返回如何实现（selectKey）
- SqlMapConfig.xml里常见的配置
- 关联查询（resultMap + association/collection）
- 延迟加载是什么
- 延迟加载存在什么问题
- mybatis缓存分类

## 源码流程
- mybatis整体架构（基础支撑层、数据处理层、接口层）
- mybatis源码流程
  - 加载配置文件流程和加载映射文件流程
  - SqlSource创建流程和获取Mapper对象代理流程
  - SqlSession执行主流程
  - BoundSql获取流程
  - 参数映射流程
  - 结果集映射流程