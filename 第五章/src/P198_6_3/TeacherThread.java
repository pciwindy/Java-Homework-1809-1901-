package P198_6_3;

public class TeacherThread implements Runnable{
	private int N=80;
	public void run() {
		while(true) {
			if(N>0) {
				System.out.println(Thread.currentThread().getName()+"正在分发第"+N+"项作业");
				N--;
			}
			else {
				break;
			}
		}
	}
	
}
