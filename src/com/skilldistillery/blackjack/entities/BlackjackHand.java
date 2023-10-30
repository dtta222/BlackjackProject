package com.skilldistillery.blackjack.entities;


public class BlackjackHand extends Hand {
	
	
	
	public BlackjackHand() {
	}
	
	
	public int getHandValue() {
		int num = 0;
		
		for (Card card : cards) {
			num += card.getValue();
		}
		
		return num;
		
	}
	
	public boolean isBlackjack() {
		int blackjack = 0;
		blackjack = getHandValue();
		if (blackjack == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		int bust = 0;
		bust = getHandValue();
		if (bust > 21) {
			return true;
		}
		return false;
	}
	


	@Override
	public String toString() {
		return "Hand: " + cards;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}