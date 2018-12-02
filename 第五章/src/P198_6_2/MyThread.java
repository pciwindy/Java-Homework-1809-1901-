package P198_6_2;

public class MyThread implements Runnable {
	public int times=50;
	public void run() {
		while(true) {
			if(times>0) {
				System.out.println("new");
				times--;
			}
			else {
				break;
			}
		}
	}
}
