package P280_6_3;

import java.util.*;

public class Example01 {
	public static void main(String[] args) {
		//����Ҫ���ܰ��ݵ��Ƕ������ͣ�������������Java�ﲻ���ڶ���
		TreeMap<String, String> tm=new TreeMap<String, String>();
		//��������
		tm.put("1", "Lucy");
		tm.put("5", "Amanda");
		tm.put("2", "John");
		tm.put("4", "Aimee");
		tm.put("3", "Smith");
		
		//ʹ�ü����ϵķ�ʽ����ֵ��ȡ��
		Set<String> keySet=tm.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			Object value = tm.get(key);
			System.out.println(key+":"+value);
		}
		
		//ʹ�ü�ֵ�Եķ�ʽȡ������
		/*
		Set EntrySet=tm.entrySet();
		Iterator it = EntrySet.iterator();
		while(it.hasNext()) {
			Map.Entry entry=(Map.Entry)(it.next());
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		*/
		
	}
}
