
public class Problem78 {
  public static void main(String[] args) {
	System.out.println(p(5,5));
}
	
	public static int p(int n,int m){
		int ans = 0;
		for(int i=1;i<=m;i++){
			ans+=p(n-i,i);
		}
		return ans;
	}
}
