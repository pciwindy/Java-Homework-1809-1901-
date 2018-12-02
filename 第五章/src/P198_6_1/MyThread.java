package P198_6_1;

public class MyThread extends Thread {
	public String aName;                                 //新建一个字符串显示进程名
	public MyThread(String Name) {
		aName=Name;                          //传入进程名
	}
	public void run() {
		while(true) {
			System.out.println(aName+" is running");
		}
	}
}
