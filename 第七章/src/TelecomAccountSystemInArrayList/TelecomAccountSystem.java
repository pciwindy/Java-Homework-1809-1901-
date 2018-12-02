package TelecomAccountSystemInArrayList;

//Running in ArrayList!
public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser用法：电话号码，费用
		TelecomUser telecomUser = new TelecomUser("10010",0.4);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}



/*
 * ArrayList、LinkedList的不同之处
 	ArrayList为可变数组类型
 	LinkedList为双向可变链表类型
 	在进行顺序访问和非尾部添加和删除操作时链表的时间复杂度更低（链表使用节点）
 	在进行随机访问和尾部添加和删除时数组的时间复杂度占优（数组为一段的连续空间）
 	

   *  在模拟电信计费系统中，因为仅使用了add命令而非insert命令，所以二者在使用上无过大差距
   * 而在使用迭代器中，因为迭代器为一个个迭代，所以在时间上也是没有过大差距的
*/
