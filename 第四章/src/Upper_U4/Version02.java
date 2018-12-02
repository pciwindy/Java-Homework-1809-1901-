package Upper_U4;

interface Animal1{
	void eat();
}

class Lion1 implements Animal1{
	public void eat(){
		System.out.println("Lion ate it!");
	}
}

class Monkey1 implements Animal1{
	public void eat(){
		System.out.println("Monkey ate it!");
	}
}

class Pigeon1 implements Animal1{
	public void eat(){
		System.out.println("Piegon ate it!");
	}
}

class Feeder1{
	public String name;//这玩意干啥用的？

	public Feeder1(String name){
		this.name=name;
	}

	public void feedAnimal1(Animal1 animal){
		animal.eat();
	}
}

public class Version02{
	public static void main(String[] args){
		Feeder1 feeder=new Feeder1("PCI_Windy");

		feeder.feedAnimal1(new Lion1());

		for(int i=0;i<5;i++){
			feeder.feedAnimal1(new Monkey1());
		}

		for(int j=0;j<10;j++){
			feeder.feedAnimal1(new Pigeon1());
		}
	}
}