package P162_6_2;

interface Sharp{
	double area(double length);
}

class Square implements Sharp{
	public double mianji;
	public double area(double length){
		return length*length;
	}
}

class Circle implements Sharp{
	public double mianji;
	public double area(double length){
		return length*length*3.14;
	}
}

public class Test02{
	public static void main(String[] args){
		Sharp square=new Square();
		Sharp circle=new Circle();
		System.out.println("�����������:"+square.area(2));
		System.out.println("Բ�������:"+circle.area(3));
	}
}
