25-SSM: 实现SSM整合， 搭建项目的开发环境
SSM:SpringMVC + Spring + MyBatis 
SSI:SpringMVC + Spring + IBatis 

SSM的整合思路： 把三层架构中的对象，交给不同的容器管理。
视图层对象交给SpringMVC容器管理， 视图层的对象定义在springmv的配置文件中。
业务层和Dao层的对象交给Spring容器管理， 定义在spring的配置文件中。

定义在SpringMVC配置文件中的对象？
1.使用注解@Controller创建处理器对象， 声明组件扫描器， base-package="@Controller注解所在的包名"
2.视图解析器
3.注解驱动

定义在Spring的配置文件中对象？
1.使用注解@Service创建业务层对象，声明组件扫描器，  base-package="@Service注解所在的包名"
2.数据源DataSource( dbcp , druid)
3.声明SqlSessionFactoryBean , 创建SqlSessionFactory
4.声明MyBatis配置器， 使用动态代理，创建Dao接口的实现类对象


程序中有两个容器 SpringMVC ， Spring 
SpringMVC -- Controller
Spring  --  Service  -- Dao

用户请求的顺序 Controller --> Service  --> Dao

两个容器的沟通： SpringMVC是Spring的子容器，  就可以使用Controller访问Service,当反过来Service不能访问Controller
实现父子关系是在SpringMVC容器中一个属性parent。 parent的值是Spring的容器对象。
这样在SpringMVC  -- parent  -- Spring里面的Service

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
  1)注册spring的监听器，创建Spring容器对象， 加载spring的配置文件， 创建文件中的对象
  2)注册springmvc的中央调度器，创建SpringMVC容器对象， 加载springmvc的配置文件， 创建文件中的对象
  3)注册字符集过滤器，解决post请求乱码的问题
  
5.定义程序中的包结构。

6.定义spring  , springmvc , mybatis, 数据库的属性配置文件。

7.编写代码， 定义实体类 ，Dao接口和sql映射文件， Service接口和实现类；注入Dao对象。
    处理器类；注入Service。
    
8.定义视图文件（jsp）






