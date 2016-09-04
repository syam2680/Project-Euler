package com.syam.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class PokerHand  {
    private ArrayList<Card> hand;
    private int rank;
    public HashMap<String,Integer> priority ;
    public TreeMap<Integer,Integer> rankedCards  ;
    public TreeMap<Integer,Integer> restOfTheCards  ;
    
	public PokerHand(ArrayList<Card> cards) {
		priority = new HashMap<String, Integer>();
		rankedCards = new TreeMap<Integer, Integer>();
		restOfTheCards = new TreeMap<Integer, Integer>();
		for(int i=2;i<=9;i++){
			priority.put(Integer.toString(i), 15-i);
		}
		priority.put("T",5);
		priority.put("J",4);
		priority.put("Q",3);
		priority.put("K",2);
		priority.put("A",1);
		this.hand = cards;
		if(!isRoyalFlush()){
			if(!isStraightFlush()){
				if(!isFourOfAKind()){
					if(!isFullHouse()){
						if(!isFlush()){
							if(!isStraight()){
								if(!isThreeOfAKind()){
									if(!isTwoPairs()){
										if(!isOnePair()){
											if(!isHighest()){
												rank=0;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	
	
	private boolean isRoyalFlush(){
		if(isSameSuit() &&search("T") && search("J") && search("Q") && search("K") && search("A")){
			rank=10;
			return true;
		}
		return false;
		
	}
	
	private boolean isStraightFlush(){
			if(isSameSuit()){
				if(
						search("1") && search("2") && search("3") && search("4") && search("5") ||
						search("2") && search("3") && search("4") && search("5") && search("6") ||
						search("6") && search("7") && search("3") && search("4") && search("5") ||
						search("6") && search("7") && search("8") && search("4") && search("5") ||
						search("6") && search("7") && search("8") && search("9") && search("5") ||
						search("6") && search("7") && search("8") && search("9") && search("T") ||
						search("J") && search("7") && search("8") && search("9") && search("T") ||
						search("J") && search("Q") && search("8") && search("9") && search("T") ||
						search("J") && search("Q") && search("K") && search("9") && search("T") ||
						search("J") && search("Q") && search("K") && search("A") && search("T") 
				   ){
					rank=9;
					for(Card c:hand){
						rankedCards.put(priority.get(c.getValue()), priority.get(c.getValue()));
					}
					return true;
				}
			}
			return false;
	}
	
	private boolean isFourOfAKind(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
			
			for(Card c:hand){
				hm.put(c.getValue(), hm.get(c.getValue())==null ? 1 :hm.get(c.getValue())+1 );
			}
			for(String k:hm.keySet()){
				if(hm.get(k)==4){
					rank=8;
					break;
				}
			}
		
		if(rank==8){
			for(Card c:hand){
				if(hm.get(c.getValue())==1){
					restOfTheCards.put(priority.get(c.getValue()),priority.get(c.getValue()));
				}
				if(hm.get(c.getValue())==4){
					rankedCards.put(priority.get(c.getValue()),priority.get(c.getValue()));
				}
			}
		return true;
		}
		return false;
	}
	
	private boolean isFullHouse(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(Card c:hand){
			hm.put(c.getValue(), hm.get(c.getValue())==null ? 1 :hm.get(c.getValue())+1 );
		}
		for(String k:hm.keySet()){
			if(hm.get(k)==3 || hm.get(k)==2){
				continue;
			}else{
				return false;
			}
		}
			rank=7;
			for(String k:hm.keySet()){
				if(hm.get(k)==3){
					rankedCards.put(priority.get(k),priority.get(k));
				}else{
					restOfTheCards.put(priority.get(k),priority.get(k));
				}
			}
			return true;
	}
		
	
	public ArrayList<Card> getHand() {
		return hand;
	}



	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}



	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	private boolean isFlush(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(Card c:hand){
			hm.put(c.getSuit(), hm.get(c.getSuit())==null ? 1 :hm.get(c.getSuit())+1 );
		}
		if(hm.size()==1){
			rank=6;
			for(Card c:hand){
				rankedCards.put(priority.get(c.getValue()), priority.get(c.getValue()));
			}
			return true;
		}
		return false;
	}
	
	
	private boolean isStraight(){
			if(
					search("1") && search("2") && search("3") && search("4") && search("5") ||
					search("2") && search("3") && search("4") && search("5") && search("6") ||
					search("6") && search("7") && search("3") && search("4") && search("5") ||
					search("6") && search("7") && search("8") && search("4") && search("5") ||
					search("6") && search("7") && search("8") && search("9") && search("5") ||
					search("6") && search("7") && search("8") && search("9") && search("T") ||
					search("J") && search("7") && search("8") && search("9") && search("T") ||
					search("J") && search("Q") && search("8") && search("9") && search("T") ||
					search("J") && search("Q") && search("K") && search("9") && search("T") ||
					search("J") && search("Q") && search("K") && search("A") && search("T") 
			   ){
				rank=5;
				for(Card c:hand){
					rankedCards.put(priority.get(c.getValue()), priority.get(c.getValue()));
				}         
				return true;
			}
		return false;
	}

	private boolean isThreeOfAKind(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(Card c:hand){
			hm.put(c.getValue(), hm.get(c.getValue())==null ? 1 :hm.get(c.getValue())+1 );
		}
		for(String k:hm.keySet()){
			if(hm.get(k)==3){
				rank=4;
				rankedCards.put(priority.get(k), priority.get(k));
			}else{
				continue;
			}
		}
		
		if(rank==4){
			for(String k:hm.keySet()){
				if(hm.get(k)!=3){
					restOfTheCards.put(priority.get(k),priority.get(k));
				}
			}
			return true;
		}
		
		return false;	
	}
	
	private boolean isTwoPairs(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(Card c:hand){
			hm.put(c.getValue(), hm.get(c.getValue())==null ? 1 :hm.get(c.getValue())+1 );
		}
		int c =0;
		for(String k:hm.keySet()){
			if(hm.get(k)==2){
				c++;
			}
		}
		if(c==2){
			for(String k:hm.keySet()){
				if(hm.get(k)==2){
					rankedCards.put(priority.get(k),priority.get(k));
				}else{
					restOfTheCards.put(priority.get(k), priority.get(k));
				}
			}
			rank=3;
			return true;
		}
		return false;
	}
	
	private boolean isOnePair(){
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		for(Card c:hand){
			hm.put(c.getValue(), hm.get(c.getValue())==null ? 1 :hm.get(c.getValue())+1 );
		}
		for(String k:hm.keySet()){
			if(hm.get(k)==2 ){
				rankedCards.put(priority.get(k),priority.get(k));
				rank=2;
			}
		}
		if(rank==2){
			for(String k:hm.keySet()){
				if(hm.get(k)!=2 ){
					restOfTheCards.put(priority.get(k),priority.get(k));
				}
			}
			return true;
		}
	return false;
	}
	
	private boolean isHighest(){
		for(Card c:hand){
			rankedCards.put(priority.get(c.getValue()), priority.get(c.getValue()));
		}
		rank=1;
		return true;
	}
	
	
	private boolean search(String s){
		for(Card c:hand){
			if(c.getValue().equalsIgnoreCase(s)){
				return true;
			}
		}
		return false;
	}

	private boolean isSameSuit(){
		for(int i=0;i<hand.size()-1;i++){
			if(hand.get(i).getSuit().equalsIgnoreCase(hand.get(i+1).getSuit())){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}    
}
