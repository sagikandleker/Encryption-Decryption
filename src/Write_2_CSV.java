import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Write_2_CSV {

	/**
	 * 
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
	 * 
	 * @param Bonus_Key_List
	 * @throws IOException
	 */
	public static void Write(ArrayList<String> Bonus_Key_List) throws IOException {

		FileWriter fw = new FileWriter(Hack_Keys.Bonus_File_Write, true);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		int counter = 0;
		for (int i = 0; i < Bonus_Key_List.size(); i++) {	
			stringBuilder.append((Bonus_Key_List.get(i).toString().replace("[", "").replace("]", "")));
			stringBuilder.append(",");
			if(counter%2 != 0) {
				stringBuilder.append("\n");
			}
		}
		
		fw.write(stringBuilder.toString());
		fw.close();
	}
	
}
