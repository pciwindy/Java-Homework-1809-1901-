package HashMapTest;

import java.util.*;


public class Example01 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "Tom");
		map.put(2, "Lucy");
		map.put(3, "Richard");
		
		Set keySet = map.keySet();
		Iterator it =keySet.iterator();
		while(it.hasNext()) {
			Object key = it.next();
			System.out.println(key);
			map.remove(key);
		}
	}
}
