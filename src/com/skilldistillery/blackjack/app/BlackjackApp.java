package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	private Dealer dealer1 = new Dealer();
	private Player player1 = new Player();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.run();

	}

	private void run() {
		dealer1.prepDeck();
		dealTable();
		blackjack();

	}

	private void blackjack() {
		if (dealer1.checkForBlackjack(player1) && dealer1.checkForBlackjack(dealer1)) {
			System.out.println("Both Players got 21!");
			push();
		} else if (dealer1.checkForBlackjack(player1)) {
			System.out.println("Player got Blackjack!");
			playerWin();
		} else if (dealer1.checkForBlackjack(dealer1)) {
			System.out.println("Dealer got Blackjack!");
			dealerWin();
		} else {
			play();

		}
	}

	public void play() {
		int option = 0;
		int counter = 1;
		while (option != 3) {
			System.out.println();
			System.out.println("Player " + player1.getHand());
			System.out.println("      Value: " + player1.getHandValue());
			System.out.println("Make your choice.");
			System.out.println("Hit");
			System.out.println("Stand");
			System.out.println();
			option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				hitMe();
				counter++;
				System.out.println("Player dealt a " + player1.getCardFromHand(counter));
				if (dealer1.checkForBlackjack(player1)) {
					playerWin();
					option = 3;
					break;
				} else if (dealer1.checkForBust(player1)) {
					playerBust();
					option = 3;
					break;
				}
				break;
			case 2:
				System.out.println("Player:  'I Stand!'");
				option = 3;
				if (dealer1.getHandValue() >= 17 && dealer1.getHandValue() < 21) {
					results();
				} else {
					dealerTurn();
				}
				break;
			}
		}
	}

	public void dealTable() {
		System.out.println("Dealing...");
		System.out.println();
		dealer1.initializeHands(dealer1, player1);
		System.out.println("Player dealt: " + player1.getCardFromHand(0));
		System.out.println("Dealer dealt:[HIDDEN]");
		System.out.println("Player dealt: " + player1.getCardFromHand(1));
		System.out.println("Dealer dealt: " + dealer1.getCardFromHand(1));

	}

	public void hitMe() {
		dealer1.dealsCard(player1);
	}

	public void dealerTurn() {
		int counter = 2;
		while (dealer1.getHandValue() <= 16) {
			dealer1.dealsCard(dealer1);
			System.out.println("Dealer dealt a " + dealer1.getCardFromHand(counter));
			System.out.println("Dealer Current Value: " + dealer1.getHandValue());
			counter++;
			if (dealer1.checkForBust(dealer1)) {
				dealerBust();
				break;
			} else if (dealer1.checkForBlackjack(dealer1)) {
				dealerWin();
				break;
			} else if (dealer1.getHandValue() >= 17 && dealer1.getHandValue() < 21) {
				results();
			}
		}

	}

	private void results() {
		int playerHand = player1.getHandValue();
		int dealerHand = dealer1.getHandValue();
		if (playerHand == dealerHand) {
			push();
		} else {
			playerHand = 21 - playerHand;
			dealerHand = 21 - dealerHand;

			if (playerHand < dealerHand) {
				playerWin();
			} else {
				dealerWin();
			}
		}

	}

	public void playerBust() {
		System.out.println("Player BUSTED with " + player1.getHandValue());
		System.out.println("Dealer Wins!");
	}

	public void playerWin() {
		System.out.println("Dealer " + dealer1.getHand() + " Value: " + dealer1.getHandValue());
		System.out.println("Player " + player1.getHand() + " Value: " + player1.getHandValue());
		System.out.println("Player wins!");
	}

	public void dealerBust() {
		System.out.println("Dealer BUSTED with " + dealer1.getHandValue());
		System.out.println("Player Wins!");
	}

	public void dealerWin() {
		System.out.println("Results...");
		System.out.println("Dealer " + dealer1.getHand() + " Value: " + dealer1.getHandValue());
		System.out.println("Player " + player1.getHand() + " Value: " + player1.getHandValue());
		System.out.println("Dealer wins!");
	}

	public void push() {
		System.out.println("Dealer " + dealer1.getHand() + " Value: " + dealer1.getHandValue());
		System.out.println("Player " + player1.getHand() + " Value: " + player1.getHandValue());
		System.out.println("PUSH!");

	}

}