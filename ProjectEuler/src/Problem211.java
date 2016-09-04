import java.util.ArrayList;


public class Problem211 extends Thread {
public long ans = 0;
public long start ;
public long end ;
public static void main(String[] args) throws InterruptedException {
	ArrayList<Problem211> t = new ArrayList<Problem211>();
	int LIM=64000000;
	long ans = 0;
	int c= 0;
    for(long i=1;i<=LIM;i+=1000000){
    	Problem211 p = new Problem211(i, i+1000000);
		t.add(p);
		p.start();
    }
    for(Problem211 p:t){
		p.join();
	}
	for(Problem211 p:t){
	ans+=p.ans;
	System.out.println(p.ans);
	}
	System.out.println(ans);
}

public Problem211(long start,long end){
	//System.out.println(start + " " + end);
	this.start=start;
	this.end=end;
}
public void run(){
	
	for(long i=start;i<end;i++){
		long sum =1+i*i;
		for(long  j=2;j*j<=i;j++){
			if(i%j==0){
				sum+=j*j;
				if(j*j!=i){
					sum+=(i/j)*(i/j);
				}
			}
		}
		long  sq = (long) Math.sqrt(sum);
		if(sq*sq==sum){
		ans+=i;
		}
	}
	System.out.println(start + " " + end);
}

public static long divisorSum(ArrayList<Integer> factors,ArrayList<Integer> mutliples){
	long ans = 1;
	for(int i=0;i<factors.size();i++){
		long n = (long) (Math.pow(factors.get(i),(mutliples.get(i)+1)*2)-1);
		long d = (long) (Math.pow(factors.get(i),2)-1);
		ans*=(n/d);
	}
	return ans;
}
}
