import java.util.ArrayList;
import java.util.Iterator;

public class FInance {
	public static void main(String[] args) {
		int initalInvestment = 300000;
		int bankDeposit = 15000;
		int loanTerm = 100;
		int balanceAmount = 0;
		int bankBalance = 0;
		int paymentPerDay = 1000;
		int rotationAmount = initalInvestment;
		int days = 0;
		int returnAmount = 0;
		ArrayList<Loan> loans = new ArrayList<Loan>();
		System.out
				.println("Number of Loans \t Rotation Amount \t Current Outstanding \t Bank Deposit \t Week ");
		while (days <= 365) {
			if (days % 7 == 0)
				System.out
						.println(loans.size() + "\t" + rotationAmount + "\t"
								+ returnAmount + "\t" + bankBalance + "\t"
								+ (days / 7));
			returnAmount = 0;
			while (rotationAmount / 100000 > 0 && days % 7 == 0) {
				Loan l = new Loan(85000, 100, 100000);
				rotationAmount -= 100000;
				bankBalance += 15000;
				loans.add(l);
			}
			Iterator<Loan> iter = loans.iterator();
			while (iter.hasNext()) {
				Loan l = iter.next();
				if (l.getValidity() <= 0) {
					iter.remove();
					continue;
				}
				l.setReturnAmount(l.getReturnAmount() - 1000);
				returnAmount += l.getReturnAmount();
				l.setValidity(l.getValidity() - 1);
				rotationAmount += 1000;
			}
			days++;
		}

	}
}
