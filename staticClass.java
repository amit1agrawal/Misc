package com.java.sync;

/**
 * A synchronized method (§8.4.3.6) automatically performs a lock action when it is
invoked; its body is not executed until the lock action has successfully completed. If
the method is an instance method, it locks the monitor associated with the instance
for which it was invoked (that is, the object that will be known as this during
execution of the body of the method). If the method is static, it locks the monitor
associated with the Class object that represents the class in which the method is
defined. If execution of the method's body is ever completed, either normally or
abruptly, an unlock action is automatically performed on that same monitor.

THIS PROGRAM IS TO TEST THAT LOCKS ON CLASS LEVEL MONITOR WHEN STATIC METHOD IS SYNCHRONIZED.
Result: Method2 is not entered till the time method1 is being executed and vice versa.
 * @author Amit.Agrawal2
 *
 */

class StaticClassInner {
	
	public synchronized static void method1() {
		// Wait forever
		System.out.println("Entered method1");
		try {
			
			Thread.sleep(1000);
			System.out.println("Method1 Wakeup from sleep");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized static void method2() {
		System.out.println("Entered method2");
		try {
			Thread.sleep(1000);
			System.out.println("Method2 Wakeup from sleep");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class DummyThread extends Thread {
	
	public boolean method = true;
	
	public void run() {
		if (this.method) {
			StaticClassInner.method1();
		}
		else {
			StaticClassInner.method2();
		}
	}
	
	
}


public class staticClass{
	
	public static void main(String[] args) {
		
		DummyThread t1 = new DummyThread();
		DummyThread t2 = new DummyThread();
		
		t2.method = false;
		System.out.println("Thread1 starting");
		t1.start();
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Thread2 Starting");
		t2.start();
		
	}
}