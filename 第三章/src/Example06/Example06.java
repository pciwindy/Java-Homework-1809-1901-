package Example06;

class Person{
	int age;
	Person(int a){
		age=a;
	}
	public void speak(){
		System.out.println("I am "+age+" years old.");
	}
}

public class Example06{
	public static void main(String[] args){
		Person p=new Person(18);
		p.speak();
	}
}
