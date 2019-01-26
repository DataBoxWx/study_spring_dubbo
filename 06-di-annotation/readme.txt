06-di-annotation：依赖注入,就是给属性赋值。

依赖注入的分类
1.设值注入：调用类的set方法，完成属性赋值。
2.构造注入：调用类的构造方法，创建对象的同时，在构造方法中给属性赋值

依赖注入的实现方式：
1.基于xml配置文件：在spring的配置文件中，使用标签和属性完成属性赋值
2.基于注解，使用注解来创建对象，给属性赋值

步骤：
1.新建 java project
2.导入jar:
   必须的jar:
  1)spring的核心jar: spring-beans.jar spring-core.jar spring-context.jar spring-expression.jar
  2)日志jar: commons-logging.jar （spring框架中打印日志使用的是commons-logging.jar中的方法）
  可选的：
  1)实现的实现jar: log4j.jar
  2)单元测试：junit.jar
  使用注解需要的jar:
  1)spring-aop.jar  

3.定义业务类（接口和实现类）：说明没有接口也是可以的。
4.定义spring的配置文件（myobject.txt）。 配置文件是xml格式的。
  1)加入spring的约束文件 spring-context.xsd
  2)声明组件扫描器，指定注解的位置（包名）
  
  bean： 由spring框架管理的java对象，称为bean.
5.定义测试。 测试spring的功能点。
    创建spring的容器对象，使用接口ApplicationContext .
   接口的有两个常用实现类
  1.ClassPathXmlApplicationContext
  2.FileSystemXmlAppliationContext
  