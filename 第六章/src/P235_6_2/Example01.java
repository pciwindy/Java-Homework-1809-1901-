package P235_6_2;

import java.util.*;
import java.text.*;

public class Example01 {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();									//�Ȼ�ȡ��ǰʱ��
		Date date= cal.getTime();
		DateFormat fullFormat=DateFormat.getDateInstance(DateFormat.FULL);		//�ȶ����ʱ������
		
		System.out.println(fullFormat.format(date));				//�������ǰʱ��
		cal.add(Calendar.DATE, 100);												//����һ����
		date=cal.getTime();										
		System.out.println(fullFormat.format(date));				//�����
	}
}
