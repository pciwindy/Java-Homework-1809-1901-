package Example10;

class Person{
	Person(){
		System.out.println("�޲εĹ��췽����������.......");
	}
	Person(String name){
		this();
		System.out.println("�вεĹ��췽����������.......");
	}
}

public class Example10{
	public static void main(String[] args){
		Person p=new Person("itcast");
	}
}
