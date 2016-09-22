# proxy
a demo of proxy 




	Proxy.newProxyInstance方法会做如下几件事：

1，根据传入的第二个参数interfaces动态生成一个类，实现interfaces中的接口，该例中即HelloWorld接口的sayHelloWorld()、sayYes()方法。并且继承了Proxy类，重写了hashcode,toString,equals等三个方法。具体实现可参看 ProxyGenerator.generateProxyClass(...); 该例中生成了$Proxy0类

2，通过传入的第一个参数classloder将刚生成的类加载到jvm中。即将$Proxy0类load

3，利用第三个参数，调用$Proxy0的$Proxy0(InvocationHandler)构造函数 创建$Proxy0的对象，并且用interfaces参数遍历其所有接口的方法，并生成Method对象初始化对象的几个Method成员变量

4，将$Proxy0的实例返回给客户端。

<b>因此</b>

1，客户端拿到的是$Proxy0的实例对象，由于$Proxy0继承了HelloWord，因此转化为HelloWord没任何问题。

HelloWord helloWord = (HelloWord)Proxy.newProxyInstance(....);

2，HelloWord.sayHelloWord()；

实际上调用的是$Proxy0.sayHelloWord();那么$Proxy0.sayHelloWord()的实现就是通过InvocationHandler去调用invoke方法啦!
