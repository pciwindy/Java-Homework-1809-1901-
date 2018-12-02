package P235_6_1;

public class Example01 {
	public static void main(String[] args) {
		String str="HelloWorld";						//定义字符串
		StringBuffer sbf=new StringBuffer();			//定义StringBuffer
		char[] a=str.toCharArray();						//定义字符数组
		for(int i=str.length()-1;i>=0;i--) {			//取长度开始循环
			if(a[i]>='a'&&a[i]<='z') {					//判断小写			
				sbf.append(str.valueOf(a[i]).toUpperCase());	//从str里面取出来转换大小写放到sbf里面
			}												
			if(a[i]>='A'&&a[i]<='Z') {							//判断大写
				sbf.append(str.valueOf(a[i]).toLowerCase());	//从str里面取出来转换大小写放到sbf里面
			}
		}
		System.out.println(sbf.toString());						//转换成字符串输出
	}
}

