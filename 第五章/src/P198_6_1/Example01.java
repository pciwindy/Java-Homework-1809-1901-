package P198_6_1;

public class Example01 {
	public static void main(String[] args) {
		MyThread myThread1=new MyThread("t1");  //�½�һ���߳�
		MyThread myThread2=new MyThread("t2");  //��Ҳ���½�һ������
		myThread1.start();                                            //���е�һ���߳�
		myThread2.start();                                            //���еڶ����߳�
	}
}
