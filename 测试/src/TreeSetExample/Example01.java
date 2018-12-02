package TreeSetExample;

import java.util.Iterator;
import java.util.TreeSet;

public class Example01 {
	public static void main(String[] args) {
		TreeSet ts =new TreeSet();
		ts.add("b");
		ts.add("a");
		ts.add("c");
		
		Iterator it = ts.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
