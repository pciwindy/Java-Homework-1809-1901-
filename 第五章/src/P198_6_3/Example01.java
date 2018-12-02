package P198_6_3;

//此代码中有严重的安全问题 将在作业2中解决
public class Example01 {
	public static void main(String[] args) {
		TeacherThread tt=new TeacherThread();
		new Thread(tt,"王老师").start();        //这个命名真的很迷
		new Thread(tt,"胡老师").start();        //需要翻书
		new Thread(tt,"张老师").start();
	}
}
