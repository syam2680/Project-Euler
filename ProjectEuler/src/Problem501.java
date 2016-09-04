import java.util.ArrayList;
import java.util.HashMap;


public class Problem501 extends Thread {
	public long start ;
	public long end ;
	public long ans = 0;
	public Problem501(long s,long e){
		//System.out.println(s + " " + e);
		start=s;
		end=e;
	}
	
	public long fact( long n){
		long  ans = 0;
		long  temp = 1;
		for(long t=1;t<=n;t++){
			temp*=t;
			temp%=n;
			if(n-t<=5)	{
				ans+=temp;
				ans%=n;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Problem501> t = new ArrayList<Problem501>();
		for(long i=1;i<1000000L;i+=100000){
			Problem501 p = new Problem501(i, i+100000);
			t.add(p);
			p.start();

		}
		for(Problem501 p:t){
			p.join();
		}
		
		long ans =0;
		for(Problem501 p:t){
		ans+=p.ans;
		}
		System.out.println(ans);
		
	}
	public void run(){
		for(long i=start;i<end;i++){
			int c=0;
			for(long j=2;j*j<=i;j++){
				if(i%j==0){
					c++;
					break;
				}
			}
			if(c==0){
				ans+=fact(i);
			}
		}
	}
}
