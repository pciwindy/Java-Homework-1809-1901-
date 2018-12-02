package P198_6_1;

public class Example01 {
	public static void main(String[] args) {
		MyThread myThread1=new MyThread("t1");  //新建一个线程
		MyThread myThread2=new MyThread("t2");  //这也是新建一个进程
		myThread1.start();                                            //运行第一个线程
		myThread2.start();                                            //运行第二个线程
	}
}
