package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
		
	}
	
	public void addCard(Card aCard) {
		cards.add(aCard);
	}
	
	public void clear() {
		
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		return Objects.equals(cards, other.cards);
	}
	
	
	
	
}