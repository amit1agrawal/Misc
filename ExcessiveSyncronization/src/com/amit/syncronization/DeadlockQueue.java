
package com.amit.syncronization;

class DeadlockQueue extends WorkQueue {
	protected void processItem(final Object workItem) throws InterruptedException {
		// Create a new thread that returns workItem to queue
		Thread child = new Thread() {
			public void run() {
				System.out.println(workItem);
				enqueue(workItem);
			}
		};
		child.start();
		child.join(); // Deadlock!	
	}
}