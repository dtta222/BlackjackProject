package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {
    // The BlackjackHand class represents a hand in a Blackjack game.

    // The value representing Blackjack
    private final int BLACKJACK = 21;

    // Default constructor for creating a Blackjack hand.
    public BlackjackHand() {
    }

    @Override
    public int getHandValue() {
        return 0;
    }

    // Checks if a hand's points equal the max Blackjack score.
    public boolean isBlackjack(int points) {
        return points == BLACKJACK;
    }

    // Checks if a hand's points exceed the max Blackjack score.
    public boolean isBust(int points) {
        return points > BLACKJACK;
    }
}
