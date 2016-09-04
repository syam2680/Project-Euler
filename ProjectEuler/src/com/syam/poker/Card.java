package com.syam.poker;

public class Card implements Comparable<Card> {
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	private String value ;
	private String suit ;
	@Override
	public int compareTo(Card arg0) {
		return this.value.compareTo(arg0.value);
	}
	public Card(String value, String suit) {
		super();
		this.value = value;
		this.suit = suit;
	}
}
