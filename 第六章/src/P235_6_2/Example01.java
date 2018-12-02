package P235_6_2;

import java.util.*;
import java.text.*;

public class Example01 {
	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();									//先获取当前时间
		Date date= cal.getTime();
		DateFormat fullFormat=DateFormat.getDateInstance(DateFormat.FULL);		//先定义好时间类型
		
		System.out.println(fullFormat.format(date));				//先输出当前时间
		cal.add(Calendar.DATE, 100);												//加上一百天
		date=cal.getTime();										
		System.out.println(fullFormat.format(date));				//再输出
	}
}
