import java.util.Arrays;

public class Problem68 {
	static int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static boolean[] used = new boolean[10];
	static int[] data = new int[10];
	static int[][] indexes = { { 0, 1, 2 }, { 1, 6, 7 }, { 5, 4, 3 },
			{ 4, 2, 8 }, { 6, 5, 9 } };

	public static void main(String[] args) {
		
		Problem68.printSol();
	}
    public static void printSol(){
    	for(int [] arr : indexes){
    		for(int t:arr){
    			System.out.print(data[t] + " ");
    		}
    		System.out.println();
    	}
    }
    
    



	public static boolean check() {
		for (int i = 1; i <= 4; i++) {
			if (data[indexes[0][0]] + data[indexes[0][1]] + data[indexes[0][2]] == data[indexes[i][0]]
					+ data[indexes[i][1]] + data[indexes[i][2]]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
