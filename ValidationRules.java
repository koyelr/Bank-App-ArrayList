package utils;
import exceptionhandling.*;

import java.util.ArrayList;

import bankapp2.*;
public class ValidationRules {
	
	//constant static data members
	private static final double MIN_BAL;
	
	//static initialiser block
	static {
		MIN_BAL = 1000.0;
	}
	
	public static BankAccount validateInputs(int accNo, String name, String accType, double accBal, String pin, ArrayList<BankAccount> acc) throws InvalidInputDetailsException {
		

		int no = validateAccNo(acc, accNo);
		AccountType type = validateAccType(accType);
		double bal = validateBalance(accBal);


		//String pin1 = validatePin(pin);
		return new BankAccount(no,name,type,bal,pin);
		
	}
	//1. account balance > min balance
	public static double validateBalance(double bal) throws InvalidInputDetailsException {
		if(bal< MIN_BAL)
			throw new InvalidInputDetailsException("Minimum balance should be 1000 atleast");
		return bal;
	}
	
	//2. account type can be either : SAVING | CHECKING | LOAN | FD 

	
	public static int validateAccNo(ArrayList<BankAccount> acc,int accNo) throws InvalidInputDetailsException{
		
		BankAccount tmp = new BankAccount(accNo);
		for(BankAccount b : acc) {
			if(b!=null)
				if(b.equals(tmp))
					throw new InvalidInputDetailsException("This account number already exists!!");
		
		}
		return accNo;
        
	}
	
		//account type can be either : SAVING | CHECKING | LOAN | FD 
		public static AccountType validateAccType(String type) {
			return AccountType.valueOf(type.toUpperCase());
		}

		
		//pin validation
		public static boolean validatePin(String pin, int acc, ArrayList<BankAccount> accounts) throws InvalidInputDetailsException  {
			System.out.println("Inside validate pin");
			
			for(BankAccount b:accounts) {
				
				if((b.getAccNo() == acc)) {
					System.out.println("Inside first if");
					if(b.getPin().equals(pin))
						System.out.println("inside second if");
						return true;
				}
			}
			
			throw new InvalidInputDetailsException("Wrong pin or account no entered!!!");
		}

}
