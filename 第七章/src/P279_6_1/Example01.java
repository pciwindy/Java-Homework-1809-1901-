package P279_6_1;

import java.util.*;

public class Example01 {
	public static void main(String[] args) {
		Test t = new Test();
		t.create();
		t.out();
	}
	
}


class Test{
	private ArrayList a= new ArrayList();
	private int how = 1+(new Random()).nextInt(4);
	
	//产生随机元素
	void create() {
		for (int i = 0; i < 10; i++) {
			int how = 1+(new Random()).nextInt(4);
			if(how==1) {
				a.add(1+(new Random()).nextInt(100));
			}
			if(how==2) {
				a.add(2.27f);
			}
			if(how==3) {
				a.add(3.47);
			}
			if(how==4) {
				a.add("This is a String");
			}
		}
	}
	
	//迭代器正序迭代
	void out() {
		Iterator it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
