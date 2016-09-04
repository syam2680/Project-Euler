import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeMap;

public class Problem66 {
	public static void main(String[] args) {
        long startTime = System.nanoTime();
		TreeMap<BigInteger, Integer> tm = new TreeMap<BigInteger, Integer>();
		for (int i = 2; i <= 1000; i++) {
			Fraction f5 = null;
			int k = (int) Math.sqrt(i);
			if (k * k != i) {
				ArrayList<Integer> fractions = cfe(i);
				Fraction f1;
				f1 = new Fraction(new BigInteger("1"), new BigInteger(
						Integer.toString(fractions.get(fractions.size() - 2))));
				Fraction f2 = new Fraction(new BigInteger("1"), new BigInteger(
						"1"));
				Fraction f3 = f1.divide(f1, f2);
				for (int ii = fractions.size() - 3; ii >= 0; ii--) {
					Fraction f4 = new Fraction(new BigInteger(
							Integer.toString(fractions.get(ii))),
							new BigInteger("1"));
					f5 = f4.add(f4, f3);
					f3 = f5.divide(f2, f5);
					if (f5.numerator
							.multiply(f5.numerator)
							.subtract(
									f5.denominator.multiply(f5.denominator)
											.multiply(
													new BigInteger(Integer
															.toString(i))))
							.compareTo(BigInteger.ONE) == 0) {
						 System.out.println(f5 + " " + i);
						tm.put(f5.numerator, i);
						break;
					}
				}

			}
		}
		long endTime = System.nanoTime();
		double timeTaken = (endTime-startTime)/1000000;
		System.out.println(tm.lastEntry());
		System.out.println("Time Taken "+timeTaken);
       
	}

	public static ArrayList<Integer> cfe(int S) {
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		m.add(0);
		d.add(1);
		a.add((int) Math.floor(Math.sqrt(S)));
		int n = 0;
		int count = 0;
		while (count < 2) {
			m.add(d.get(n) * a.get(n) - m.get(n));
			d.add((S - m.get(n + 1) * m.get(n + 1)) / d.get(n));
			a.add((int) Math.floor((a.get(0) + m.get(n + 1)) / d.get(n + 1)));
			n++;
			if (a.get(a.size() - 1) == 2 * a.get(0)) {
				if ((a.size() - 1) % 2 == 0) {
					count = 2;
				} else {
					count++;
				}
			}
		}
		return a;
	}
}
