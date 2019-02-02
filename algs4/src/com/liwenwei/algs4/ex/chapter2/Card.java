package com.liwenwei.algs4.ex.chapter2;

/**
 * Deck card
 * 
 * @author liwenwei
 *
 */
public class Card {

	public enum Suit {
		Spades,
		Hearts,
		Clubs,
		Diamonds
	}
	
	private Suit suit;
	
	private int value;
	
	public Suit getSuit() {
		return suit;
	}
	
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
