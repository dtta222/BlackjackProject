package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner scanner = new Scanner(System.in);
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private Deck deck = new Deck();
	private BlackjackHand blackjackHand = new BlackjackHand();

	public static void main(String[] args) {
		BlackjackApp blackjackApp = new BlackjackApp();
		blackjackApp.run();
	}

	// Main game logic
	public void run() {
		initialDeal();

		// Check for player's Blackjack
		if (blackjackHand.isBlackjack(player.getHandValue())) {
			displayResult("\nPlayer has a blackjack. Player wins!");
			displayStatus();
			return;
		}

		// Player's turn
		playerTurn();

		// Proceed with the dealer's turn if the player hasn't busted
		if (!blackjackHand.isBust(player.getHandValue())) {
			dealerTurn();
		}

		// Determine the winner of the game
		determineWinner();
	}

	// Initial deal of cards to player and dealer
	private void initialDeal() {
		player.addCard(deck.dealCard());
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
	}

	// Player's turn to hit or stand
	private void playerTurn() {
		while (true) {
			displayStatus();
			String choice = getUserChoice("\nHIT or STAND: ");
			if ("HIT".equalsIgnoreCase(choice)) {
				player.addCard(deck.hit());
			} else if ("STAND".equalsIgnoreCase(choice)) {
				break;
			}
			if (blackjackHand.isBust(player.getHandValue())) {
				displayResult("\nPlayer went over 21. Dealer wins!");
				return;
			}
		}
	}

	// Dealer's turn to hit until their hand value is 17 or more
	private void dealerTurn() {
		while (dealer.getHandValue() < 17) {
			dealer.addCard(deck.hit());
		}
	}

	// Determine and display the game result
	private void determineWinner() {
		displayStatus();
		if (blackjackHand.isBust(player.getHandValue())) {
			displayResult("\nDealer wins!");
		} else if (blackjackHand.isBust(dealer.getHandValue())) {
			displayResult("\nPlayer wins!");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			displayResult("\nPlayer wins!");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			displayResult("\nDealer wins!");
		} else {
			displayResult("\nIt's a tie!");
		}
	}

	// Display the current status of player and dealer hands
	private void displayStatus() {
		System.out.println("Player:");
		player.displayCards();
		System.out.println("\tScore: " + player.getHandValue());
		System.out.println("\nDealer:");
		dealer.displayCards();
		System.out.println("\tScore: " + dealer.getHandValue());
	}

	// Get user's choice (HIT or STAND)
	private String getUserChoice(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine();
	}

	// Display the game result
	private void displayResult(String result) {
		System.out.println(result);
	}
}
