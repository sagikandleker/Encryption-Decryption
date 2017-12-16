import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Example {

	public static int KEY = 23332;
	public static String Enc_Path = "C:\\Users\\sagik\\git\\Encryption_and_decryption\\Encryption files\\";
	public static String Dec_Path = "C:\\Users\\sagik\\git\\Encryption_and_decryption\\Decryption files\\";

	public static void main(String[] args) throws IOException {

		//Write_2_Decryption_File(Encryption(Read_From_File(Enc_Path+"First.txt"),KEY));
		//Write_2_Encryption_File(Decryption(Read_From_Decryption_File(Enc_Path+"Encoded.txt"),KEY));
		//System.out.println(Decryption2(Read_From_File(Enc_Path+"Encoded.txt"),KEY));
		Decoding_Keys(Enc_Path);

	}

	public static String Encryption(String msg, int key){
		String ans = "";
		Random rand = new Random(key);

		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			int s = c;
			int rd = rand.nextInt()%(256*256);
			int s2 = s^rd;
			char c2 = (char)(s2);
			ans += c2;
		}

		return ans;

	}

	public static String Decryption(ArrayList<Integer> arr, int key){

		String ans = "";
		Random rand = new Random(key);

		for (int i = 0; i < arr.size(); i++) {

			int s = arr.get(i);
			int rd = rand.nextInt()%(256*256);
			int s2 = s^rd;
			char c2 = (char)(s2);
			ans += c2;	
		}

		return ans;	
	}

	public static String Decryption2(String Data, int key){
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

	public static String Decryption3(char Data, int key){
		String ans = "";
		Random rand = new Random(key);

		int s = Data;
		int rd = rand.nextInt()%(256*256);
		int s2 = s^rd;
		char c2 = (char)(s2);
		ans += c2;	
		return ans;
	}

	public static void Write_2_Decryption_File(String msg_enc) throws IOException {

		FileWriter fw = new FileWriter(Enc_Path+"Encoded.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg_enc.length(); i++) {
			stringBuilder.append((int)msg_enc.charAt(i)+" ");
		}
		fw.write(stringBuilder.toString());
		fw.close();
	}

	public static void Write_2_Decryption_File2(String msg_enc) throws IOException {

		FileWriter fw = new FileWriter(Enc_Path+"Encoded.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg_enc.length(); i++) {
			stringBuilder.append((int)msg_enc.charAt(i)+" ");
		}
		fw.write(stringBuilder.toString());
		fw.close();
	}

	public static String Read_From_File(String Path) throws IOException {

		String Orig = "";

		FileReader fr = new FileReader(Path);
		BufferedReader br = new BufferedReader(fr);	
		String Line = br.readLine();

		while(Line!=null)
		{

			Orig=Orig+Line;
			Line = br.readLine();

		}

		br.close();
		//System.out.println(Orig);
		return Orig;
	}

	/*public static ArrayList<Integer> Read_From_Decryption_File(String Path) throws IOException {

		File f = new File(Path);
		Scanner scan = new Scanner(f);
		ArrayList<Integer> Words = new ArrayList<Integer>();

		while(scan.hasNextInt()) {

			Words.add(scan.nextInt());
		}

		scan.close();
		System.out.println("Words ArrayList: "+Words);
		return Words;
	}*/

	public static void Write_2_Encryption_File(String msg_enc) throws IOException {

		FileWriter fw = new FileWriter(Enc_Path+"Encoded2.txt");
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < msg_enc.length(); i++) {
			stringBuilder.append(msg_enc.charAt(i)+"\n");
		}

		fw.write(stringBuilder.toString());
		fw.close();
	}

	public static void Decoding_Keys(String Path) throws IOException {
		String File_Name="enc_0_msg.txt";
		String DATA = Read_From_File(Path+File_Name);
		String DecData; 

		for (int i = 75860000; i < 99999999; i++) {
			DecData = Decryption2(DATA, i);
			//System.out.println(DecData);
			System.out.println("KEYS = "+i);
			if((DecData.charAt(0) > 1487 && DecData.charAt(0) < 1515) &&
					(DecData.charAt(1) > 1487 && DecData.charAt(1) < 1515) &&
					(DecData.charAt(2) > 1487 && DecData.charAt(2) < 1515))/*
					|| (DecData.charAt(0) > 96 && DecData.charAt(0) < 123)
					|| (DecData.charAt(0) > 54 && DecData.charAt(0) < 91)) */
			{
				System.out.println("Key: "+i);
				break;
			}
		}

	}
}



