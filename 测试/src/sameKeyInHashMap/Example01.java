package sameKeyInHashMap;

import java.util.*;

/*
 * ͬ���ļ�����ͬ��ֵ���� 
 * ��Java��HashMap�����У�����ͬ����ֵͬ������
 * ����ķ�����ͨ����ֵȡ����ֵ��ʵ�ֵ�
 * ������δ����ִ�п��Խ����������
*/

public class Example01 {
	public static void main(String[] args) {
		HashMap<Integer,String> hm =  new HashMap<Integer, String>();
		//���������д�����ͬһ��λ�����Ⱥ�����˲�ͬ��ֵ
		hm.put(1, "www");
		hm.put(1, "aaa");
		
		Set entrySet=hm.entrySet();
		Iterator it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			//�������д����ʾ��ȡ������ֵ
			System.out.println(entry.getKey()+":"+entry.getValue());
			//1:aaa
		}
	}
}
