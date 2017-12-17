import java.io.IOException;

public class Thr extends Thread{

	final int keyFrom, keyTo;
	//final String lineToSearch;
	final String encoded_data;
	int keyFounded = -1;
	final String path;

	public Thr(int keyFrom, int keyTo, String path) throws IOException {
		this.keyFrom = keyFrom;
		this.keyTo = keyTo;
		this.path = path;
		//get full string of file
		this.encoded_data = Read_From_File.Integer_File3(path);
		//lineTo
	}

	@Override
	public void run() {
		String decoded_data;
		int count = 0;
		for (int key = keyFrom; key < keyTo; key++) {
			decoded_data = Algorithm.Decryption(encoded_data, key);
			try {
				if((decoded_data.charAt(0) == 1495 && decoded_data.charAt(1) == 1497 && decoded_data.charAt(2) == 1514)) {
					System.out.println("File Name: "+path+"\nKey: "+key);
					keyFounded = key;
					break;
				}
			} catch(Exception e) {e.printStackTrace();
			System.out.println("ERROR: " + decoded_data);
			}
			count++;
			//if(count % 1_000_000 == 0) {
				//System.out.println(Thread.currentThread().getName() + " Key at: " + key);
			//}
		}
	}
}