package com.amit.singleton;
import java.io.Serializable;

public class Singleton implements Serializable {		
	/**
	 * My Singleton class which prevents clone, new instance via reflection and serialization/deserialization
	 */
	private static final long serialVersionUID = -9000752106687223004L;

	private static Singleton instance = null;
	private static final Object lockObj = new Object();
	
	private Singleton(){
		if( Singleton.instance != null ) {
	        throw new InstantiationError( "Creating of this object is not allowed." );
	    }
	}
	
	public static Singleton getInstance(){
		if (instance != null){
			return instance;
		}
		synchronized (lockObj){
			if (instance != null){
				return instance;
			}
			else{
				instance = new Singleton();
			}			
		}
		return instance;
	}
	
	protected Object Clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Cloning of this object is not supported!");
	}
	
	protected Object readResolve(){
		return instance;
	}
	
	public Object newInstance() throws InstantiationException {
		throw new InstantiationException("Creating of this object is not allowed");
	}
}

