package TelecomAccountSystemInArrayList;

//Running in ArrayList!
public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser�÷����绰���룬����
		TelecomUser telecomUser = new TelecomUser("10010",0.4);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}



/*
 * ArrayList��LinkedList�Ĳ�֮ͬ��
 	ArrayListΪ�ɱ���������
 	LinkedListΪ˫��ɱ���������
 	�ڽ���˳����ʺͷ�β����Ӻ�ɾ������ʱ�����ʱ�临�Ӷȸ��ͣ�����ʹ�ýڵ㣩
 	�ڽ���������ʺ�β����Ӻ�ɾ��ʱ�����ʱ�临�Ӷ�ռ�ţ�����Ϊһ�ε������ռ䣩
 	

   *  ��ģ����żƷ�ϵͳ�У���Ϊ��ʹ����add�������insert������Զ�����ʹ�����޹�����
   * ����ʹ�õ������У���Ϊ������Ϊһ����������������ʱ����Ҳ��û�й������
*/
