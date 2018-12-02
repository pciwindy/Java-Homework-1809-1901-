package Example01;

class Person{
	int age;
	void speak(){
		System.out.println("大家好，我今年"+age+"岁");
	}
}

class Example01{
	public static void main(String[] args){
		Person p1=new Person();
		Person p2=new Person();
		p1.age=18;
		p1.speak();
		p2.speak();
	}
}
