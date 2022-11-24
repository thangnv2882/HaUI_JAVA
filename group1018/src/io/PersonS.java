package io;

import java.io.*;

public class PersonS implements Serializable {
	
	static int count = 0;
	private int id;
	private PersonS next;
	
	public PersonS() {
		count++;
		this.id = count;
		if(count < 10) {
			this.next = new PersonS();
		}else {
			this.next = null;
		}
	}
	
	public String toString() {
		return "Object: " + this.id;
	}

	public static void main(String[] args) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("abc.txt"));
			PersonS p = new PersonS();
			out.writeObject(p);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.txt"));
			PersonS p1 = (PersonS) in.readObject();
			in.close();
			
//			while(p1 != null) {
//				System.out.println(p1);
//				p1 = p1.next;
//			}
			
			do {
				System.out.println(p1);
			} while((p1 = p1.next) != null);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
