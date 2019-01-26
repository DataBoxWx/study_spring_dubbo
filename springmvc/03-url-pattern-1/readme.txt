03-url-pattern-1：设置中央调度器的url-pattern为“/”
第一种解决静态资源的访问。
在springmvc的配置文件中，加入<mvc:default-servlet-handler/>
加入标签后，springmvc框架会到服务器（tomcat）去寻找一个叫default的Servlet处理静态资源的请求。
也就是把静态资源的请求交给服务器（tomcat）处理， 动态资源由中央调度器自己处理。

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
5.定义处理器（控制器），在配置式开发中需要实现接口Controller.
6.新建jsp，显示处理结果。
7.定义springmvc的配置文件。（springmvc相当于web中的spring） ，springmvc也是个容器。
    管理视图层的对象。
  1）声明处理器对象。
  2）声明视图解析器
8.修改处理器ModelAndView的视图名称，使用逻辑视图名称。  
    
  