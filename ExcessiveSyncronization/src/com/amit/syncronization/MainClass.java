package com.amit.syncronization;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeadlockQueue lockQueue = new DeadlockQueue();
		
		// enqueue the first object. It will cause deadlock
		
		lockQueue.enqueue("Just a String");
		
		//System.out.println("No DeadLock!!");
		// Now stop the WorkerThread
		
		//lockQueue.stop();
	}

}