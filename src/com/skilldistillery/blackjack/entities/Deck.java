package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>(52);

		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (Rank rank : ranks) {
			for (Suit suit : suits) {
				Card aCard = new Card(suit, rank);
				deck.add(aCard);
			}
		}

	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		return deck.remove(0);

	}
	

	public void shuffle() {
		Collections.shuffle(deck);
	}

}