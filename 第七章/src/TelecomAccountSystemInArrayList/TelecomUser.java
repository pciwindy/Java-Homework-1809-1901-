package TelecomAccountSystemInArrayList;
import java.text.DateFormat;
import java.util.*;

//Running in ArrayList!
public class TelecomUser {
	private String phoneNumber;
	private String callTo;
	private ArrayList communicationRecords = new ArrayList();
	private double feePerMin;
	
	public TelecomUser(String phoneNumber, double feePerMin) {
		this.phoneNumber = phoneNumber;
		this.feePerMin = feePerMin;
	}
	
	
	void generateCommunicateRecord() {
		//随机生成通话记录数目
		//
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++)
		{
			//随机生成第i条通话记录
			//开始时间，当前时间之前的某个随机时间
			long timeStart =System.currentTimeMillis() - new Random().nextInt(3600000);
			//结束时间开始后的十分钟内随随机的一个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			//被叫号码
			callTo = getCallToPhoneNumber();
			//插入通话记录
			this.communicationRecords.add(this.phoneNumber + ":" + this.callTo + ":" + timeStart + ":" + timeEnd);
		}
		/*Debug
		for (int i = 0; i < this.communicationRecords.size(); i++) {
			System.out.println(communicationRecords.get(i));
		}
		*/
	}
	
	private String getCallToPhoneNumber() {
		//随机生成被叫号码（后四位随机）并返回
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
		int select=1+(new Random()).nextInt(4);
		//转换日期
		DateFormat mf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
		//获取记录数目
		int arrayListSize=this.communicationRecords.size();
		//使用for循环
		if(select==1){
			for (int i = 0; i < arrayListSize; i++) {
				System.out.println("----------通话记录分割线(使用for循环)----------");
				//分割通话记录
				String [] recordFeild = ((String)this.communicationRecords.get(i)).split(":");
				System.out.println("主叫：" + recordFeild[0]);
				System.out.println("被叫：" + recordFeild[1]);
				System.out.println("通话开始时间：" + mf.format(new Date(Long.parseLong(recordFeild[2]))));
				System.out.println("通话结束时间：" + mf.format(new Date(Long.parseLong(recordFeild[3]))));
				System.out.println("计费：" + accountFee(Long.parseLong(recordFeild[2]), Long.parseLong(recordFeild[3])) + "元");
			}
		}
		
		//使用Iterator迭代器
		if(select==2) {
			Iterator it=this.communicationRecords.iterator();
			while(it.hasNext()) {
				System.out.println("----------通话记录分割线(使用Iterator迭代器)----------");
				//分割通话记录
				String [] recordFeild = ((String)it.next()).split(":");
				System.out.println("主叫：" + recordFeild[0]);
				System.out.println("被叫：" + recordFeild[1]);
				System.out.println("通话开始时间：" + mf.format(new Date(Long.parseLong(recordFeild[2]))));
				System.out.println("通话结束时间：" + mf.format(new Date(Long.parseLong(recordFeild[3]))));
				System.out.println("计费：" + accountFee(Long.parseLong(recordFeild[2]), Long.parseLong(recordFeild[3])) + "元");
			}
		}
		
		//使用ListIterator迭代器
		if(select==3) {
			ListIterator it=this.communicationRecords.listIterator(this.communicationRecords.size());
			while(it.hasPrevious()) {
				System.out.println("----------通话记录分割线(使用ListIterator迭代器)----------");
				//分割通话记录
				String [] recordFeild = ((String)it.previous()).split(":");
				System.out.println("主叫：" + recordFeild[0]);
				System.out.println("被叫：" + recordFeild[1]);
				System.out.println("通话开始时间：" + mf.format(new Date(Long.parseLong(recordFeild[2]))));
				System.out.println("通话结束时间：" + mf.format(new Date(Long.parseLong(recordFeild[3]))));
				System.out.println("计费：" + accountFee(Long.parseLong(recordFeild[2]), Long.parseLong(recordFeild[3])) + "元");
			}
		}
		
		//使用foreach循环
		if(select==4) {
			for(Object theRecorder:this.communicationRecords) {
				System.out.println("----------通话记录分割线(使用foreach循环)----------");
				//分割通话记录
				String [] recordFeild = ((String)theRecorder).split(":");
				System.out.println("主叫：" + recordFeild[0]);
				System.out.println("被叫：" + recordFeild[1]);
				System.out.println("通话开始时间：" + mf.format(new Date(Long.parseLong(recordFeild[2]))));
				System.out.println("通话结束时间：" + mf.format(new Date(Long.parseLong(recordFeild[3]))));
				System.out.println("计费：" + accountFee(Long.parseLong(recordFeild[2]), Long.parseLong(recordFeild[3])) + "元");
			}
		}
 	}
}
