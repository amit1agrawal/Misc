package com.amit.singleton;
import java.lang.reflect.Constructor;


public class CFG {

	public static void main(String[] args) throws InstantiationException{
		/*
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = null;
		Singleton instance3 = null;
		*/

		Singleton instance2 = null;
		try{
			Class<Singleton> singletonClass = (Class<Singleton>) Class.forName("Singleton");
			//Singleton SingletonReflection = singletonClass.newInstance();
			Constructor[] constructors =  singletonClass.getDeclaredConstructors();
			for (Constructor constructor : constructors){
				constructor.setAccessible(true);
				instance2 = (Singleton) constructor.newInstance();
				break;
			}
		}

		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(InstantiationException e){
			e.printStackTrace();
		}
		catch (IllegalAccessException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		if (instance2 != null){
			System.out.println("instance2.hashCode() :- " + instance2.hashCode());
		}
		/*
		try{

			instance3 = Singleton.getInstance();
			Constructor[] constructors =  Singleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors){
				constructor.setAccessible(true);
				instance2 = (Singleton) constructor.newInstance();
				break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode() :- " + instance1.hashCode());
		System.out.println("instance2.hashCode() :- " + instance2.hashCode());
		System.out.println("instance3.hashCode() :- " + instance3.hashCode());
		*/
	}
}