package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		this.hand = new BlackjackHand();
	}

	public void prepDeck() {
		deck = new Deck();
		deck.shuffle();

	}

	public void initializeHands(Dealer d1, Player p1) {

		for (int i = 0; i < 2; i++) {
			p1.hand.addCard(deck.dealCard());
			d1.hand.addCard(deck.dealCard());

		}

	}

	public void dealsCard(Player player) {
		player.hand.addCard(deck.dealCard());
	}


	public boolean checkForBust(Player player) {

		return ((BlackjackHand) player.hand).isBust();
	}

	public boolean checkForBlackjack(Player player) {
		return ((BlackjackHand) player.hand).isBlackjack();
	}

}