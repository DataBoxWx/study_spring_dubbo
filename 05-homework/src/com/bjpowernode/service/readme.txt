07-jdk-proxy:使用jdk的动态代理

动态代理的主要作用：1.控制目标方法的访问（调用）；2.功能增强（目标类增加一功能）

jdk的动态代理：
  要求：目标类必须实现接口。
 jdk动态代理设计的类和接口： java.lang.reflect
 1.Proxy类， 静态方法 newProxyInstance()，创建代理对象。
 2.Method类， 表示目标方法， 通过他的 invoke()调用目标方法。
 3.InvocationHandler接口，调用处理器。 实现这个接口，在接口的invoke()方法中， 实现对目标方法的调用和功能的增强。
 
步骤：
1. 定义目标接口和实现类。
2. 定义实现InvocationHandler接口的调用处理器。 在invoke()中实现 功能增强。
3. 通过Proxy的静态方法，创建代理对象。
4. 通过代理代理对象的方法，实现功能增强。