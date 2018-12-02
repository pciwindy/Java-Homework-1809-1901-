package P162_6_3;

public class Test {
	public static void main(String[] args) {
		Player player=new Player();
		//测试无参且没有自定义异常
		try {
			player.play(11);
		}
		catch(NoThisSoundException e) {
			System.out.println("这里有异常！"+e.getMessage());
			System.out.println("-------------------------------------------");
		}
		//测试有参且自定义异常
		try {
			player.play(12);
		}
		catch(NoThisSoundException e) {
			System.out.println("这里有异常！"+e.getMessage());
			System.out.println("-------------------------------------------");
		}
	}
}
