package com.amit.singleton;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class StaticSingleton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StaticSingleton() {
		System.out.println("StaticSingleton constructor called");
	}
	
	private static class StaticSingletonHolder {
		static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return StaticSingletonHolder.instance;
	}
	
	protected Object Clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Cloning of this object is not supported!");
	}
	
	protected Object readResolve() {
		return StaticSingletonHolder.instance;
	}
	
	public Object newInstance() throws InstantiationException{
		throw new InstantiationException("Creation of this object is not allowed");
	}
	
}



public class StaticSingletonTest{
	
	public static void main(String[] args) {
		// Just create a reference variable without initializing and check whether the constructor is called
		StaticSingleton singleton;
		StaticSingleton singletonClone;
		
		
		
		// Get the Instance. Constructor should be called now.
		System.out.println("Getting the instance now");
		singleton = StaticSingleton.getInstance();
		
		try {
			/*Class<StaticSingleton> singletonClass = (Class<StaticSingleton>) Class.forName("com.amit.singleton.StaticSingleton");
			Constructor[] constructors =  singletonClass.getDeclaredConstructors();*/
			@SuppressWarnings("rawtypes")
			Constructor[] constructors =  StaticSingleton.class.getDeclaredConstructors();
			for (@SuppressWarnings("rawtypes") Constructor constructor : constructors){
				constructor.setAccessible(true);
				singletonClone = (StaticSingleton) constructor.newInstance();
				break;
			}
		} 
		/*catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/ 
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(singleton.hashCode());
		
		//The constructor should not be called again.
		
		singleton = StaticSingleton.getInstance();
		System.out.println(singleton.hashCode());
		
	}
	
}