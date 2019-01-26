15-returnObject-Student:处理器方法返回是对象（Object），对象表示数据，和视图无关
处理器方法返回String , Integer , Student ,List ,Map等等都是对象，是数据。

要实现处理器方法返回对象，表示数据，响应Ajax步骤：
1）大多数的操作是用json数据格式， 所以要加入json的工具库， springmvc框架默认使用Jackson
2）在springmvc的配置文件中，加入注解驱动<mvc:annotation-driven/> . 目的是由框架创建
   HttpMessageConverter接口的7个实现类对象。
3）在处理器方法的上面，加入@ResponeBody


HttpMessageConverter接口的作用：
1.把请求的数据转为java对象。 涉及到canRead(), read()
2.把处理器方法返回值（对象），转为某种格式的数据。涉及到canWrite(), write()



步骤：
1.新建 java web project
2.导入jar:
  1)spring的核心jar：spring-beans.jar,spring-core.jar,spring-context.jar,spring-expression.jar
  2)spring-aop.jar
  3)spring-web.jar 
  4)springmvc的核心：spring-webmvc.jar
  5)日志：commons-logging.jar
  6)json的工具库：JackSon ， springmvc默认操作 json的工具库就是JackSon.
3.重点： 修改web.xml 注册中央调度器对象 DispatcherServlet.
  DispatcherServlet是springmvc框架的核心对象， 是用来接收用户的请求，并显示处理结果的。
    它是一个Servlet , 使用<servlet>注册并使用它。
  DispatcherServlet也称为叫前端控制器（front controller）
4.新建jsp，发起请求
     加入JQuery的文件， 发起ajax请求。 
     有参数 name ,age 
5.定义处理器（控制器）
  1）在类的上面加入@Controller , 创建处理器对象。
  2）在类中定义方法， 方法的上面加入@RequestMapping(value="请求的uri") ，
         在加入@ResponseBody
       
     
6.新建jsp，显示处理结果。
7.定义springmvc的配置文件。（springmvc相当于web中的spring） ，springmvc也是个容器。
    管理视图层的对象。
  1）声明组件扫描器，base-package指定@Controller包的名
  2）声明视图解析器
  3）声明注解驱动

    
  