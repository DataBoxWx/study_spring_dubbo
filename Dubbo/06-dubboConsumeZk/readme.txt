06-dubboConsumeZk:消费者项目， 调用服务提供者。使用注册中心Zookeeper

步骤：
1.新建 java 项目
2.导入jar：
  1）dubbo框架的jar: dubbo-2.5.3.jar
  2）网络通信的jar: netty.jar
  3）动态代理有关的： javassist.jar
  4）spring的相关jar: spring-*.jar
  5）服务提供者的jar：05-dubboInterface.jar
  6）加入注册中心的jar: zkclient.jar, zookeeper.jar
3.定义spring的配置文件， 声明要使用的远程服务。
     声明注册中心的地址
4.定义测试类， 调用远程服务
