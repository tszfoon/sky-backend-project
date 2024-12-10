sky-server
config 用于配置类。
controller.admin 用于处理管理员相关的控制器。
handler 可能用于处理特定的请求或事件。
interceptor 用于定义拦截器。
mapper 存放 MyBatis 的 Mapper 和映射文件。
service 存放业务逻辑代码。

DTO：数据传输对象，用于不同层次之间的数据交换，不包含业务逻辑。
Entity：实体类，与数据库表一一映射，通常用于数据库操作。
VO：视图对象，主要用于前端数据展示，可能包含展示层需要的字段或格式化后的数据。