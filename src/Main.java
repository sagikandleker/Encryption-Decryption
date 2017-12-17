import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static String Path = "C:\\Users\\sagik\\git\\Encryption_and_decryption\\";
	public static String ReadFrom_Path = Path+"Read From files\\";
	public static String Enc_Path = Path+"Encryption files\\";
	public static String Dec_Path = Path+"Decryption files\\";

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		String input;
		System.out.println("Hey!\nTo do Encryption to file and Decoding it with they same Key write 1\nTo do search Keys of 100 files write 2\n");
		input = sc.nextLine();
		if(input.equalsIgnoreCase("1")) {

			System.out.println("Read text from\n("+ReadFrom_Path+"ReadFrom.txt)");
			Write_2_File.Encoded_File(Algorithm.Encryption(Read_From_File.String_File(ReadFrom_Path+"ReadFrom.txt"),Algorithm.KEY));
			Write_2_File.Decoded_File(Algorithm.Decryption(Read_From_File.String_File(Enc_Path+"ReadFrom - Encoded.txt"),Algorithm.KEY));
		}
		if(input.equalsIgnoreCase("2")) {
			Hack_Keys.getFiles();
		}
		sc.close();
	}
}
