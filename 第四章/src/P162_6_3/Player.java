package P162_6_3;

class Player {
	public void play(int index)throws NoThisSoundException{
		if(index==11) {//�����޲ε���
			throw new NoThisSoundException();//�����޲�
		}
		else if(index>11) {//�����вε���
			throw new NoThisSoundException("��������������ڣ�");//��������Ϣ�׳�
		}
		else {
			System.out.println("Playing.......");
		}
	}
}
