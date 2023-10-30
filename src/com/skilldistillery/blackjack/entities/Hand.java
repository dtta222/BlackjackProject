package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;
	protected Deck deck;

	public Hand(){
		cards = new ArrayList<>();
	}

	public void addCard(Card card){
		cards.add(card);
	}

	public void clear(){

	}

	public void displayCards() {
		for (Card card : cards){
			System.out.println("\t"+card);
		}
	}


	public abstract int getHandValue();


	public String toString(){
		return null;
	}
}
