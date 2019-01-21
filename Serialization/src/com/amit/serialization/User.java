package com.amit.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
 
public class User implements Serializable {
 
    private static final long serialVersionUID = 1L;
     
    private transient String firstName;
    private transient String lastName;
    private transient int accountNumber;
    private transient Date dateOpened;
    private transient String bankName;
    // fieldCount to keep track of the no of fields in the Object. For compatibility between versions.
    private int fieldCount = 0;
 
    public User(String firstName, String lastName, int accountNumber, Date dateOpened, String bankName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
        this.bankName = bankName;
        this.fieldCount = 5;
    }
     
    public User() {
        super();
    }
 
    //Setters and Getters
 
    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {   
    	
    	aInputStream.defaultReadObject();
    	int currentCount = 0;
    	if (checkCount(currentCount)) {
    		return;
    	}
        firstName = aInputStream.readUTF();
        currentCount++;
        if (checkCount(currentCount)) {
    		return;
    	}
        lastName = aInputStream.readUTF();
        currentCount++;
        if (checkCount(currentCount)) {
    		return;
    	}
        accountNumber = aInputStream.readInt();
        currentCount++;
        if (checkCount(currentCount)) {
    		return;
    	}
        dateOpened = new Date(aInputStream.readLong());
        currentCount++;
        if (checkCount(currentCount)) {
    		return;
    	}
        bankName = aInputStream.readUTF();
    }
    
    private boolean checkCount(int currentCount) {
    	if (currentCount >= this.fieldCount) {
    		return true;
    	}
    	return false;
    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
    	
    	aOutputStream.defaultWriteObject();
        aOutputStream.writeUTF(firstName);
        aOutputStream.writeUTF(lastName);
        aOutputStream.writeInt(accountNumber);
        aOutputStream.writeLong(dateOpened.getTime());
        aOutputStream.writeUTF(bankName);
    }
    
    
    public final String getFirstName() {
        return firstName;
    }
 
    public final String getLastName() {
        return lastName;
    }
 
    public final int getAccountNumber() {
        return accountNumber;
    }
 
    public final Date getDateOpened() {
        return new Date(dateOpened.getTime());
    }
 
    public final void setFirstName(String aNewFirstName) {
        firstName = aNewFirstName;
    }
 
    public final void setLastName(String aNewLastName) {
        lastName = aNewLastName;
    }
 
    public final void setAccountNumber(int aNewAccountNumber) {
        accountNumber = aNewAccountNumber;
    }
 
    public final void setDateOpened(Date aNewDate) {
        Date newDate = new Date(aNewDate.getTime());
        dateOpened = newDate;
    }
    
    public final void setBankName( String aNewBankName) {
    	bankName = aNewBankName;
    }
    
    public final String getBankName() {
    	return bankName;
    }
}