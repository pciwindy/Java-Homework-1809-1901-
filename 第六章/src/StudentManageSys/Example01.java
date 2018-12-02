package StudentManageSys;

public class Example01 {
	//111 小明
	public static void main(String[] args) {
		//new new new
		String str="111 男 小明;222 女 小红;333 男 小王;";
		StringBuffer sbf=new StringBuffer();
		String a[]=str.split(";");								//分隔开字符串
		
		//原来的字符串
		System.out.println("原字符串");							
		System.out.println(str);
		
		//新的字符数组
		System.out.println("将字符串里面的数据打印到一个分割的数组里面");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		//加入字符数组
		System.out.println("加入字符数组");
		sbf.append(str);
		System.out.println(sbf.toString());
		
		//删除
		System.out.println("Delete---------------------------------------");
		sbf.delete(sbf.indexOf("111"), sbf.indexOf("111")+sbf.indexOf("明")+2);			//取开始结束符。用API删除
		System.out.println(sbf.toString());
		
		//添加
		System.out.println("Append---------------------------------------");
		sbf.append("999 小虎 女;");														//同上
		System.out.println(sbf.toString());
		
		//替换
		System.out.println("Replace--------------------------------------");
		sbf.replace(sbf.indexOf("333"), sbf.indexOf("王")+2,"111 男 小明;" );				//这个，同上
		System.out.println(sbf.toString());
		
		//查找
		System.out.println("Search---------------------------------------");
		for(int i=sbf.indexOf("111");i<=sbf.indexOf("明");i++) {
			System.out.print(sbf.charAt(i));														//单个输出查找的
		}
	}
}
