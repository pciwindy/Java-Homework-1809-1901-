package P235_6_1;

public class Example01 {
	public static void main(String[] args) {
		String str="HelloWorld";						//�����ַ���
		StringBuffer sbf=new StringBuffer();			//����StringBuffer
		char[] a=str.toCharArray();						//�����ַ�����
		for(int i=str.length()-1;i>=0;i--) {			//ȡ���ȿ�ʼѭ��
			if(a[i]>='a'&&a[i]<='z') {					//�ж�Сд			
				sbf.append(str.valueOf(a[i]).toUpperCase());	//��str����ȡ����ת����Сд�ŵ�sbf����
			}												
			if(a[i]>='A'&&a[i]<='Z') {							//�жϴ�д
				sbf.append(str.valueOf(a[i]).toLowerCase());	//��str����ȡ����ת����Сд�ŵ�sbf����
			}
		}
		System.out.println(sbf.toString());						//ת�����ַ������
	}
}

