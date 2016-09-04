import javax.sound.midi.Soundbank;


public class Problem108 {
	public static void main(String[] args) {
		long n=1;
		int solutions=0;
		long ans=0;
		while(solutions<=10){
			n++;
			int tempSol =0;
			
			for(long x=n+1,y=x;;x++){
				if(n*(x+y)<x*y){
					//System.out.println(x + " " + y + " Break " + n);
					break;
				}
				for(;;y++){
					//System.out.println(n + " " + n*(x+y) + " " + x*y);
					if(n*(x+y)<x*y){
						break;
					}
					if(n*(x+y)==x*y){
						System.out.println(x + " " + y + " " + n);
						tempSol++;
					}	
				}
				y=x;
				if(solutions<tempSol){
					solutions = tempSol;
					ans=n;
					System.out.println(ans + " " + solutions);
				}
			}
		}
	}

}
