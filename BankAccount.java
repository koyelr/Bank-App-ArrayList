package bankapp2;
import java.time.LocalDate;

import exceptionhandling.*;
import utils.*;

/*Every Bank Account must have acct number(int) , customer name(string), pin (string),
account type (enum : SAVING,CURRENT,FD,DMAT,LOAN) , account balance(double) , creation date(localdate)
*/


public class BankAccount implements Comparable<BankAccount>{
	//private data members
	private Integer accNo;
	private String name;
	private AccountType accType;
	private double accBal;
	private String pin;
	private LocalDate creationDate;
	
	//paramterized constructor with all datamembers
	public BankAccount(int accNo, String name, AccountType accType, double accBal, String pin) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.accType = accType;
		this.accBal = accBal;
		this.pin= pin;
	}

	//constructor for pin

	public BankAccount(String pin) {
		super();
		this.pin = pin;
	}
	
	//for wrapping class with accno
	public BankAccount(int accNo) {
		super();
		this.accNo = accNo;
	}


	//getters and setters for all the data members
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountType getAccType() {
		return accType;
	}

	

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}


	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	//overriding equals()
	@Override
	public boolean equals(Object obj) {
		//downcasting from object class to BankAccount class
		if( obj instanceof BankAccount) {
		BankAccount b = (BankAccount)obj;
		
		//returns true if both the account no. are equal
		return this.accNo == b.accNo;}
		return false;
	
	}
	
	@Override
	public int compareTo(BankAccount o) {
		System.out.println("in accounts compareTo");
		return this.accNo.compareTo(o.accNo);
	}
	
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", name=" + name + ", accType=" + accType + ", accBal=" + accBal
				+ ", pin=" + pin + "]";
	}

	//deposit amount to account
	public double depositAmount(double amt) {
		
		return this.accBal+amt;
	}
	
	//withdraw double from account
	public double withdrawAmount(double amt) throws InvalidInputDetailsException {
		
		double amount = this.accBal-amt;
		if(amount < 0)
			throw new InvalidInputDetailsException("Please enter a valid withrawal amount");
		return amount;
			
		
		
		
	}


	
	
	
	
	
	
	
	
	
}
