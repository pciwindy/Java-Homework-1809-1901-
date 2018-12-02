package TelecomAccountSystemInHashMap;

//Running in HashMap!
public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser用法：电话号码，费用
		TelecomUser telecomUser = new TelecomUser("10010",0.4);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}

/*
 * 使用HashMap解决存储问题
 * key-value配对
 * put方法（key，value）
 * 需要将数据提前处理好后进行记录
 * HashMap使用HashCode进行判断数值重复
 * 
 * 处理数据取出
 * 第一个是先将一条记录里所有的键取出放入一个集合keySet
 * 通过这个集合的迭代取出键的值
 * 
 * 第二个也是先将一条记录里的所有键值对取出放入entrySet
 * 使用enteySet迭代器迭代出每一条键值对，之后取出键和键值
 */
