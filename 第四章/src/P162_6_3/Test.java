package P162_6_3;

public class Test {
	public static void main(String[] args) {
		Player player=new Player();
		//�����޲���û���Զ����쳣
		try {
			player.play(11);
		}
		catch(NoThisSoundException e) {
			System.out.println("�������쳣��"+e.getMessage());
			System.out.println("-------------------------------------------");
		}
		//�����в����Զ����쳣
		try {
			player.play(12);
		}
		catch(NoThisSoundException e) {
			System.out.println("�������쳣��"+e.getMessage());
			System.out.println("-------------------------------------------");
		}
	}
}
