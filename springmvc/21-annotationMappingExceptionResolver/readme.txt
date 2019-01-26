21-annotationMappingExceptionResolver:使用注解处理异常。
@ExceptionHandler(value=异常.class)

使用注解处理异常：
1.在处理器类中，定义方法，在方法的上面加入@ExceptionHandler(value=异常.class)
2.当使用RequestMapping修饰的方法，抛出异常时，会自动调用@ExceptionHandler修饰的方法处理异常。
  @ExceptionHandler修饰的方法， 它的返回值就是用户看到的结果。

步骤：
1.新建 java web project
2.导入jar:
  1)spring的核心jar：spring-beans.jar,spring-core.jar,spring-context.jar,spring-expression.jar
  2)spring-aop.jar
  3)spring-web.jar 
  4)springmvc的核心：spring-webmvc.jar
  5)日志：commons-logging.jar
3.重点： 修改web.xml 注册中央调度器对象 DispatcherServlet.
  DispatcherServlet是springmvc框架的核心对象， 是用来接收用户的请求，并显示处理结果的。
    它是一个Servlet , 使用<servlet>注册并使用它。
  DispatcherServlet也称为叫前端控制器（front controller）

4.新建异常类， 父类MyUserException , 子类 NameException ,AgeException
  
5.新建jsp，发起请求
     有参数 name ,age 
6.定义处理器（控制器）
  1）在类的上面加入@Controller , 创建处理器对象。
  2）在类中定义方法， 方法的上面加入@RequestMapping(value="请求的uri")
     根据请求的参数值， name， age 分别抛出异常  NameException , AgeException 
     
7.新建jsp，显示处理结果。
8.定义处理异常的视图页面， nameError.jsp , ageError.jsp , defaultError.jsp

8.定义springmvc的配置文件。（springmvc相当于web中的spring） ，springmvc也是个容器。
    管理视图层的对象。
  1）声明组件扫描器，base-package指定@Controller包的名
  2）声明视图解析器
  3）声明异常处理器，配置它的属性， 处理异常。
    
  