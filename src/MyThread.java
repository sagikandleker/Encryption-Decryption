
public class MyThread extends Thread {
	
	MyThread(String caption){

		super(caption);

	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(i+" "+getName());

		}
	}

}
