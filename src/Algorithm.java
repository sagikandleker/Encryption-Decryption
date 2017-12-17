import java.util.Random;

public class Algorithm {

	public static int KEY = 22334455;

	/**
	 * Encryption with Encryption char Algorithm.
	 * @param text
	 * @param key
	 * @return
	 */
	public static String Encryption(String msg, int key){
		String ans = "";
		Random rand = new Random(key);

		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			int s = c;
			int rd = rand.nextInt()%(256*256);
			int s2 = s^rd;
			char c2 = (char)(s2);
			ans += c2;
		}
		return ans;

	}

	/**
	 * Decryption with Decryption int Algorithm.
	 * @param text
	 * @param key
	 * @return
	 */
	public static String Decryption(String msg, int key){
		String ans = "";
		Random rand = new Random(key);

		String[] array = msg.split(" ");

		for (int i = 0; i < array.length-1; i++) {
			int s = Integer.parseInt(array[i]);
			int rd = rand.nextInt()%(256*256);
			int s2 = s^rd;
			char c2 = (char)(s2);
			ans += c2;	
		}
		return ans;	
	}

}
