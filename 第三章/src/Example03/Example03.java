package Example03;

class Student{
	String name;
	int age;
	public void introduce(){
			System.out.println("��Һã��ҽ�"+name+",�ҽ���"+age+"��");
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