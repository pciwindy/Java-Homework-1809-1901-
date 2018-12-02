package P280_6_2;

import java.util.HashSet;

class Person{
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	//重写toString，这样可以改变输出样式
	public String toString() {
		return "姓名为"+name+",年龄为"+age;
	}
	
	//返回哈希值
	public int hashCode() {
		return name.hashCode();
	}
	
	//解决equals的普通方法，重写让其可以判断类内部姓名
	public boolean equals(Object obj) {
		//此处比较的是地址！！！！地址相同则肯定是同一个！
		if(this==obj) {
			return true;
		}
		//如果这个类它不是Person，直接false
		if (!(obj instanceof Person)) {
			return false;
		}
		//将传入参数强制转换成为Person，用于检测内部姓名
		Person p=(Person)obj;
		//返回姓名的检测值
		//个人猜想：此时使用了迭代器将之前的数据取出并且一一对比，不知道原理上是否是这样进行的。
		boolean b=this.name.equals(p.name);
		return b;
		
		/*
		 * 先判断哈希值，如果姓名和年龄相等，就会进入equals，不等则直接存储
		 * equals已经被改写，所以在判断姓名时相等，返回true
		 * 两个对象相等时（均为true），就不会存储
		 * 原先会被存储的原因为二者哈希值相等进入equals但是内存地址不同所以被存储
		 * 但是这里改了equals方法，所以就可以对比姓名了
		 */
	}
}

public class Example01 {
	public static void main(String[] args) {
		HashSet h=new HashSet();
		Person p1=new Person("www",10);
		Person p2=new Person("www",15);
		Person p3=new Person("小王",10);
		Person p4=new Person("小红",20);
			
		h.add(p1);
		h.add(p2);
		h.add(p3);
		h.add(p4);
			
		for(Object obj :h) {
			System.out.println(obj);
		}
	}
}
