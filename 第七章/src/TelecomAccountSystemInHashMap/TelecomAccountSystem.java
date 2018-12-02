package TelecomAccountSystemInHashMap;

//Running in HashMap!
public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser�÷����绰���룬����
		TelecomUser telecomUser = new TelecomUser("10010",0.4);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}

/*
 * ʹ��HashMap����洢����
 * key-value���
 * put������key��value��
 * ��Ҫ��������ǰ����ú���м�¼
 * HashMapʹ��HashCode�����ж���ֵ�ظ�
 * 
 * ��������ȡ��
 * ��һ�����Ƚ�һ����¼�����еļ�ȡ������һ������keySet
 * ͨ��������ϵĵ���ȡ������ֵ
 * 
 * �ڶ���Ҳ���Ƚ�һ����¼������м�ֵ��ȡ������entrySet
 * ʹ��enteySet������������ÿһ����ֵ�ԣ�֮��ȡ�����ͼ�ֵ
 */
