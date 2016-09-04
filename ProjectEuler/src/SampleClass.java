import java.util.ArrayList;


public class SampleClass {
	public static volatile ArrayList<Long> primes = new ArrayList<Long>();
	public static volatile ArrayList<Long> answers = new ArrayList<Long>();
    public static int lim =100000000;
	public static void genPrimes(){
		primes.add(2L);
		primes.add(3L);
		primes.add(5L);
		primes.add(7L);
		for(long i=9;i<=lim;i++){
			long j=0;
			long dc=0;
			long temp=(long)Math.sqrt(i);
			while(primes.get((int) j)<=temp){
				if(i%primes.get((int) j)==0){
					dc++;
					break;
				}
				j++;
			}
			if(dc==0){
				primes.add(i);
			}
		}
		
	}
	   public static long fact( long n){
		   long  ans = 0;
		   
		  // System.out.println(n);
			
			long  temp = 1;
			for( long t=1;t<=n;t++){
				temp*=t;
				temp%=n;
				if(n-t<=5)	{
					ans+=temp;
					ans%=n;
				}
			}
		   
			return ans;
		}
}
