package StudentManageSys;

public class Example01 {
	//111 С��
	public static void main(String[] args) {
		//new new new
		String str="111 �� С��;222 Ů С��;333 �� С��;";
		StringBuffer sbf=new StringBuffer();
		String a[]=str.split(";");								//�ָ����ַ���
		
		//ԭ�����ַ���
		System.out.println("ԭ�ַ���");							
		System.out.println(str);
		
		//�µ��ַ�����
		System.out.println("���ַ�����������ݴ�ӡ��һ���ָ����������");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//�����ַ�����
		System.out.println("�����ַ�����");
		sbf.append(str);
		System.out.println(sbf.toString());
		
		//ɾ��
		System.out.println("Delete---------------------------------------");
		sbf.delete(sbf.indexOf("111"), sbf.indexOf("111")+sbf.indexOf("��")+2);			//ȡ��ʼ����������APIɾ��
		System.out.println(sbf.toString());
		
		//���
		System.out.println("Append---------------------------------------");
		sbf.append("999 С�� Ů;");														//ͬ��
		System.out.println(sbf.toString());
		
		//�滻
		System.out.println("Replace--------------------------------------");
		sbf.replace(sbf.indexOf("333"), sbf.indexOf("��")+2,"111 �� С��;" );				//�����ͬ��
		System.out.println(sbf.toString());
		
		//����
		System.out.println("Search---------------------------------------");
		for(int i=sbf.indexOf("111");i<=sbf.indexOf("��");i++) {
			System.out.print(sbf.charAt(i));														//����������ҵ�
		}
	}
}
