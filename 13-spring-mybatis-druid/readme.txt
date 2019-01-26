13-spring-mybatis-druid：spring整合mybatis,使用阿里的druid连接池

spring整合mybatis的想法：
  mybatis的对象交给spring创建和管理。
   哪些对象交给spring？
  1.数据源DataSource,访问数据库的。（dbcp,druid）
  2.SqlSessionFactoryBean,用来创建SqlSessionFactory -- SqlSession
  3.Mybatis的扫描器对象， 这个对象用到了MyBatis的动态代理技术， 可以创建Dao接口的实现类对象。
  
步骤：
0.建数据库和表， student : id ,name ,age 
1.新建 java project
2.导入jar:
  1)spring核心的jar:spring-bean.jar,spring-core.jar,spring-context.jar,spring-expression.jar
  2)和数据库，事务有关的jar: spring-aop.jar, spring-jdbc.jar , spring-tx.jar 
  3)mybatis的核心jar：mybatis-3.4.5.jar
  4)mybatis和spring的整合包： 整合包就是一个桥梁， 让两个框架能够一起使用。 
     mybatis-spring-1.3.1.jar :  能够在spring框架中创建mybatis的对象。
  5)其他的jar: mysql的驱动，数据库连接池 druid-1.19.jar , 日志 commons-logging.jar , log4j.jar, junit.jar
3.定义实体类， Student , 要求属性名和表的列名一样。
4.定义Dao的接口和Sql映射文件
5.定义mybatis的主配置文件
6.定义Service接口和它的实现类， 在实现类中有属性是Dao。
7.定义spring的配置文件
  1）声明数据源DataSource,访问数据库的
  2）声明SqlSessionFactoryBean，创建SqlSessionFactory对象。
  3）声明MyBatis的扫描器对象， 使用MyBatis的动态代理技术，创建Dao接口的实现类对象。
  4）声明Service对象， 把3）中Dao对象注入给Service属性
8.定义测试类， 使用Service，访问Dao,操作数据库
  
  
  
     

  