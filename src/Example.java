import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Data_Setup.Record;
import Main_App.Main;


public class Example {

	public static int KEY = 23332;
	
	public static String Bonus_Path = "C:\\Users\\sagik\\git\\Encryption_and_decryption\\Bonus\\";
	public static String Bonus_File_Write = Bonus_Path+"Bonus_Key_List.csv";


	public static void main(String[] args) throws IOException, ParseException {


		//System.out.println(Decryption2(Read_From_File(Enc_Path+"Encoded.txt"),KEY));
		getFiles();

	}
	
	public static void getFiles() throws IOException, ParseException {

		File folder = new File(Bonus_Path);
		String[] files_Names = folder.list();
		
		int counter = 0;
		for(int i = 0; i < files_Names.length; i++) {
			if(files_Names[i].startsWith("enc") && files_Names[i].endsWith(".txt")) {
				Decoding_Keys(Bonus_Path,files_Names[i]);
				counter++;
			}	
		}
		System.out.println(counter +" Files founded");
	}

	public static String Encryption_And_Decryption(String Data, int key){
		String ans = "";
		Random rand = new Random(key);

		String[] array = Data.split(" ");

		for (int i = 0; i < array.length-1; i++) {
			int s = Integer.parseInt(array[i]);
			int rd = rand.nextInt()%(256*256);
			int s2 = s^rd;
			char c2 = (char)(s2);
			ans += c2;	
		}

		return ans;	
	}

	public static void Write_Headers() throws IOException {
		String[] titles_list = {"File name","Key"};
		FileWriter file = new FileWriter(Bonus_File_Write);
		
		for (int i = 0; i <= titles_list.length-1; i++) {
			file.write(titles_list[i]+",");
		}
		file.close();
		
		
	}
	public static void Write_2_CSV(ArrayList<String> Bonus_Key_List) throws IOException {
		
		FileWriter fw = new FileWriter(Bonus_File_Write, true);
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
	
	public static void Decoding_Keys(String Folder, String File) throws IOException {
		Write_Headers();
		ArrayList<String> Keys_List = new ArrayList<String>();
		
		String encoded_data = Encryption_Algorithm.Read_From_File(Folder+File);
		String decoded_data;

		//Thread t1=new Thread(DATA);
		//Thread t2=new Thread(DATA);
		
		//t1.start();
		//t2.start();
		
		for (int i = 75863830; i < 99999999; i++) {
			decoded_data = Encryption_And_Decryption(encoded_data, i);
			if((decoded_data.charAt(0) > 1487 && decoded_data.charAt(0) < 1515) &&
					(decoded_data.charAt(1) > 1487 && decoded_data.charAt(1) < 1515) &&
					(decoded_data.charAt(2) > 1487 && decoded_data.charAt(2) < 1515))
			{
				System.out.println("File Name: "+File+"\nKey: "+i);
				Keys_List.add(File);
				Keys_List.add(""+i);
				break;
			}
		}
		Write_2_CSV(Keys_List);
	}
}
