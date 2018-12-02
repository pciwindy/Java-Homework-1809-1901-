package whichIsEqual;

/*
 * from: https://www.cnblogs.com/dolphin0520/p/3592500.html
 * 1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址

　　2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量
　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
 */

public class Example01 {
	public static void main(String[] args) {
		A A=new A();
		A B=new A();
		
		//equals可以用来比较字符串以及引用类型是否相等；但无法比较基本数据类型，如整形int,double
		System.out.println("基本数据类型int的对比----------------------------------------------------");
		int a1=17;
		int b1=17;
		System.out.println(a1==b1);
		System.out.println();
		
		System.out.println("对于类的比较-------------------------------------------------------------");
		//地址空间不同，==肯定false
		System.out.println("直接使用==");
		System.out.println(A==B);
		System.out.println("使用equals方法");
		//两个对象必须是同一地址引用，equals才为真。普通情况，为false。如果需要判断内容，需要重写。
		System.out.println(A.equals(B));
		System.out.println();
		
		//特殊情况1
		System.out.println("特殊情况1-两个常量字符串对象的比较------------------------------------------");
		String s1="helloworld";
		String s2="helloworld";
		System.out.println("直接使用==");
		//字符串存储在常量池中
		System.out.println(s1==s2);
		System.out.println("使用equals方法");
		//String重写了equals方法
		System.out.println(s1.equals(s2));
		System.out.println();
		
		//特殊情况2
		System.out.println("特殊情况2-两个字符串对象的比较----------------------------------------------");
		String s3=new String("phpbest!");
		String s4=new String("phpbest!");
		System.out.println("直接使用==");
		//新的内存分配已经出现！肯定直接是false
		System.out.println(s3==s4);
		System.out.println("使用equals方法");
		System.out.println(s3.equals(s4));
		System.out.println();
		
		System.out.println("特殊情况3-包装类数据类型Integer的对比(-128~127)-----------------------------");
		//对于包装类Integer来说，当数值为-128~127时，使用的是基本数据类型int
		Integer a2=78;
		Integer b2=78;
		System.out.println("直接使用==");
		System.out.println(a2==b2);
		System.out.println("使用equals方法");
		System.out.println(a2.equals(b2));
		System.out.println();
		
		System.out.println("特殊情况4-包装类数据类型Integer的对比(非-128~127)----------------------------");
		//对于包装类Integer来说，当数值非-128~127时，不会重复使用
		Integer a3=129;
		Integer b3=129;
		System.out.println("直接使用==");
		System.out.println(a3==b3);
		System.out.println("使用equals方法");
		System.out.println(a3.equals(b3));
		System.out.println();
		
		//这行代码说明了int与包装类比大小时包装类会自动拆箱
		//System.out.println(a3==129);
	}
}
