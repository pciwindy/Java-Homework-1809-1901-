package P235_6_3;

import java.util.Random;

public class Example01 {
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			System.out.println(20+(new Random()).nextInt(31));
		}
	}
}
