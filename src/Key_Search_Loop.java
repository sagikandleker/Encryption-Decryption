import java.io.IOException;

public class Key_Search_Loop extends Thread {
	String Path = "C:\\Users\\sagik\\git\\Encryption_and_decryption\\Encryption files\\enc_0_msg.txt";
	String DecData;
	
	Key_Search_Loop (String DATA)
	{
		super(DATA);
	}

	public void run() {

		for (int i = 75860000; i < 99999999; i++) {
			DecData = Example.Decryption2(DATA, i);
			//System.out.println(DecData);
			System.out.println("KEYS = "+i);
			if((DecData.charAt(0) > 1487 && DecData.charAt(0) < 1515) &&
					(DecData.charAt(1) > 1487 && DecData.charAt(1) < 1515) &&
					(DecData.charAt(2) > 1487 && DecData.charAt(2) < 1515))
			{
				System.out.println("Key: "+i);
				break;
			}

		}
	}
}
