package P198_6_3_Upper1;

public class TeacherThread implements Runnable{
	Object lock=new Object();   //�½�һ����
	private int N=80; 
	public void run() {
		synchronized (lock) {         //��ס����
			while(true) {
				if(N>0) {
					System.out.println(Thread.currentThread().getName()+"���ڷַ���"+N+"����ҵ");
					N--;
				}
				else {
					break;
				}
			}
		}
	}
}
