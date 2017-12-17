import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final String PATH = "/";
	public static final String IN_PATH = PATH+"Read From files/";
	public static final String ENC_PATH = PATH+"Encryption files/";
	public static final String DEC_PATH = PATH+"Decryption files/";

	/**
	 * Main testing function.
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		String input;
		System.out.println("For enrypt and decrpy file press 1, For writing all keys from data(100 files), press 2.");
		input = sc.nextLine();
		if(input.equalsIgnoreCase("1")) {

			System.out.println("Read text from\n("+IN_PATH+"ReadFrom.txt)");
			Writer.Encoded_File(Algorithm.Encryption(Read_From_File.String_File(IN_PATH+"ReadFrom.txt"),Algorithm.KEY));
			Writer.Decoded_File(Algorithm.Decryption(Read_From_File.String_File(ENC_PATH+"ReadFrom - Encoded.txt"),Algorithm.KEY));
		}
		if(input.equalsIgnoreCase("2")) {
			Hack_Keys.decodeFiles();
		}
		sc.close();
	}
	
	/**
	 * Decode file.
	 * @param Folder Folder to scan.
	 * @param File 
	 * @param Keys_List
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void Decoding_Keys(File fileToDecode,  ArrayList<String> Keys_List) throws IOException, InterruptedException {
		//max key value.
		int maxKey = 100_000_000;
		
		//Init tasks.
		int val = maxKey/5;
		KeyLooper task1 = new KeyLooper(0, val, fileToDecode, Keys_List);
		KeyLooper task2 = new KeyLooper(val+1, 2*val, fileToDecode, Keys_List);
		KeyLooper task3 = new KeyLooper(2*val+1, 3*val, fileToDecode, Keys_List);
		KeyLooper task4 = new KeyLooper(3*val+1, 4*val, fileToDecode, Keys_List);
		KeyLooper task5 = new KeyLooper(4*val+1, 5*val, fileToDecode, Keys_List);

		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		Thread t3=new Thread(task3);
		Thread t4=new Thread(task4);
		Thread t5=new Thread(task5);

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MAX_PRIORITY);
		t5.setPriority(Thread.MAX_PRIORITY);

		t1.setName("Task 1");
		t2.setName("Task 2");
		t3.setName("Task 3");
		t4.setName("Task 4");
		t5.setName("Task 5");

		System.out.println("MAIN THREAD:" + Thread.currentThread().getName());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();


		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();

		System.out.println("Exiting");
	}
}
