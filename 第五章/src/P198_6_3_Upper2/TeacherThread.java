package P198_6_3_Upper2;

public class TeacherThread implements Runnable{
	private int N=80;
	public void run() {
		while(true) {
			faBiJi();               //�����˷��ʼǺ���
			if(N<=0) {
				break;				//ѭ��emmmmҪ�˳�
			}
		}
	}
	
	private synchronized void faBiJi(){
		if(N>0){
			try {                   //��˯����Ľ�������
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName()+"���ڷַ���"+N+"����ҵ");
					N--;
				} 
			catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				}
		}
	}
}


