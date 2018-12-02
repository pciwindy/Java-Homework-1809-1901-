package P162_6_3;

class NoThisSoundException extends Exception{
	public NoThisSoundException(){
		super();//构造器主要用来分配内存等JVM初始化，所以必须第一个调用
		System.out.println("这是一个无参的调用异常的方法，并且我没有自定义异常信息");
		System.out.println("没有自定义异常信息！");
	}
	public NoThisSoundException(String message){
		super(message);//将自定义的异常信息传至Exception中
		System.out.println("这是一个有参的调用异常的方法");
	}
}