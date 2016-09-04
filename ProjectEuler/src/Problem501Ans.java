import java.math.BigInteger;


public class Problem501Ans {
	
	public static void main(String[] args) {
		double[] a=new double[64_000_000];
		int x=1;
		for(int y=1;y<=64_000_000;y++){
		    for(int z=x;z<=64_000_000;z+=x){
		        a[z-1]+=Math.pow(x,2);
		    }
		    x++;
		}

		long ans=0;
		for(int b=1;b<=64_000_000;b++){
		if((Math.sqrt(a[b-1])- Math.floor(Math.sqrt(a[b-1])))==0.0){
		ans+=(long)b;
		 }}
		        System.out.println(ans);
	}
}
