package proxy;

public class HelloWorldImpl implements HelloWorld{

	public void sayHelloWorld() {
		System.out.println("HelloWorld!");
	}

	@Override
	public void sayYes() {
		System.out.println("yes");
		
	}
}
