package sorting;

import java.util.Comparator;

import bankapp2.BankAccount;

public class BankBalComparator implements Comparator<BankAccount> {

	public int compare(BankAccount o1, BankAccount o2) {
		if (o1.getAccBal()< o2.getAccBal())
			return 1;
		if (o1.getAccBal() > o2.getAccBal())
			return -1;
		return 0;
	}

}
