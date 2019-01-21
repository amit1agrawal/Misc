package com.amit.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 class SerializationDemo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int a;
	public String b;

	public  SerializationDemo( int a, String b){
		this.a = a;
		this.b = b;
	}
}


 public class SerializationTest {
	public static void main(String[] args) {
		SerializationDemo object = new SerializationDemo(10,"geekforgeeks");
		String filename = "file.ser";
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(object);
			
			out.close();
			file.close();
			System.out.println("Object has been serialized");
			
		}
		catch(IOException e) {
			System.out.println("IOException caught");
		}
		
		SerializationDemo object1 = null;
		
		try{
			FileInputStream filein = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(filein);
			
			object1 = (SerializationDemo) in.readObject();
			
			System.out.println("Object has been deserialized");
			System.out.println(object1.a);
			System.out.println(object1.b);
			
		}
		catch(IOException e) {
			System.out.println("IOException caught");
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		

	}
}