package P280_6_3;

import java.util.*;

public class Example01 {
	public static void main(String[] args) {
		//泛形要求能包容的是对象类型，而基本类型在Java里不属于对象
		TreeMap<String, String> tm=new TreeMap<String, String>();
		//放入数据
		tm.put("1", "Lucy");
		tm.put("5", "Amanda");
		tm.put("2", "John");
		tm.put("4", "Aimee");
		tm.put("3", "Smith");
		
		//使用键集合的方式进行值的取出
		Set<String> keySet=tm.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			Object value = tm.get(key);
			System.out.println(key+":"+value);
		}
		
		//使用键值对的方式取出数据
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
