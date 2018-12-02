package isLazyPeople;

public class Example01 {
	public static void main(String[] args) {
		String a = "11111 a22222 b33333 c";
		StringBuffer sf = new StringBuffer(a);
		System.out.println(sf.toString());
		// Ìí¼Ó
		sf.append("44444 d");
		System.out.println(sf.toString());
		// É¾³ý
		sf.delete(0, 7);
		System.out.println(sf.toString());
		// ÐÞ¸Ä
		sf.replace(0, 7, "55555 e");
		System.out.println(sf.toString());
		// ²éÑ¯
		for (int i = sf.indexOf("55555"); i <= sf.indexOf("e"); i++) {
			System.out.print(sf.charAt(i));
		}
	}
}
