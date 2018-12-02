package whichIsEqual;

/*
 * from: https://www.cnblogs.com/dolphin0520/p/3592500.html
 * 1������==����������ڻ����������͵ı�������ֱ�ӱȽ���洢�� ��ֵ���Ƿ���ȣ�
������������������������͵ı�������Ƚϵ�����ָ��Ķ���ĵ�ַ

����2������equals������ע�⣺equals�������������ڻ����������͵ı���
�����������û�ж�equals����������д����Ƚϵ����������͵ı�����ָ��Ķ���ĵ�ַ��
������������String��Date�����equals������������д�Ļ����Ƚϵ�����ָ��Ķ�������ݡ�
 */

public class Example01 {
	public static void main(String[] args) {
		A A=new A();
		A B=new A();
		
		//equals���������Ƚ��ַ����Լ����������Ƿ���ȣ����޷��Ƚϻ����������ͣ�������int,double
		System.out.println("������������int�ĶԱ�----------------------------------------------------");
		int a1=17;
		int b1=17;
		System.out.println(a1==b1);
		System.out.println();
		
		System.out.println("������ıȽ�-------------------------------------------------------------");
		//��ַ�ռ䲻ͬ��==�϶�false
		System.out.println("ֱ��ʹ��==");
		System.out.println(A==B);
		System.out.println("ʹ��equals����");
		//�������������ͬһ��ַ���ã�equals��Ϊ�档��ͨ�����Ϊfalse�������Ҫ�ж����ݣ���Ҫ��д��
		System.out.println(A.equals(B));
		System.out.println();
		
		//�������1
		System.out.println("�������1-���������ַ�������ıȽ�------------------------------------------");
		String s1="helloworld";
		String s2="helloworld";
		System.out.println("ֱ��ʹ��==");
		//�ַ����洢�ڳ�������
		System.out.println(s1==s2);
		System.out.println("ʹ��equals����");
		//String��д��equals����
		System.out.println(s1.equals(s2));
		System.out.println();
		
		//�������2
		System.out.println("�������2-�����ַ�������ıȽ�----------------------------------------------");
		String s3=new String("phpbest!");
		String s4=new String("phpbest!");
		System.out.println("ֱ��ʹ��==");
		//�µ��ڴ�����Ѿ����֣��϶�ֱ����false
		System.out.println(s3==s4);
		System.out.println("ʹ��equals����");
		System.out.println(s3.equals(s4));
		System.out.println();
		
		System.out.println("�������3-��װ����������Integer�ĶԱ�(-128~127)-----------------------------");
		//���ڰ�װ��Integer��˵������ֵΪ-128~127ʱ��ʹ�õ��ǻ�����������int
		Integer a2=78;
		Integer b2=78;
		System.out.println("ֱ��ʹ��==");
		System.out.println(a2==b2);
		System.out.println("ʹ��equals����");
		System.out.println(a2.equals(b2));
		System.out.println();
		
		System.out.println("�������4-��װ����������Integer�ĶԱ�(��-128~127)----------------------------");
		//���ڰ�װ��Integer��˵������ֵ��-128~127ʱ�������ظ�ʹ��
		Integer a3=129;
		Integer b3=129;
		System.out.println("ֱ��ʹ��==");
		System.out.println(a3==b3);
		System.out.println("ʹ��equals����");
		System.out.println(a3.equals(b3));
		System.out.println();
		
		//���д���˵����int���װ��ȴ�Сʱ��װ����Զ�����
		//System.out.println(a3==129);
	}
}
