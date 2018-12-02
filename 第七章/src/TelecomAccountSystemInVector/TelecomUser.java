package TelecomAccountSystemInVector;
import java.text.DateFormat;
import java.util.*;

//Running in Vector!
public class TelecomUser {
	private String phoneNumber;
	private String callTo;
	private Vector communicationRecords = new Vector();
	private double feePerMin;
	public TelecomUser(String phoneNumber, double feePerMin) {
		this.phoneNumber = phoneNumber;
		this.feePerMin = feePerMin;
	}
	
	
	void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		//
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++)
		{
			//������ɵ�i��ͨ����¼
			//��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart =System.currentTimeMillis() - new Random().nextInt(3600000);
			//����ʱ�俪ʼ���ʮ�������������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//���к���
			callTo = getCallToPhoneNumber();
			//����ͨ����¼
			this.communicationRecords.add(this.phoneNumber + ":" + this.callTo + ":" + timeStart + ":" + timeEnd);
		}
		/*Debug
		for (int i = 0; i < this.communicationRecords.size(); i++) {
			System.out.println(communicationRecords.get(i));
		}
		*/
	}
	
	private String getCallToPhoneNumber() {
		//������ɱ��к��루����λ�����������
		return "1380372" + String.valueOf(0+new Random().nextInt(10))
		 + String.valueOf(0+new Random().nextInt(10))
		 + String.valueOf(0+new Random().nextInt(10))
		 + String.valueOf(0+new Random().nextInt(10));
		 
	}
	
	public String accountFee(long timeStart,long timeEnd) {
		int min = Math.round((timeEnd - timeStart)/60000);
		double feeAll = feePerMin * min;
		return String.format("%.2f", feeAll);
		
	}
	
	void printDetails() {
		//ת������
		DateFormat mf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
		//ʹ��Vector
		Enumeration e=this.communicationRecords.elements();
		while(e.hasMoreElements()) {
			System.out.println("----------ͨ����¼�ָ���(ʹ��Vector)----------");
			//�ָ�ͨ����¼
			String [] recordFeild = ((String)e.nextElement()).split(":");
			System.out.println("���У�" + recordFeild[0]);
			System.out.println("���У�" + recordFeild[1]);
			System.out.println("ͨ����ʼʱ�䣺" + mf.format(new Date(Long.parseLong(recordFeild[2]))));
			System.out.println("ͨ������ʱ�䣺" + mf.format(new Date(Long.parseLong(recordFeild[3]))));
			System.out.println("�Ʒѣ�" + accountFee(Long.parseLong(recordFeild[2]), Long.parseLong(recordFeild[3])) + "Ԫ");
		}
	}
}
