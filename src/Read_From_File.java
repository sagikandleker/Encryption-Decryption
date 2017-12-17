import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * Read from files (String file or Integer file) functions.
 * @author Sagi, Roni, Shlomi.
 *
 */
public class Read_From_File {

	/**
	 * Read text from file by Strings.
	 * @param Path file to read.
	 * @return All the text in String.
	 * @throws IOException
	 */
	public static String String_File(String Path) throws IOException {

		String Orig = "";

		FileReader fr = new FileReader(Path);
		BufferedReader br = new BufferedReader(fr);	
		String Line = br.readLine();

		while(Line!=null)
		{

			Orig = Orig+Line+" ";
			Line = br.readLine();

		}

		br.close();
		return Orig;
	}

	/**
	 * Read text from file by Integers.
	 * @param Path file to read
	 * @return String with numbers.
	 * @throws IOException
	 */
	public static String Integer_File(String Path) throws IOException {

		File f = new File(Path);
		Scanner scan = new Scanner(f);
		String msg = "";
			
			msg = msg+(scan.nextInt())+" "+(scan.nextInt())+" "+(scan.nextInt()+" "+(scan.nextInt()));
		
		scan.close();
		return msg;
	}
	
}
