package Example04;

class Student{
	private String name;
	private int age;
	
	public String getName(){
		return name;
	}
	public void setName(String stuName){
		name=stuName;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int stuAge){
		if(stuAge<=0){
			System.out.println("这个年龄不合法！！！");
		}
		else{
			age=stuAge;
		}
	}
	public void introduce(){
		System.out.println("大家好，我叫"+name+",我今年"+age+"岁!");
	}
}

public class Example04{
	public static void main(String[] args){
		Student stu=new Student();
		stu.setAge(-30);
		stu.setName("wwww");
		stu.introduce();
	}
}
	