package P198_6_4;

/*
 * �ѵ�1������ʼֵ�����߳���
 * �ѵ�2��ȫ�ֱ�����ʹ��
 * �ѵ�3��ͬ��������ֹ������ӵ�����
 * �ѵ�4���������ʱ���ֵ�ִ������

	��ʼ��˼·�ǽ���ֿ���д ���Ƿ����޷���ȡ�߳�����ı���
	�������Ĵ𰸷����ǽ�mainд��һ������
	ֻ������
 */
public class Example01 implements Runnable{		//��Runnableʵ���߳�
	public int num;                          //�濪ʼ���Ǹ����ݰ�
	public static int a;                     //������Ľ��
	
	public Example01(int num) {
		this.num=num;						//������
	}
	
	public synchronized void add(int anum) {//ͬ��������ʹ���ݸ���ʱ�����ܵ�Ӱ��
		a=a+anum;							//��Ӱ�
		
	}
	public void run() {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum=sum+num+i;					//1+2+3+...+10�����
		}
		add(sum);							//��ӽ��
	}
	
	public static void  main(String[] args){
		Thread[] tl=new Thread[10];			//����������߳�
		for(int i=0;i<10;i++) {
			tl[i]=new Thread(new Example01(i*10+1));//���ù��췽�����俪ʼֵ
			tl[i].start();					//�����߳�
		}
		for(int j=0;j<10;j++) {
			try {
				tl[j].join();				//ʹ��joinʹ���������������ִ�У���ֹ����û��ִ����ͻ���ֵ���������
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		}
		System.out.println("������ "+a);
	}
}

