package P198_6_3_Upper2;

public class TeacherThread implements Runnable{
	private int N=80;
	public void run() {
		while(true) {
			faBiJi();               //调用了发笔记函数
			if(N<=0) {
				break;				//循环emmmm要退出
			}
		}
	}
	
	private synchronized void faBiJi(){
		if(N>0){
			try {                   //不睡觉别的进不来！
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName()+"正在分发第"+N+"项作业");
					N--;
				} 
			catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				}
		}
	}
}


