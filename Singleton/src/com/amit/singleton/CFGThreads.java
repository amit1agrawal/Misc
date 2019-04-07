package com.amit.singleton;
import java.lang.reflect.Constructor;


public class CFGThreads {

	public static void main(String[] args) throws InstantiationException{
		// Create Threads

		SingletonThread firstThread = new SingletonThread();
		SingletonThread secondThread = new SingletonThread();
		SingletonThread thirdThread = new SingletonThread();

		firstThread.start();
		secondThread.start();
		thirdThread.start();
	}
}