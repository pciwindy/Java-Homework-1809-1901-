package P198_6_3;

public class TeacherThread implements Runnable{
	private int N=80;
	public void run() {
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
