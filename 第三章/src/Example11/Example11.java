package Example11;

class Person{
	public void finalize(){
		System.out.println("对象将被作为垃圾回收......");
	}
}

public class Example11{
	public static void main(String[] args){
		Person p1=new Person();
		Person p2=new Person();
		p1=null;
		p2=null;

		System.gc();
		for(int i=0;i<1000000;i++){}
	}
}
