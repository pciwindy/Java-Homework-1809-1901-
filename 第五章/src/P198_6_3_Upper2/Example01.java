package P198_6_3_Upper2;

//ʹ��ͬ����������̰߳�ȫ����
public class Example01 {
	public static void main(String[] args) {
		TeacherThread tt=new TeacherThread();
		new Thread(tt,"����ʦ").start();        //���������ĺ���
		new Thread(tt,"����ʦ").start();        //��Ҫ����
		new Thread(tt,"����ʦ").start();
	}
}
