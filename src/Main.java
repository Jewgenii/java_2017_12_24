import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

public class Main {

	public static void main(String[] args) {
		
	/*	System.out.println("fff");
		ArrayList<Integer> ali = new ArrayList<Integer>();
		
		ali.add(3);
		ali.add(4);
		ali.add(43);
		ali.add(42);
		ali.add(224);
		ali.add(123);
		
		System.out.println(ali.get(1));
		System.out.println(ali.isEmpty());
		
		int l = ali.size();
		System.out.println(l);
		ali.remove(0);
		
		
		ArrayList<Person> persons = new ArrayList<Person>(10);
		persons.add(new Person("Anna",42,'f'));
		persons.add(new Person("Bob",44,'m'));
		persons.add(new Person("Steve",24,'m'));
		persons.add(new Person("Kate",24,'f'));
		
		
		for(Person per:persons) {
			
			System.out.println(per.toString());
		}
		
		SortByName sort = new SortByName();
		persons.sort(sort);
		
		System.out.println("===========");
		
	for(Person per:persons) {
			
			System.out.println(per.toString());
		}
	
		persons.sort(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		System.out.println("===========");
				
	for(Person per:persons) {
			
			System.out.println(per.toString());
		}
	
	persons.sort(null);
	
	System.out.println("===========");
	
	for(Person per:persons) {
			
			System.out.println(per.toString());
		}
	
	
		HashMap<Integer,Person> h = new HashMap<>();
							
		h.put(1, persons.get(0));
		h.put(2, persons.get(1));
		h.put(3, persons.get(3));
		
		
		for(Integer key: h.keySet()) {
			System.out.println(key);
		}
		
		for(Person p: h.values()) {
			System.out.println(p);
		}
		
		for(Map.Entry<Integer, Person> item: h.entrySet()) {
			System.out.println(item.getKey() + " value:" + item.getValue());
		}
		
		
		Lambda lamb =(s1,s2)->s1+s2;
		
		System.out.println(lamb.too("Hello", "World"));
		
		
		Lambda lamConcat = new Lambda() {
			 @Override
			public String too(String s1, String s2) {
				return s1 + s2;
			}
		};
		
		Lambda lamReverse = new  Lambda() {
			 @Override
			public String too(String s1, String s2) {
				// TODO Auto-generated method stub
				 String rev = "";
				 for(int i = s1.length()-1;i<s1.length();i++)
				 {
					 rev+=s1.charAt(i);
				 }
				 for(int i = s2.length()-1;i<s2.length();i++)
				 {
					 rev+=s2.charAt(i);
				 }
				return rev;
			}
		};
		
		System.out.println(lamReverse.too("Hello","World"));
		
		System.out.println(lamConcat.too("fdf", "fdfs"));
		
		
		File f = new File("./");
		File[] files = f.listFiles();
		
		for(File ff: files)
		{
			System.out.println(ff.getName());
			System.out.println(ff.getAbsolutePath());
		}
		
		File fl = new File("./page.txt");
		try {
			
			if(!fl.exists()) {
				fl.createNewFile();
			}
			//else
			//fl.delete();
		} 
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			// TODO: handle finally clause
		}
		
		try(FileInputStream fis = new FileInputStream("./page.txt")){
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer,0,fis.available());
			
			System.out.println("Printing");
			for(int i =0;i<buffer.length;i++) {
				System.out.print((char)buffer[i]);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally{
			
		}
		
		byte[] buffer = null;
		String write = "Some info";
		try(FileOutputStream fisRead = new FileOutputStream("./page.txt"))
		{
		 write.getBytes();
			fisRead.write(buffer);
						
		}catch(IOException ex) {
		System.out.println(ex.getMessage());	
		}
		
		try {
			Scanner sc = new Scanner(System.in);
			FileOutputStream fos = new FileOutputStream("./page.txt");
			
			while(sc.hasNext()) {
				fos.write((sc.nextLine() + "\r\n").getBytes());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		try(FileOutputStream fisRead = new FileOutputStream("./page.txt"))
		{
		 byte[] buffer1 = null;
		 write.getBytes();
			fisRead.write(buffer1);
						
		}catch(IOException ex) {
		System.out.println(ex.getMessage());	
		}
		
		
		for(int i = 52;i<buffer.length;i++) {
			buffer[i] *=2;	
		}
				
		try(FileOutputStream fos = new FileOutputStream("./scr/copied.bmp")){
					
			fos.write(buffer,0,buffer.length);
				
		}
		catch(IOException ex) 
		{
			
		}
		catch(Exception ex)
		{
			
		}
		
		*/
		
		
		//==========================================================================
		
		Game g = new Game(1000);
		g.getPlayers().add(new Player("Roma",100));
		g.getPlayers().add(new Player("Petya",50));
		g.getPlayers().add(new Player("Kolia",150));

		
		long t3 = System.currentTimeMillis();
		
		try(ObjectOutputStream oos =
					new ObjectOutputStream(new FileOutputStream("game.dat")) )
		{
			oos.writeObject(g);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		long t4 = System.currentTimeMillis();
		System.out.println(t4-t3);
	
		
		Game saved_game  = null;
		
		try(ObjectInputStream ois =
				new ObjectInputStream(new FileInputStream("game.dat")) )
	{
			saved_game = (Game)ois.readObject();
			
			for (Player p : saved_game.getPlayers()) {
				System.out.println(p);
			}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
			
		
		
	Gson gson = new Gson();
	String ConvertationResult = gson.toJson(saved_game);
	
	System.out.println(ConvertationResult);	
		
	
	long t1 = System.currentTimeMillis();
	
	PrintWriter pwe = null;
	
		try{
			pwe = 
					new PrintWriter(new BufferedOutputStream(new FileOutputStream("save.json") ));
		}catch(IOException ex) {
			
		}
	pwe.write(ConvertationResult);
	pwe.flush();
	pwe.close();
	
	long t2 = System.currentTimeMillis();
	
	System.out.println(t2 - t1);
	
	Game new_game = null;
	try(Scanner sc = new Scanner(new FileInputStream("save.json"))) {
		String resultDes = sc.nextLine();
		new_game = gson.fromJson(resultDes, Game.class);
		
		
		for (Player p : new_game.getPlayers()) {
			System.out.println(p);
		}
		
	}catch(IOException ex) {
		
	}
	
//	=======================================================================
	
	
	ArrayList<Person> alp = new ArrayList<>();
	alp.add(new Person("jack",34,'m'));
	alp.add(new Person("fff",334,'m'));
	alp.add(new Person("vvv",232,'m'));
	
	String resSer = gson.toJson(alp);	
			
	Type type = new TypeToken<ArrayList<Person>>() {}.getType();
	
	System.out.println(type);
	
	ArrayList<Person> plist = gson.fromJson(resSer, type);
	
	}
}

