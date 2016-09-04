import java.util.HashMap;


public class Problem566 {
	public static void main(String[] args) {

		HashMap<String,Boolean> angle = new HashMap<String, Boolean>();
		for(int i=1;i<360;i++){
			for(int j=0;j<1000;j++){
				String s = "" + i + j;
				angle.put(s, true);
			}
		}
		
		flip(angle,9,10,11);
	}
	
	public static void flip(HashMap<String,Boolean> angle,int a,int b,int c){
		
		String [] x= Double.toString((360/a)).split("\\.");
		String [] y= Double.toString(360/b).split("\\.");
		String [] z= Double.toString(360/Math.sqrt(c)).split("\\.");
		
		if(x[1].length()>3){
			x[1]=x[1].substring(0,3);
		}
		if(y[1].length()>3){
			y[1]=y[1].substring(0,3);
		}
		if(z[1].length()>3){
			z[1]=z[1].substring(0,3);
		}
        
		for(int i=1;i<Integer.parseInt(x[0]);i++){
			for(int j=0;j<1000;j++){
				String s = "" + i + j;
				angle.put(s, true);
			}
		}
		for(int j=0;j<=Integer.parseInt(x[1]);j++){
			String s = "" + Integer.parseInt(x[0]) + j;
			angle.put(s, true);
		}
		

	}
	
	
	

}
