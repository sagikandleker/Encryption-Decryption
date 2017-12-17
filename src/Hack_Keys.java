import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Hack_Keys {

	public static String Bonus_Path = Main.Path+"Bonus\\";
	public static String Bonus_File_Write = Bonus_Path+"Bonus_Key_List.csv";

	/**
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void getFiles() throws IOException, ParseException {

		File folder = new File(Bonus_Path);
		String[] files_Names = folder.list();
		ArrayList<String> Keys_List = new ArrayList<String>();
		
		int counter = 0;
		for(int i = 0; i < files_Names.length; i++) {
			if(files_Names[i].startsWith("enc") && files_Names[i].endsWith(".txt")) {
				Decoding_Keys(Bonus_Path,files_Names[i], Keys_List);
				counter++;
			}	
		}
		Write_2_CSV.Write(Keys_List);
		System.out.println(counter +" Files founded\nThe Keys to the files are in the file - "+Bonus_File_Write);
	}

	/**
	 * 
	 * @param Folder@
	 * @param File
	 * @throws IOException
	 */
	public static void Decoding_Keys(String Folder, String File, ArrayList<String> Keys_List) throws IOException {

		String encoded_data = Read_From_File.Integer_File(Folder+File);
		String decoded_data;

		//Thread t1=new Thread(DATA);
		//Thread t2=new Thread(DATA);

		//t1.start();
		//t2.start();

		for (int i = 75863833; i < 99999999; i++) {
			decoded_data = Algorithm.Decryption(encoded_data, i);
			if((decoded_data.charAt(0) > 1487 && decoded_data.charAt(0) < 1515) &&
					(decoded_data.charAt(1) > 1487 && decoded_data.charAt(1) < 1515) &&
					(decoded_data.charAt(2) > 1487 && decoded_data.charAt(2) < 1515)) {

				System.out.println("File Name: "+File+"\nKey: "+i);
				Keys_List.add(File);
				Keys_List.add(""+i);
				break;
			}
		}
	}
}
