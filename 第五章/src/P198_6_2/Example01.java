package P198_6_2;

public class Example01 {
	public static void  main(String[] args) {
		//��̬�Ǹ��� ˭��˭֪��
		MyThread myThread=new MyThread();        //��Ϊʹ���˶�̬ ���½�һ��Thread
		Thread th=new Thread(myThread);               //�ö�̬��������߳�
		th.start();                                                        //��������߳�
		
		for(int i=0;i<100;i++) {
			System.out.println("main");          //���߳���Ȼ������
		}
	}
}
