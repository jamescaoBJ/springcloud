
# Notice
- **fastcloud** 主要分为master和cloud分支，high分支（其它分支和tag暂时不用管），master分支主要是为后续部署实施阶段各种高可用分布式高并发服务模拟测试，后续部署实施可以参照high分支提供思路；cloud分支主要是boot，springcloud的ribbon调用demo；开发阶段主要参照**CLOUD分支**，**cloud是正在进行中的分支，如有需要新版本，可定期pull或者fetch此分支**。

- vir目录lyj.postman_collection.json为部分postman测试列子，如有需要可导入自己的postman模拟测试。
- 为了尽可能有限时间展示更多功能，例子都展示了一部分功能，并且每个列子都包含特有的功能（非对称性展示），实际上每个项目都可拥有所有功能，如果实际项目需要例子中提供的功能，都可以直接加在项目中，是可以支持的，请知悉。。。
- docker模拟测试通过，后续可根据情况选择是否docker容器化。
- 前后端分离：后台适用前后端分离，即单页面应用，但是需要seo优化的商城之类的网站建议使用传统前后混合或者使用pjax之类seo小影响的js局部刷新框架。
- 正在进行中：考虑鉴权认证和 用户身份session或者其他认证问题。。。。。。
# fastcloud cloud-oauth2-jwt branch 20171027
************************************
![JWT token](/cloud_images/auth.png "auth认证")
************************************
- 鉴权图示鉴权方式，各种端口通过zuul之类的代理，后续经过filter规则过滤，会首先代理至鉴权微服务，认证后会返回token，如果以后的访问携带token则可以直接访问符合权限的A,B,auth等。
- 主要搭建分布式权限架构，采用jwt 分布式存储权限，不考虑session同步方案，不考虑分布式session处理，采用jwt token机制进行权限精细化控制，目前暂时把权限控制集中放在springboot项目中，后期如果和一期或者后续工程要兼容，建议把权限控制统一设计，专项新建一个权限微服务，便于管理，有利于分布式部署管控。
- eureka 注册中心采用basic 配置即可，其它自己的业务微服务，采用basic auth + token控制权限，token目前采用对称秘钥保证安全，后续如果安全级别要求更高，可以设置非对称加密或者其他ekey等保证其安全，目前认为此类措施已足够保证其安全级别要求。非对称不再给出测试用例，后续根据实际情况可做处理。
- jwt token天生携带登录状态和权限相关数据，所以可支持单点登录，如果用户权限集中管控，后期单点登录方案是没问题的。
- 目前版本已经基本支持细粒度权限控制，目前建议使用@secured("ROLE_/test/test")访问，正在处理自定义投票器，取消role_前缀等措施。。。
- 状态：目前此分支没有和cloud分支merge，待合并状态。
# fastcloud high branch 20170913
springboot+springcloud 框架。
********************************
![云架构图](/cloud_images/cloud.jpg "springcloud")
****************************************
![总线](/cloud_images/bus.jpg "springbus")

## 环境注意事项

- JDK 8 +
- 请使用 fastcloud 根目录下 vir/apache-maven-3.1.1.zip,解压后配置到ide编辑器中使用，内置镜像，增加依赖下载速度。
- code 注释规范文件 vir/code_template.xml 请导入使用，规范注释，导入的时候勾选最下边的： Automatically add comments for new methods and types
- 如遇到maven依赖不全，请检查配置，并且一定要注意阿里支付的支付按照下方要求配置，才可编译通过


## 工程介绍
- fastcloud：父工程，主要管理子模块和通用的依赖
- eureka-server：eureka服务注册中心，主要提供服务注册平台
- eureka-client-01：eureka服务提供者-01，模拟测试eureka注册服务 
- eureka-client-02：eureka服务提供者-02，模拟测试eureka注册服务 ；eureka-client-01 && eureka-client-02同时启动可模拟服务提供集群环境
- feign-01：feign消费模式
- ribbon-01：ribbon消费模式（内含**断路器**模拟测试）
- config-client-01：模拟文件配置客户端获取configserver配置
- config-server-01：默认使用git搭建文件配置服务器
- zuul-01：模拟测试路由服务机制
- springboot：boot项目模拟测试，内置mybatis等较为细节的框架测试，后期如确定业务需求，可根据cloud各项模拟测试，选择性集成进springboot或者新建的其它boot&&cloud微服务。
- zipkin-*:服务调用追踪模拟测试。
- 后续其他监测组件可按照需求继续添加
****************************************

## 其它插件 && 注意事项
1. 消息总线依赖：rabbitmq && erlang环境下载地址  [百度云盘](http://pan.baidu.com/s/1slTugVj) <br>**--rabbitmq教程，请自行百度**
2. rabbitmq需要运行，默认端口5672，web管理默认端口：15672，rabbitmq 集群不做考虑，根据实施需求后期可研究
3. springcloud bus在 config-*中集成，如果git中的配置文件发生变化，请发送请求 <a>http://ip[localhost]:port/bus/refresh</a>,请求方式为post，以实时刷新微服务配置更新。后期公网可设置git webhook，变更配置文件，自动发送刷新请求。
4. 本项目总线模拟工具为postman，请自行下载，或者从网盘下载，网盘地址：<a>http://pan.baidu.com/s/1slTugVj</a>
5. git测试库地址为：<a>https://git.oschina.net/mytest2017/springcloud-config.git</a>，用户密码请参照config-*工程配置文件，随便使用，申请的是测试库。
6. zipkin 追踪模拟测试 服务端自带默认端口：9411  如果需要修改，请参照官网修改，如果报错，请注意此点。  --9411
7. 高可用注册中心 eureka server 采用spring profiles配置方式，maven命令运行的时候，请添加 --spring.profiles.active= your profile 参数，用来区别不同服务。
8. 工程根目录：模拟测试存储图片  存储部分测试过程的测试截图，有用到之处请查看。

# fastcloud cloud branch 20170919

- JDK 8 +

- springboot 应用内部细节构思细化，如果查看高可用分布式各种测试，请切分支high，本分支主要针对开发阶段，只需要关系自己负责的模块开发，其它分布式后期建议有专门负责人搭建。
- 工程构造整体主要采用插件式垂直拆分，部分采用水平拆分，避免过多依赖关系，造成混乱，比如：系统管理，web聊天等后期都可以从contoller至 daoimpl整体划分为maven一个插件，mybatis代码生成插件也在父工程中定义，为后续插件模块提供底层分离做准备。
- 如需支付，则需要把 ali.zip  解压至自己maven本地仓库 com目录下边，zip是阿里支付宝依赖jar，请按要求引入
- swagger访问地址：http://ip:port/swagger-ui.html，2017.10.19 删除掉了Spring-core模块，内含swagger测试，请切回：
 “ed1cd0a80  lyj   spring-core 模块移除，里边内置的swagger和其他测试，如何查看，请查看上一个版本。。。”

- thymeleaf：<br>
Maven的资源文件目录：/src/java/resources <br>
spring-boot项目静态文件目录：/src/java/resources/static <br>
spring-boot项目模板文件目录：/src/java/resources/templates <br>
spring-boot静态首页的支持，即index.html放在以下目录结构会直接映射到应用的根目录下： <br>

 ```
    classpath:/META-INF/resources/index.html
    classpath:/resources/index.html  
    classpath:/static/index.html  
    calsspath:/public/index.html 
 ```







<br><br><br><br><br><br><br>
>         宠辱不惊,闲看庭前花开花落.

>           去留无意,漫随天外云卷云舒.                                

