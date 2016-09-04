import java.math.BigInteger;

public class Fraction {
	BigInteger numerator;
	BigInteger denominator;

	public Fraction(BigInteger numerator2, BigInteger denominator2) {
		numerator = numerator2;
		denominator = denominator2;

	}

	public static void main(String[] args) {
		Fraction f1 = new Fraction(new BigInteger("3"), new BigInteger("4"));
		Fraction f2 = new Fraction(new BigInteger("1"), new BigInteger("2"));
		System.out.println(f1.add(f1, f2));
	}

	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	public Fraction add(Fraction f1, Fraction f2) {
		f1 = reduce(f1);
		f2 = reduce(f2);
		BigInteger lcm = LCM(f1.denominator, f2.denominator);
		BigInteger numerator = (f1.numerator.multiply(lcm)).divide(
				f1.denominator).add(
				(f2.numerator.multiply(lcm)).divide(f2.denominator));
		return reduce(new Fraction(numerator, lcm));
	}

	public Fraction divide(Fraction f1, Fraction f2) {
		f1 = reduce(f1);
		f2 = reduce(f2);
		BigInteger numerator = f1.numerator.multiply(f2.denominator);
		BigInteger denominator = f1.denominator.multiply(f2.numerator);
		return reduce(new Fraction(numerator, denominator));
	}

	public Fraction reduce(Fraction f1) {
		BigInteger gcd = f1.numerator.gcd(f1.denominator);
		f1.numerator = f1.numerator.divide(gcd);
		f1.denominator = f1.denominator.divide(gcd);
		return new Fraction(f1.numerator, f1.denominator);
	}

	public BigInteger LCM(BigInteger denominator2, BigInteger denominator3) {
		return (denominator2.multiply(denominator3)).divide(denominator2
				.gcd(denominator3));
	}
}
