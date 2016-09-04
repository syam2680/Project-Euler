import java.util.ArrayList;


public class Problem381 extends Thread {
	public long start;
	public long max;
	
	public Problem381(long start,long max){
		this.start = start;
		this.max=max;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Problem381> threads = new ArrayList<Problem381>();
		
		SampleClass.genPrimes();
		 
		System.out.println("Generated Primes ");
		long lim = SampleClass.primes.size();
		int i=2;
		for(;i+10000<lim;i+=10000){
			Problem381 t=new Problem381(i,i+4);
			t.start();
			threads.add(t);
		}
		Problem381 tt=new Problem381(i,lim);
		tt.start();		
		threads.add(tt);
		for(Problem381 t:threads){
			t.join();
		}
		
		long ans =1;
		
		for(Long l:SampleClass.answers){
			ans+=l;
		}
		System.out.println(ans);
	}
    
	
	public void run(){
	    for(long i=start;i<max;i++){
	    	SampleClass.answers.add(SampleClass.fact(SampleClass.primes.get((int) i)));
	    }
	}
	


}
