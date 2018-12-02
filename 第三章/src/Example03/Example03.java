package Example03;

class Student{
	String name;
	int age;
	public void introduce(){
			System.out.println("大家好，我叫"+name+",我今年"+age+"岁");
	}
}

public class Example03{
	public static void main(String[] args){
		Student stu=new Student();
		stu.name="wwww";
		stu.age=-30;
		stu.introduce();
	}
}