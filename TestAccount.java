package testclass2;
import java.util.*;
import bankapp2.*;
import exceptionhandling.InvalidInputDetailsException;
import utils.ValidationRules;
import sorting.*;

public class TestAccount {
	//main method
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){	//try with resources
		
			ArrayList<BankAccount >accounts = new ArrayList<>();
			boolean exit = false;
			boolean flag = false;
			int loggedInAcc =0;
			//int counter = 0;
			while(!exit) {
				
				System.out.println("Enter your choice!!!!");
				System.out.println("1. Create a new account /// 2. NetBanking Login /// 3. Display Account Details /// 4. Withdraw Funds "+
									"/// 5. Deposit Funds  /// 6. Fund Transfer /// 7. Close Account /// 8. Logout ///"+
									" 9. Sorting using acc No. /// 10. sorting using acc bal /// 0. Exit");
				try{
				
				switch(sc.nextInt()) {
				
					/*Create Bank Account
					Accept all i/ps , validate . In case of success , create bank acct object n store it's reference in the ArrayList.*/
					case 1: 
						
						
							System.out.println("Enter the account details:: 1.ACC NO 2.NAME 3.ACCTYPE 4.BALANCE 5. PIN");
							BankAccount b = ValidationRules.validateInputs(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),accounts);
							accounts.add(b);
							System.out.println(b);
							System.out.println("Account created successfully");
						
						break;
					
					
					/*Netbanking Login
					i/p : account no n pin (For this , will you modify your equals method ? I hope not !)
					o/p : login successful or invalid login (throw custom exc )*/
						
					case 2: 
							if( flag != true) {
								System.out.println("Netbanking Login!");
						        System.out.println("Enter your account number to login");
						        loggedInAcc = sc.nextInt();
						       
						        BankAccount b1 = new BankAccount(loggedInAcc);
						        int index = accounts.indexOf(b1);
						        //System.out.println("index "+index);
						        //ValidationRules.validateAccNo(accounts, loggedInAcc);
						        
						        System.out.println("Enter your pin!");
						        String pin = sc.next();
						        ValidationRules.validatePin(pin,loggedInAcc,accounts);
						        flag = true;
						        System.out.println("Login successfully!!!!!!!");
							}else
								System.out.println("You are already logged in!");
					        
					     break;
						
					case 3: 
							System.out.println("Bank Account Details");
								for(BankAccount acc:accounts) {
							
										System.out.println(acc);

						
								}
					
						break;
						
					/*Withdraw funds
					i/p : amount to withdraw (no acct no here!!!!)
					o/p : If customer has logged in successfully, then only allow withdraw.
					O.w : throw the execption : indicating login(Authentication Failed : Can't Withdraw!!!!)*/
						
					case 4: System.out.println("Withdraw Funds!!!!");
					
							if(flag== true) {
								
								System.out.println("Enter the amount to be withdrawed");
								double d = sc.nextDouble();
								
								BankAccount bb = new BankAccount(loggedInAcc);
								
								int index1 = accounts.indexOf(bb);
								System.out.println(index1+ " "+loggedInAcc);
								BankAccount b1 =accounts.get(index1);
								System.out.println("Hollaaaa");
								if (index1 == -1)
									throw new InvalidInputDetailsException("Invalid account no!!!!!!");

								System.out.println("The current balance before withdrawal is "+ b1.getAccBal());
								
								b1.setAccBal(b1.withdrawAmount(d));
				        		System.out.println("Amount withdraw successfully!!!");
				        		System.out.println("The new balance after withdrawal is::"+b1.getAccBal());
								

							}
							else
								System.out.println("Please login first!");
						
						break;
						
					/*Deposit funds
					i/p : amount to deposit (no acct no here!!!!)
					o/p : If customer has logged in successfully, then only allow deposit.
					O.w : throw the execption : indicating login(Authentication Failed : Can't Deposit!!!!)*/
						
					case 5: System.out.println("Deposit Funds!!!");
						
							if(flag == true) {
								System.out.println("Enter the amount to be deposited");
								double d = sc.nextDouble();
								
								int index1 = accounts.indexOf(new BankAccount(loggedInAcc));
								BankAccount b1 =accounts.get(index1);

								if (index1 == -1)
									throw new InvalidInputDetailsException("Invalid account no!!!!!!");

								System.out.println("The current balance before deposit is "+ b1.getAccBal());
								
								b1.setAccBal(b1.depositAmount(d));
				        		System.out.println("Amount deposited successfully!!!");
				        		System.out.println("The new balance after deposit is::"+b1.getAccBal());
								
							}
							else
								System.out.println("Please login first!");
							
						break;
						
						
					/*Funds Transfer
					i/p : dest acct no n transfer amount
					o/p : If customer has logged in successfully,validate dest acct no n perform the transfer
					O.w : throw the suitable custom execption , with error mesg. */
					
					case 6: System.out.println("Fund transfer");
					        if(flag == true) {
					        	System.out.println("Enter the reciever's account no");
					        	BankAccount b1 = new BankAccount(sc.nextInt());
								int index1 = accounts.indexOf(b1);
								if (index1 == -1)
									throw new InvalidInputDetailsException("Invalid account no!!!!!!");
								System.out.println("Enter the amount to be send");
								double d = sc.nextDouble();
								
								b1.depositAmount(d);
								System.out.println("Amount deposited to the reciever's account successfully");
								int index2 = accounts.indexOf(new BankAccount(loggedInAcc));
								System.out.println("hi");
								BankAccount b2 =accounts.get(index2);
								System.out.println("hi2");
								b2.withdrawAmount(d);
								System.out.println("your amount after transfer is :"+b2.getAccBal());

					        	
					        }
					        else System.out.println("Please login first!");

					        	
						break;
						
					
					
					/*Close Account
					No inputs required
					o/p : If customer has logged in successfully, then allow him to close the account
					O.w : throw the suitable custom execption , with error mesg. */
						
					case 7:
						System.out.println("Close account!!!! ");
						if(flag == true) {
							int index1= accounts.indexOf(new BankAccount(loggedInAcc));
							accounts.remove(index1);
							System.out.println("Account closed successfully!!!");
							
							System.out.println("Current Bank Account Details available");
							for(BankAccount acc:accounts) {
						
									System.out.println(acc);

					
							}
				
							
							

						}else System.out.println("Please login first!");
						
						break;
					
					
					/*Log out 
					No inputs required.
					o/p : If customer has logged in successfully, then allow him to logout.*/
					case 8:
						if(flag == true) {
							flag = false;
							System.out.println("User Logged out successfully!!!!!");
						}
						break;
						
					case 9: 
						System.out.println("Sorting as per account no.");
						Collections.sort(accounts);
						
						break;
						
					case 10:
						System.out.println("Sorting as per account balance");
						Collections.sort(accounts, new BankBalComparator());
					
					case 0: exit = true;
						break;
			
						
					default: System.out.println("Wrong choice entered!!!");
						break;
				}}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			
			}}
		/*catch(InvalidInputDetailsException e) {
			System.out.println(e.getMessage());
		}*/
		
	}
}
