package com.amit.syncronization;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public abstract class WorkQueue {

	private final List queue = new LinkedList();
	private boolean stopped = false;
	//private ReentrantLock lock = new ReentrantLock();
	
	protected WorkQueue() {
		System.out.println("Starting the worker thread");
		new WorkerThread().start();
		System.out.println("Worker thread started");
	}
	
	public final void enqueue (Object workItem) {
		System.out.println("ENQUE: trying to acquiring lock on queue");
		synchronized (queue) {
			System.out.println("Adding an items to the queue");
			queue.add(workItem);
			System.out.println("Added an item to the queue. Now notifying");
			queue.notify();
		}
	}
	
	public final void stop() {
		synchronized (queue) {
			stopped = true;
			queue.notify();
		}
		
	}
	// The method should be implemented by subclass
	protected abstract void processItem(Object workItem) throws InterruptedException;
	
	private class WorkerThread extends Thread {
		public void run() {
			while (true) {
				Object workItem = null;
				System.out.println("RUN: trying to acquiring lock on queue");
				synchronized (queue) {
					try {
							while (queue.isEmpty() && !stopped) {
								System.out.println("going to wait for the queue");
								queue.wait();
								System.out.println("Waiting for queue is over");
							}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
					
					if (stopped)
						return;
					
					workItem = queue.remove(0);	
					System.out.println("removed the first items from the queue");
					try {
						System.out.println("About to process the work item");
						processItem(workItem);
						System.out.println("Proceed the work Item completed");
					}
					catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
				
				
			}
		}
	}
}
