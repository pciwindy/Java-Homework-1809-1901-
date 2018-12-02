package P198_6_3_Upper2;

//使用同步方法解决线程安全问题
public class Example01 {
	public static void main(String[] args) {
		TeacherThread tt=new TeacherThread();
		new Thread(tt,"王老师").start();        //这个命名真的很迷
		new Thread(tt,"胡老师").start();        //需要翻书
		new Thread(tt,"张老师").start();
	}
}
