package P198_6_3_Upper1;

public class TeacherThread implements Runnable{
	Object lock=new Object();   //新建一个锁
	private int N=80; 
	public void run() {
		synchronized (lock) {         //锁住代码
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
}
