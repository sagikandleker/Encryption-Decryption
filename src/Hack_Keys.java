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
	 * @throws InterruptedException 
	 */
	public static void getFiles() throws IOException, ParseException, InterruptedException {

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
	 * @throws InterruptedException 
	 */
	public static void Decoding_Keys(String Folder, String File, ArrayList<String> Keys_List) throws IOException, InterruptedException {
		String path = Folder+File;
		File file = new File(path);
		
		Keys_List.add(file.getAbsolutePath());
		
		int maxKey = 1_000_000_000;
		Thr task1 = new Thr(0, maxKey/4, path);
		Thr task2 = new Thr((maxKey/4)+1, maxKey/2, path);
		Thr task3 = new Thr((maxKey/2)+1, 3*(maxKey/4), path);
		Thr task4 = new Thr(3*(maxKey/4)+1, maxKey, path);
		
		if(task1.keyFounded != -1)
			Keys_List.add(""+task1.keyFounded);
		else if(task2.keyFounded != -1)
			Keys_List.add(""+task1.keyFounded);
		
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		Thread t3=new Thread(task3);
		Thread t4=new Thread(task4);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MAX_PRIORITY);
		
		t1.setName("Task 1");
		t2.setName("Task 2");
		t3.setName("Task 3");
		t4.setName("Task 4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
	
	
			//System.out.println("File Name: "+File+"\nKey: "+i);
			//Keys_List.add(File);
			//Keys_List.add(""+key);

	}
}
