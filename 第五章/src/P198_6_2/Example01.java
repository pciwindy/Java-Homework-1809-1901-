package P198_6_2;

public class Example01 {
	public static void  main(String[] args) {
		//静态是个坑 谁用谁知道
		MyThread myThread=new MyThread();        //因为使用了多态 先新建一个Thread
		Thread th=new Thread(myThread);               //用多态调用这个线程
		th.start();                                                        //启动这个线程
		
		for(int i=0;i<100;i++) {
			System.out.println("main");          //主线程依然在运行
		}
	}
}
