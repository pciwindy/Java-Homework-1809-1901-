package sameKeyInHashMap;

import java.util.*;

/*
 * 同样的键，不同的值问题 
 * 在Java的HashMap代码中，对于同键不同值的问题
 * 处理的方法是通过新值取代旧值来实现的
 * 下面这段代码的执行可以解释这个问题
*/

public class Example01 {
	public static void main(String[] args) {
		HashMap<Integer,String> hm =  new HashMap<Integer, String>();
		//下面这两行代码在同一个位置中先后插入了不同的值
		hm.put(1, "www");
		hm.put(1, "aaa");
		
		Set entrySet=hm.entrySet();
		Iterator it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			//下面这行代码表示了取出来了值
			System.out.println(entry.getKey()+":"+entry.getValue());
			//1:aaa
		}
	}
}
