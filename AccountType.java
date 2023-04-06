package bankapp2;

public enum AccountType {
	SAVING,CURRENT,FD,DMAT,LOAN;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
