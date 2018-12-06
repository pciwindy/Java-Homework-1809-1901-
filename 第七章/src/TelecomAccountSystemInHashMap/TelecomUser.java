package TelecomAccountSystemInHashMap;
import java.text.DateFormat;
import java.util.*;

//Running in HashMap!
public class TelecomUser {
	private String phoneNumber="10086";
	private String callTo;
	private LinkedList communicationRecords = new LinkedList();
	private Map map;
	private double feePerMin;
	
	public TelecomUser(String phoneNumber, double feePerMin) {
		this.phoneNumber = phoneNumber;
		this.feePerMin = feePerMin;
	}
	
	
	void generateCommunicateRecord() {
		String phoneNumber="10086";
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		//ת������
		DateFormat mf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
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
			//ʹ��ʱ�½�һ����ϣ��
			map=new HashMap();
			map.put("����", phoneNumber);
			//��ʱ���ʽ����洢����
			map.put("��ʼʱ��", mf.format(new Date(timeStart)));
			map.put("����ʱ��", mf.format(new Date(timeEnd)));
			map.put("����", callTo);
			//ͬ�����۸����ú�洢�������
			map.put("�Ʒ�", this.accountFee(timeStart,timeEnd));
			//���������뵽LinkedList��
			this.communicationRecords.add(map);
		}
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
		int flag = 0+(new Random().nextInt(2));
		if(flag==0) {
			//�Ƚ�HashMap�е����ݵ�������
			Iterator itRecorders = this.communicationRecords.iterator();
			while(itRecorders.hasNext()) {
				System.out.println("----------ͨ����¼�ָ���(��ȡKey����)----------");
				//������������ת���ɹ�ϣ����ʽ
				this.map=((HashMap)itRecorders.next());
				//ʹ��Set�����м�ȡ��
				Set key = this.map.keySet();
				//�Ѽ����е���
				Iterator itKey = key.iterator();
				while(itKey.hasNext()) {
					//ȡ�����ͼ���ֵ
					Object Key = itKey.next();
					Object value = this.map.get(Key);
					//���
					System.out.println(Key+":"+value);
				}
			}
		}
		
		if(flag==1) {
			Iterator itRecorders = this.communicationRecords.iterator();
			//��ÿ����¼��������
			while(itRecorders.hasNext()) {
				System.out.println("----------ͨ����¼�ָ���(ʹ��Entry)----------");
				//ת������
				this.map=((HashMap)itRecorders.next());
				//���ü��ϴ洢���еļ�ֵ��
				Set entrySet = map.entrySet();
				//������ֵ��
				Iterator it = entrySet.iterator();
				while(it.hasNext()) {
					//ȡ��������ֵ��
					Map.Entry entry = (Map.Entry)it.next();
					//ȡ������ֵ
					Object Key=entry.getKey();
					Object value=entry.getValue();
					//���
					System.out.println(Key+":"+value);
				}
			}
		}
 	}
}
