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
		//随机生成通话记录数目
		int recordNum = new Random().nextInt(10);
		//转换日期
		DateFormat mf = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
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
			//使用时新建一个哈希表
			map=new HashMap();
			map.put("主叫", phoneNumber);
			//将时间格式化后存储进入
			map.put("开始时间", mf.format(new Date(timeStart)));
			map.put("结束时间", mf.format(new Date(timeEnd)));
			map.put("被叫", callTo);
			//同样将价格计算好后存储进入表中
			map.put("计费", this.accountFee(timeStart,timeEnd));
			//把这个表插入到LinkedList中
			this.communicationRecords.add(map);
		}
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
		int flag = 0+(new Random().nextInt(2));
		if(flag==0) {
			//先将HashMap中的数据迭代出来
			Iterator itRecorders = this.communicationRecords.iterator();
			while(itRecorders.hasNext()) {
				System.out.println("----------通话记录分割线(先取Key集合)----------");
				//将迭代的数据转换成哈希表形式
				this.map=((HashMap)itRecorders.next());
				//使用Set将所有键取出
				Set key = this.map.keySet();
				//把键进行迭代
				Iterator itKey = key.iterator();
				while(itKey.hasNext()) {
					//取出键和键的值
					Object Key = itKey.next();
					Object value = this.map.get(Key);
					//输出
					System.out.println(Key+":"+value);
				}
			}
		}
		
		if(flag==1) {
			Iterator itRecorders = this.communicationRecords.iterator();
			//将每条记录迭代出来
			while(itRecorders.hasNext()) {
				System.out.println("----------通话记录分割线(使用Entry)----------");
				//转换类型
				this.map=((HashMap)itRecorders.next());
				//设置集合存储所有的键值对
				Set entrySet = map.entrySet();
				//迭代键值对
				Iterator it = entrySet.iterator();
				while(it.hasNext()) {
					//取出单个键值对
					Map.Entry entry = (Map.Entry)it.next();
					//取出键和值
					Object Key=entry.getKey();
					Object value=entry.getValue();
					//输出
					System.out.println(Key+":"+value);
				}
			}
		}
 	}
}
