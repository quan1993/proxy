package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {

		HelloWorld helloWorld=new HelloWorldImpl();
		InvocationHandler handler=new HelloHandler(helloWorld);
		
		
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
