import java.math.BigDecimal;
import java.util.Random;

public class Problem205_DiceGame {
	public static void main(String[] args) {
		int iter = 10;
		while (iter-- > 0) {
			long petewon = 0;
			long total = 0;
			for (long i = 0; i < 1000000000000000L; i++) {
				Random r = new Random();
				total++;
				int[] peteValues = { 1, 2, 3, 4 };
				int[] colinValues = { 1, 2, 3, 4, 5, 6 };
				int peteSum = 0;
				int colinSum = 0;
				for (int j = 0; j < 9; j++) {
					int pete = r.nextInt(4);
					peteSum += peteValues[pete];
				}
				for (int j = 0; j < 6; j++) {
					int colin = r.nextInt(6);
					colinSum += colinValues[colin];
				}
				if (peteSum > colinSum) {
					petewon++;
				}
			}
			BigDecimal nr = new BigDecimal(petewon);
			BigDecimal dr = new BigDecimal(total);
			System.out.println(nr.divide(dr));
		}
	}
}
