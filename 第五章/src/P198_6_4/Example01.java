package P198_6_4;

/*
 * 难点1：将开始值传入线程中
 * 难点2：全局变量的使用
 * 难点3：同步方法防止数据添加的问题
 * 难点4：添加数据时出现的执行问题

	初始的思路是将其分开编写 但是发现无法获取线程里面的变量
	后来查阅答案发现是将main写入一个类中
	只能作罢
 */
public class Example01 implements Runnable{		//用Runnable实现线程
	public int num;                          //存开始打那个数据啊
	public static int a;                     //存放最后的结果
	
	public Example01(int num) {
		this.num=num;						//存数据
	}
	
	public synchronized void add(int anum) {//同步方法，使数据更新时不会受到影响
		a=a+anum;							//相加啊
		
	}
	public void run() {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum=sum+num+i;					//1+2+3+...+10用这个
		}
		add(sum);							//相加结果
	}
	
	public static void  main(String[] args){
		Thread[] tl=new Thread[10];			//用数组管理线程
		for(int i=0;i<10;i++) {
			tl[i]=new Thread(new Example01(i*10+1));//调用构造方法传输开始值
			tl[i].start();					//启动线程
		}
		for(int j=0;j<10;j++) {
			try {
				tl[j].join();				//使用join使得下面的语句在最后执行，防止出现没有执行完就会出现的总数问题
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		System.out.println("总数是 "+a);
	}
}

