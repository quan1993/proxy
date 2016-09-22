package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {

		HelloWorld helloWorld=new HelloWorldImpl();
		InvocationHandler handler=new HelloHandler(helloWorld);
		
			/**
		 *  newProxyInstance()--创建代理对象
		 * @param ClassLoader
		 * 			用于加载代理类的Loader类,通常这个Loader和被代理的类是同一个Loader类
		 * @param Interfaces
		 * 			要被代理的哪些接口
		 * @param InvocationHandler
		 * 			用于执行除了被代理接口中方法之外的用户自定义的操作,也是用户需要代理的最终目的
		 * 			用户调用目标方法都被代理到InvocationHandler类中定义的唯一方法invoke中
		 */
		
		//创建动态代理对象
		HelloWorld proxy=(HelloWorld)Proxy.newProxyInstance(
				helloWorld.getClass().getClassLoader(), 
				helloWorld.getClass().getInterfaces(), 
				handler);
		System.out.println(proxy.getClass().getName());
		proxy.sayHelloWorld();
		proxy.sayYes();
		//调用顺序：HelloWord.sayYes()---->HelloWorldHandler.invoke()----->HelloWordImpl.sayYes()
		

		HelloPeople people = new HelloPeopleImpl();
		InvocationHandler han = new HelloHandler(people);
		HelloPeople peo = (HelloPeople) Proxy.newProxyInstance(
				people.getClass().getClassLoader(), 
				people.getClass().getInterfaces(), 
				han);
		System.out.println(peo.getClass().getName());
		peo.sayPeople();
		
		
		//动态代理可以实现代理不同的类
		
	}


}
