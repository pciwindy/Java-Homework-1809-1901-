package P198_6_3;

//�˴����������صİ�ȫ���� ������ҵ2�н��
public class Example01 {
	public static void main(String[] args) {
		TeacherThread tt=new TeacherThread();
		new Thread(tt,"����ʦ").start();        //���������ĺ���
		new Thread(tt,"����ʦ").start();        //��Ҫ����
		new Thread(tt,"����ʦ").start();
	}
}
