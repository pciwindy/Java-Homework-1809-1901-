package Example07;

class Person{
	String name;
	int age;
	Person(String con_name,int con_age){
		name=con_name;
		age=con_age;
	}

	Person(String con_name){
		name=con_name;
	}

	void speak(){
		System.out.println("��Һ�,�ҽ�"+name+",�ҽ���"+age+"��!!!");
	}
}

public class Example07{
	public static void main(String[] args){
		Person p1=new Person("www");
		Person p2=new Person("www",18);
		p1.speak();
		p2.speak();
	}
}