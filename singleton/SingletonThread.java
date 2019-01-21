package com.amit.singleton;

public class SingletonThread extends Thread {
	
	public void run(){
		try {
			Singleton instance = null;
			instance = Singleton.getInstance();
			System.out.println("This threads contains the instance no :- " + instance.hashCode());	
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

}
