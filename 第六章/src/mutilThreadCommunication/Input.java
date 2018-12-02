package mutilThreadCommunication;

//ÓÃ»§µÇÂ½
public class Input implements Runnable {
	private Storage st;
	private int num;
	
	Input(Storage st){
		this.st=st;
	}
	
	public void run() {
		while(true) {
			st.put(num++);
		}
	}
}
