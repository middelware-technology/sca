# 项目简介
SpringCloudAlibaba(sca) 的demo工程

# 命名规约
maven模块: xxx-xxx 小写


# 开发流程
1. 代码生成器，生成数据库中对应的代码。
2. 创建beans 工程：将entity放入该工程中
3. 创建service-api 工程: 定义服务层·接口·（增删改查）
4. 创建service-impl 工程: 实现service-api中的接口
5. 创建Web层
5.1 定义Controller给展示层提供接口
5.2 定义client（OpenFeign），访问service-api的接口远程调用service-impl
5.3 定义cache(SpringCache), 缓存数据(OpenFeign远程调用的接口数据)