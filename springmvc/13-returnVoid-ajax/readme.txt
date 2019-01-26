13-returnVoid-ajax:处理器方法返回void,响应ajax
void返回值没有数据，也没有视图， 通过HttpServletResponse的输出流，将数据输出给浏览器。

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
  2）在类中定义方法， 方法的上面加入@RequestMapping(value="请求的uri")
     处理器方法的形参定义String name , int age
     
6.新建jsp，显示处理结果。
7.定义springmvc的配置文件。（springmvc相当于web中的spring） ，springmvc也是个容器。
    管理视图层的对象。
  1）声明组件扫描器，base-package指定@Controller包的名
  2）声明视图解析器
8.修改处理器ModelAndView的视图名称，使用逻辑视图名称。  
    
  