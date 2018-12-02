package Example10;

class Person{
	Person(){
		System.out.println("无参的构造方法被调用了.......");
	}
	Person(String name){
		this();
		System.out.println("有参的构造方法被调用了.......");
	}
}

public class Example10{
	public static void main(String[] args){
		Person p=new Person("itcast");
	}
}
