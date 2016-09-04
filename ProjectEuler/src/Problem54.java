import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.syam.poker.Card;
import com.syam.poker.PokerHand;



public class Problem54 {
public static void main(String[] args) throws IOException {
	File f = new File("/Users/syamk/Desktop/p054_poker.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	int ans=0;
	String inp = br.readLine();
	while(inp!=null){
	//System.out.println(inp.substring(0,14));
	//System.out.println(inp.substring(15));
	String [] s1 = inp.substring(0,14).split(" ");
	String [] s2 = inp.substring(15).split(" ");
	ArrayList<Card> c1 = new ArrayList<Card>();
	ArrayList<Card> c2 = new ArrayList<Card>();
	for(String s:s1){
		Card c = new Card(s.substring(0,1),s.substring(1));
		//System.out.println(c.getValue() + " " + c.getSuit());
		c1.add(c);
	}
	for(String s:s2){
		Card c = new Card(s.substring(0,1),s.substring(1));
		//System.out.println(c.getValue() + " " + c.getSuit());
		c2.add(c);
	}
	PokerHand h1 = new PokerHand(c1);
	PokerHand h2 = new PokerHand(c2);
	boolean found = false;
	//System.out.println(h1.getRank() + " " + h2.getRank());
	if(h1.getRank()>h2.getRank()){
		System.out.println("HAND 1");
		ans++;
	}else if(h1.getRank()==h2.getRank()){
		ArrayList<Integer> hs1 =new ArrayList<Integer> (h1.rankedCards.values());
		ArrayList<Integer> hs2 =new ArrayList<Integer> (h2.rankedCards.values());
		ArrayList<Integer> hr1 =new ArrayList<Integer> (h1.restOfTheCards.values());
		ArrayList<Integer> hr2 =new ArrayList<Integer> (h2.restOfTheCards.values());
		
		for(int i=0;i<hs1.size();i++){
			//System.out.println(hs1.get(i) + " " + hs2.get(i));
			if(hs1.get(i) < hs2.get(i) ){
				System.out.println("HAND 1");
				ans++;
				found=true;
				break;
			}else if(hs1.get(i) > hs2.get(i)){
				
				System.out.println("HAND 2");
				found=true;
				break;
			}
		}
		if(!found){
		for(int i=0;i<hr1.size();i++){
			//System.out.println(hr1.get(i) + " " + hr2.get(i));
			if(hr1.get(i) < hr2.get(i) ){
				System.out.println("HAND 1");
				ans++;
				break;
			}else if(hr1.get(i) > hr2.get(i)  ){
				System.out.println("HAND 2");
				break;
			}
		}
		}
	}else{
		System.out.println("HAND 2");
	}
	inp = br.readLine();
}
	System.out.println(ans);
}
}
