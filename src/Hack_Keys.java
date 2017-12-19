import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Bonus part.
 *
 */
public class Hack_Keys {

	public static String Bonus_Path = Main.PATH+"Bonus/";
	public static String Bonus_File_Write = Bonus_Path+"Bonus_Key_List.csv";

	/**
	 * Decode all files in bonus folder.
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	public static void decodeFiles() throws IOException, ParseException, InterruptedException {
		//final long startTime = System.nanoTime();
		File folder = new File(Bonus_Path);
		String[] files_Names = folder.list();
		ArrayList<String> Keys_List = new ArrayList<String>();
		System.out.println("Length of folder is: "+ files_Names.length);
		int counter = 0;
		for(int i = 0; i < files_Names.length; i++) {
			if(files_Names[i].startsWith("enc") && files_Names[i].endsWith(".txt")) {
				System.out.println("Searching key to file number: " + i);
				Main.Decoding_Keys(files_Names[i], Keys_List);
				counter++;
			}	
		}
		Writer.Write_2_CSV(Keys_List);
		//final long duration = System.nanoTime() - startTime;
		//System.out.println(duration/1000000000);
		System.out.println(counter +" Files founded\nThe Keys to the files are in the file - "+Bonus_File_Write);
	}

}
