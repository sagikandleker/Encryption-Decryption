import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
}
