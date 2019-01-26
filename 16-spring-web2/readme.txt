16-spring-web2: 在web应用中使用spring


WebApplicationContext是web应用中使用的Spring容器
public interface WebApplicationContext extends ApplicationContext
public interface ConfigurableWebApplicationContext extends WebApplicationContext

把创建好的容器对象，放入到ServletContext作用域。
key:WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE
    WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE

servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);



 监听器启动的过程：
1.创建了容器对象 WebApplicationContext
2.把创建好的容器对象，放入到ServletContext作用域。
  key：WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE
  
 监听器的销毁：
1.关闭了容器对象， 会自动调用容器中对象的销毁方法。

步骤：
1.新建web应用
2.拷贝14-spring-mybatis-dbcp中的src ,  配置文件，  libs下面的jar
3.新建jsp ，发起请求 name, age两个参数
4.新建Servlet，接收页面的参数， 创建spring的容器， 调用Service方法
5.新建jsp，显示业务方法的处理结果。
6.修改web.xml，注册自定义的Servlet
