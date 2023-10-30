package com.skilldistillery.blackjack.entities;

public class Player extends Hand {
	// You can add additional player-specific attributes here.

	// Constructor for creating a player object.
	public Player() {
		// Perform any player-specific initialization here, if needed.
	}

	// Calculates and returns the total value of the player's hand based on the card values.
	@Override
	public int getHandValue() {
		int totalValue = 0;
		for (Card card : cards) {
			totalValue += card.getValue();
		}
		return totalValue;
	}
}
