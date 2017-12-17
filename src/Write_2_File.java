import java.io.FileWriter;
import java.io.IOException;

public class Write_2_File {

	/**
	 * Write Decoded message to file.
	 * @param msg_enc
	 * @throws IOException
	 */
	public static void Decoded_File(String msg) throws IOException {

		FileWriter fw = new FileWriter(Main.Dec_Path+"ReadFrom - Decoded.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg.length(); i++) {
			stringBuilder.append(msg.charAt(i));
		}

		fw.write(stringBuilder.toString());
		fw.close();
		System.out.println("Decoded file was written with the key: "+Algorithm.KEY+"\n("+Main.Dec_Path+"ReadFrom - Decoded.txt)");
	}

	/**
	 * Write Encoded message to file.
	 * @param msg
	 * @throws IOException
	 */
	public static void Encoded_File(String msg) throws IOException {

		FileWriter fw = new FileWriter(Main.Enc_Path+"ReadFrom - Encoded.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg.length(); i++) {
			stringBuilder.append((int)msg.charAt(i)+" ");
		}
		fw.write(stringBuilder.toString());
		fw.close();
		System.out.println("Encoded file was written with the key: "+Algorithm.KEY+"\n("+Main.Enc_Path+"ReadFrom - Encoded.txt)");
	}

	
	
}
