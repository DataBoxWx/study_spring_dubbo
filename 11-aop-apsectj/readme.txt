11-aop-apsectj:使用AspectJ框架实现Aop

aspectj是一个独立的框架，实现aop.

apsectj实现aop的方式有两种：
1.使用xml配置。
2.使用注解实现aop
  1.前置通知@Before
  2.后置通知@AfterReturning
  3.环绕通知@Around
  4.异常通知@AfterThrowing
  5.最终通知@After

步骤：
1.新建 java project
2.导入jar:
   必须的jar:
  1)spring的核心jar: spring-beans.jar spring-core.jar spring-context.jar spring-expression.jar
  2)日志jar: commons-logging.jar （spring框架中打印日志使用的是commons-logging.jar中的方法）
  可选的：
  1)实现的实现jar: log4j.jar
  2)单元测试：junit.jar

  使用AspectJ实现aop
  1）spring-aop.jar
  2）apspectj自己的jar: aspectjrt.jar aspectjweaver.jar
  
3.定义目标接口和实现类。

4.定义切面类，实现功能的增强
  1)在类的上面加入 AspectJ框架的注解@Aspect
  2)在类中定义方法， 方法就是功能增强的代码。 在方法的上面加入通知注解
      例如 @Before(value="切入点表达式")
      
5.定义spring的配置文件
  1）声明目标对象
  2）声明切面类对象
  3）声明自动代理生成器，创建目标对象的代理对象。
  
6.定义测试， 从spring容器中获取目标对象（目标对象是aspectJ修改后的代理对象）
  通过代理对象执行业务方法， 实现切面的功能增强。
