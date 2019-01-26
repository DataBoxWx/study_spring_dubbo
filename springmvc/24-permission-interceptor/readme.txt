24-permission-interceptor:权限的拦截器
拦截器的作用:拦截用户的请求， 判断请求是否合法， 如果是合法的请求可以被系统处理，否则终止执行。
拦截器的执行时间点： 在获取到处理器的适配器对象之后， 在处理器方法执行之前，拦截用户的请求。
拦截器是全局的，可以拦截所有的请求。  一个程序可以有  0 或 多个 拦截器。
定义拦截器：
1.定义类实现拦截器的接口HandleInterceptor
2.在springmvc的配置文件中，声明拦截器，指定拦截的uri地址。


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
4.新建jsp，发起请求
     有参数 name ,age 
     
5.定义类实现HandleInterceptor接口， 重写接口中的三个方法。
    在preHandle()验证用户的登录信息， 用户的信息是存在Session中的。

6.定义处理器（控制器）
  1）在类的上面加入@Controller , 创建处理器对象。
  2）在类中定义方法， 方法的上面加入@RequestMapping(value="请求的uri")
     处理器方法的形参定义String name , int age
     
7.新建jsp，显示处理结果。
8.新建login.jsp, 模拟登录， 把用户信息存在session
9.新建logout.jsp ，退出系统
 
10.定义springmvc的配置文件。（springmvc相当于web中的spring） ，springmvc也是个容器。
    管理视图层的对象。
  1）声明组件扫描器，base-package指定@Controller包的名
  2）声明视图解析器
  3）声明拦截器对象
    
  