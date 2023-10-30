package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	protected List<Card> cards;
	protected Dealer dealer;

	public Deck() {
		cards = createDeck();
		shuffle();

	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void dealCard(Hand hand){

	}

	public void stand() {

	}

	public Card hit() {
		return dealCard();
	}

}
