package P162_6_3;

class NoThisSoundException extends Exception{
	public NoThisSoundException(){
		super();//��������Ҫ���������ڴ��JVM��ʼ�������Ա����һ������
		System.out.println("����һ���޲εĵ����쳣�ķ�����������û���Զ����쳣��Ϣ");
		System.out.println("û���Զ����쳣��Ϣ��");
	}
	public NoThisSoundException(String message){
		super(message);//���Զ�����쳣��Ϣ����Exception��
		System.out.println("����һ���вεĵ����쳣�ķ���");
	}
}