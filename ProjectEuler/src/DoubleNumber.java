
public class DoubleNumber {
	int intPart ;
	int DecimalPart;
	public DoubleNumber(int a,int b){
		intPart = a;
		DecimalPart =  b;
	}
	
	public boolean equals(DoubleNumber obj) {
		return this.intPart==obj.intPart && this.DecimalPart==obj.DecimalPart;
	}
	
}
