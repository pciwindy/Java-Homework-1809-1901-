package Upper_U4;

class Lion{
	public void eat(){
		System.out.println("Lion ate it!");
	}
}


class Monkey{
	void eat(){
		System.out.println("Monkey ate it!");
	}
}

class Pigeon{
	void eat(){
		System.out.println("Piegon ate it!");
	}
}

class Feeder{
	public String name;

	public Feeder(String name){
		this.name=name;
	}

	public void feedLion(Lion lion){
		lion.eat();
	}

	public void feedMonkey(Monkey monkey){
		monkey.eat();
	}

	public void feedPigeon(Pigeon pigeon){
		pigeon.eat();
	}
}

public class Version01{
	public static void main(String[] args){
		Feeder feeder=new Feeder("PCI_Windy");

		feeder.feedLion(new Lion());

		for(int i=0;i<5;i++){
			feeder.feedMonkey(new Monkey());
		}

		for(int j=0;j<10;j++){
			feeder.feedPigeon(new Pigeon());
		}
	}
}