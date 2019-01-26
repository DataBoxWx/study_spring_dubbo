06-dubboProviderZk: 服务提供者项目 ， 使用zookeeper注册中心
服务提供者是提供服务的， 由消费者调用。

步骤：
1.新建 web 应用。
2.导入jar：
  1）dubbo框架的jar: dubbo-2.5.3.jar
  2）网络通信的jar: netty.jar
  3）动态代理有关的： javassist.jar
  4）spring的相关jar: spring-*.jar
  5）接口项目的jar:05-dubboInterface.jar
  6）加入注册中心的jar: zkclient.jar, zookeeper.jar
3.定义实体类，保存网络通信的数据。 这个类必须实现序列化接口。
4.定义业务接口和实现类。
5.定义spring的配置文件。 
  1）暴露服务， 让消费者调用。
  2）定义服务实现类的对象（用由这个对象提供服务的实现）
  3）声明注册中心zookeeper的地址信息
6.定义测试， 创建spring的容器对象， 检查配置文件是否正确。
7.注册监听器，修改web.xml， 注册ContextLoaderListener.
8.将暴露的服务导出为 jar 文件。 导出的jar文件给消费者使用。
 
  