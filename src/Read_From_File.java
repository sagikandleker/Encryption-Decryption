import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Read_From_File {

	/**
	 * Read From File
	 * @param Path
	 * @return
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
	 * 
	 * @param Path
	 * @return
	 * @throws IOException
	 */
	public static String Integer_File(String Path) throws IOException {

		String Orig = "";

		FileReader fr = new FileReader(Path);
		BufferedReader br = new BufferedReader(fr);	
		String Line = br.readLine();

		while(Line!=null)
		{

			Orig = Orig+Line;
			Line = br.readLine();

		}

		br.close();
		return Orig;
	}
	
	public static String Integer_File2(String Path) throws IOException {

		FileReader fr = new FileReader(Path);
		BufferedReader br = new BufferedReader(fr);	
		String Line = br.readLine();
		
		br.close();
		return Line;
	}
	
	public static String Integer_File3(String Path) throws IOException {

		File f = new File(Path);
		Scanner scan = new Scanner(f);
		String msg = "";
			
			msg = msg+(scan.nextInt())+" "+(scan.nextInt())+" "+(scan.nextInt()+" "+(scan.nextInt()));
		
		System.out.println("MSG:"+msg);
		scan.close();
		return msg;
	}
	
}
