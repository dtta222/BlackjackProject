package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	// The Dealer class represents the dealer in a Blackjack game.

	// Default constructor
	public Dealer() {
	}

	// Calculates and returns the total value of the dealer's hand based on the card values.
	@Override
	public int getHandValue() {
		int totalValue = 0;
		for (Card card : cards) {
			totalValue += card.getValue();
		}
		return totalValue;
	}
}
