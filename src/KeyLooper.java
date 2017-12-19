import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the main looper of decoding encoded messages.
 */
public class KeyLooper extends Thread{
	// When the flag change to true all the Threads stop the searching to the specific file.
	public static boolean flag = false;
	final int keyFrom, keyTo;
	final String encoded_data;
	public int keyFounded = -1;
	File file;
	ArrayList<String> Key_List;

	/**
	 * 
	 * @param keyFrom Key index to run from.
	 * @param keyTo Key index to end.
	 * @param file Which file to decode. (Encoded file)
	 * @param Key_List Collection of keys which to add the resulted key.
	 * @throws IOException
	 */
	public KeyLooper(int keyFrom, int keyTo, File file, ArrayList<String> Key_List) throws IOException {
		this.keyFrom = keyFrom;
		this.keyTo = keyTo;
		this.file = file;
		this.Key_List = Key_List;
		this.encoded_data = Read_From_File.Integer_File(file.getAbsolutePath());

	}

	/**
	 * Main run.
	 */
	@Override
	public void run() {
		//
		flag = false;
		String decoded_data;
		for (int key = keyFrom; key < keyTo; key++) {
			if(flag == true) {
				break;
			}
			else {
				//Get first 3 chars from encoded file.
				decoded_data = Algorithm.Decryption(encoded_data, key);
				//Check if is 'חית' .
				if((decoded_data.charAt(0) == 1495 && decoded_data.charAt(1) == 1497 && decoded_data.charAt(2) == 1514)) {
					flag = true;
					System.out.println("Thread: " + Thread.currentThread().getName() +"\nFile Name: "+file.getName()+"\nKey: "+key);
					keyFounded = key;
					//Add to list of founded keys.
					Key_List.add(file.getName());
					Key_List.add(""+key);

					//exit loop.
					break;
				}
			}
		}
		//Inform the user .
		//System.out.println(Thread.currentThread().getName() + " IS STOPPING");
		//Thread.yield();
	}
}