package P198_6_1;

public class MyThread extends Thread {
	public String aName;                                 //�½�һ���ַ�����ʾ������
	public MyThread(String Name) {
		aName=Name;                          //���������
	}
	public void run() {
		while(true) {
			System.out.println(aName+" is running");
		}
	}
}
