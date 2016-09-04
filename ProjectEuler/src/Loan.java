
public class Loan {
	private int loanAmount;
	private int returnAmount;
	private int validity;
	public Loan(int loanAmount, int validity,int returnAmount) {
		super();
		this.loanAmount =loanAmount;
		this.validity = validity;
		this.returnAmount = returnAmount;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public int getReturnAmount() {
		return returnAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public void setReturnAmount(int returnAmount) {
		this.returnAmount = returnAmount;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public int getAmount() {
		return loanAmount;
	}
	public int getValidity() {
		return validity;
	}

}
