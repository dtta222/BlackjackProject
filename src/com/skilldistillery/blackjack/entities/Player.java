package com.skilldistillery.blackjack.entities;

public class Player {
	
	protected Hand hand;
	
	
	
	public Player(){
		this.hand = new BlackjackHand();
	}
	

	public int getHandValue() {
		int value = 0;
		value = getHand().getHandValue();
		
		return value;
	}

	public Hand getHand() {
		return hand;
	}
	
	public Card getCardFromHand(int i) {
		Card getCard = hand.cards.get(i);
		return getCard;
	}

	
	
	
	
	
	
}