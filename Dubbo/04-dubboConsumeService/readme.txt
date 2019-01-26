04-dubboConsumeService:消费者项目， 调用服务提供者。

步骤：
1.新建 java 项目
2.导入jar：
  1）dubbo框架的jar: dubbo-2.5.3.jar
  2）网络通信的jar: netty.jar
  3）动态代理有关的： javassist.jar
  4）spring的相关jar: spring-*.jar
  5）服务提供者的jar：04-dubboProvider.jar
3.定义spring的配置文件， 声明要使用的远程服务。
4.定义测试类， 调用远程服务
