package P162_6_1;

class Student{
	public String name;
	public int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void show(){
		System.out.println("My name is "+name+",My age is "+age);
	}
}

class Undergraduate extends Student{
	public String degree;
	public Undergraduate(String name,int age,String degree){
		super(name,age);
		this.degree=degree;
	}
	public void show(){
		System.out.println("My name is "+name+",My age is "+age+",My degree is "+degree);
	}
}

public class Test01{
	public static void main(String[] args){
		Student stu=new Student("PCI_Windy",18);
		Undergraduate ugstu=new Undergraduate("PCI_Windy",18,"10086");
		stu.show();
		ugstu.show();
	}
}
