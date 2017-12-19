import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Write functions.
 *
 */
public class Writer {
	/**
	 * Write Decoded message to file.
	 * @param msg_enc
	 * @throws IOException
	 */
	public static void Decoded_File(String msg) throws IOException {

		FileWriter fw = new FileWriter(Main.DEC_PATH+"ReadFrom - Decoded.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg.length(); i++) {
			stringBuilder.append(msg.charAt(i));
		}

		fw.write(stringBuilder.toString());
		fw.close();
		System.out.println("Decoded file was written with the key: "+Algorithm.KEY+"\n("+Main.DEC_PATH+"ReadFrom - Decoded.txt)");
	}

	/**
	 * Write Encoded message to file.
	 * @param msg
	 * @throws IOException
	 */
	public static void Encoded_File(String msg) throws IOException {

		FileWriter fw = new FileWriter(Main.ENC_PATH+"ReadFrom - Encoded.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg.length(); i++) {
			stringBuilder.append((int)msg.charAt(i)+" ");
		}
		fw.write(stringBuilder.toString());
		fw.close();
		System.out.println("Encoded file was written with the key: "+Algorithm.KEY+"\n("+Main.ENC_PATH+"ReadFrom - Encoded.txt)");
	}


	/**
	 * Write Headers to the CSV file.
	 * @throws IOException
	 */
	public static void Write_Headers() throws IOException {
		String[] titles_list = {"File name","Key"};
		FileWriter file = new FileWriter(Hack_Keys.Bonus_File_Write);

		for (int i = 0; i <= titles_list.length-1; i++) {
			file.write(titles_list[i]+",");
		}
		file.close();
	}

	/**
	 * Write 2 the CSV file all the Keys with file names.
	 * @param Bonus_Key_List ArrayList with files names and keys.
	 * @throws IOException
	 */
	public static void Write_2_CSV(ArrayList<String> Bonus_Key_List) throws IOException {
		Write_Headers();

		FileWriter fw = new FileWriter(Hack_Keys.Bonus_File_Write, true);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		int counter = 0;
		for (int i = 0; i < Bonus_Key_List.size(); i++) {	
			stringBuilder.append((Bonus_Key_List.get(i)));
			stringBuilder.append(",");

			if(counter%2 != 0) {
				stringBuilder.append("\n");
			}
			counter++;
		}

		fw.write(stringBuilder.toString());
		fw.close();
	}

}
