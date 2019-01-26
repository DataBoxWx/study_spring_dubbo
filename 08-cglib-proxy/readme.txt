08-cglib-proxy:使用cglib库的动态代理
步骤：
1.新建 java project
  导入cglib库的jar:  cglib-full.jar
2.定义目标类，不需要接口
3.定义方法拦截器的类，需要实现cglib库中的接口 MethodInterceptor.
  MethodInterceptor的作用等同于jdk中InvocationHandler
4.定义工具类， 创建代理对象，使用cglib的Enhancer对象。
5.定义测试类，测试cglib的代理
