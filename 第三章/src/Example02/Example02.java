package Example02;

class Person{
	void say(){
		System.out.println("����һ���ˣ�");
	}
}

class Example02 {
	public static void main(String[] args){
		Person p2=new Person();
		p2.say();
		p2=null;
		p2.say();
	}
}