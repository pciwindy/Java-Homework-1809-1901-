package P280_6_2;

import java.util.HashSet;

class Person{
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	//��дtoString���������Ըı������ʽ
	public String toString() {
		return "����Ϊ"+name+",����Ϊ"+age;
	}
	
	//���ع�ϣֵ
	public int hashCode() {
		return name.hashCode();
	}
	
	//���equals����ͨ��������д��������ж����ڲ�����
	public boolean equals(Object obj) {
		//�˴��Ƚϵ��ǵ�ַ����������ַ��ͬ��϶���ͬһ����
		if(this==obj) {
			return true;
		}
		//��������������Person��ֱ��false
		if (!(obj instanceof Person)) {
			return false;
		}
		//���������ǿ��ת����ΪPerson�����ڼ���ڲ�����
		Person p=(Person)obj;
		//���������ļ��ֵ
		//���˲��룺��ʱʹ���˵�������֮ǰ������ȡ������һһ�Աȣ���֪��ԭ�����Ƿ����������еġ�
		boolean b=this.name.equals(p.name);
		return b;
		
		/*
		 * ���жϹ�ϣֵ�����������������ȣ��ͻ����equals��������ֱ�Ӵ洢
		 * equals�Ѿ�����д���������ж�����ʱ��ȣ�����true
		 * �����������ʱ����Ϊtrue�����Ͳ���洢
		 * ԭ�Ȼᱻ�洢��ԭ��Ϊ���߹�ϣֵ��Ƚ���equals�����ڴ��ַ��ͬ���Ա��洢
		 * �����������equals���������ԾͿ��ԶԱ�������
		 */
	}
}

public class Example01 {
	public static void main(String[] args) {
		HashSet h=new HashSet();
		Person p1=new Person("www",10);
		Person p2=new Person("www",15);
		Person p3=new Person("С��",10);
		Person p4=new Person("С��",20);
			
		h.add(p1);
		h.add(p2);
		h.add(p3);
		h.add(p4);
			
		for(Object obj :h) {
			System.out.println(obj);
		}
	}
}
