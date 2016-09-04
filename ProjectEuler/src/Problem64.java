import java.util.ArrayList;


public class Problem64 {
	public static void main(String[] args) {
		int ans=0;
		System.out.println(cfe(85));
		/*
		for(int i=2;i<=10000;i++){
			int k=(int) Math.sqrt(i);
			if(k*k!=i){
				int si = cfe(i) ;
				if(si%2==1){
					//System.out.println(i + " " + si);
					ans++;
				}
			}
		}*/
		//System.out.println("ANS : " + ans);
		
	}
	
	public static int cfe(int S){
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		m.add(0) ;
		d.add(1);
		a.add((int) Math.floor(Math.sqrt(S)));
		int n=0;
		while(a.get(a.size()-1) != 2* a.get(0) ){
			m.add(d.get(n)*a.get(n)-m.get(n));
			d.add((S-m.get(n+1)*m.get(n+1))/d.get(n));
			a.add((int) Math.floor((a.get(0)+m.get(n+1))/d.get(n+1)));
			System.out.println(a.get(n));
			n++;
		}
		System.out.println(a.get(n));
		return a.size()-1;
	}

}
