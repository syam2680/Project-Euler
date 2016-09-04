import java.util.HashMap;



public class Problem108_1 {
public static void main(String[] args) {
	HashMap<Long,Integer> solutions = new HashMap<Long,Integer> ();
	for(long i=2;i<1000000;i++){
		for(long j=i;j<1000000;j++){
			double nr = i*j;
			double dr= i+j;
			long n = (long) (nr/dr);
			if(n == (nr/dr)){
				//System.out.println(i + " " + j + " Sol " + n);
				solutions.put(n, solutions.get(n)  == null ?  0+1 : solutions.get(n)+1);
			}
		}
	}
	for(Long i:solutions.keySet()){
		if(solutions.get(i)>100)
		System.out.println(i + "  " + solutions.get(i));
	}
}
}
