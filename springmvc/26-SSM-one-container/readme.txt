26-SSM-one-container: 实现SSM整合， 搭建项目的开发环境
SSM:SpringMVC + Spring + MyBatis 
SSI:SpringMVC + Spring + IBatis 

一个SpringMVC容器，管理程序中的所有对象。

步骤：
1.使用springdb库， 表student. 
  id int 自动增长的， 作为 primary key
  name varchar 50 姓名
  age int 年龄
2.新建 web project
3.导入jar：
  1.spring的核心：spring-beans.jar,spring-core.jar,spring-context.jar,spring-expression.jar
  2.注解：spring-aop.jar
  3.web相关：spring-web.jar,spring-webmvc.jar
  4.访问数据库和事务： spring-jdbc.jar,spring-tx.jar
  5.mybatis的核心： mybatis-3.4.5.jar
  6.mybatis和spring的整合： mybatis-spring-1.3.1.jar
  7.日志：commons-logging.jar, log4j.jar
  8.数据源，连接池 dbcp, druid
  9.mysql的驱动
  10.支持json:Jackson相关jar
  
4.修改web.xml
  1)注册springmvc的中央调度器，创建SpringMVC容器对象， 加载springmvc的配置文件， 创建文件中的对象
  2)注册字符集过滤器，解决post请求乱码的问题
  
5.定义程序中的包结构。

6.定义 springmvc , mybatis, 数据库的属性配置文件。

7.编写代码， 定义实体类 ，Dao接口和sql映射文件， Service接口和实现类；注入Dao对象。
    处理器类；注入Service。
    
8.定义视图文件（jsp）






