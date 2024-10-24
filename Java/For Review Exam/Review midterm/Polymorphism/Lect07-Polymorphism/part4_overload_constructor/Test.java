package part4_overload_constructor;

public class Test {

	public static void main(String[] agrs){
		B b = new B();
		A a = new A();
	}
}

class A{
	public A(){
		System.out.print(1);
	}
}

class B extends A{
	public B(){
		super();
		System.out.print(2);
	}
}