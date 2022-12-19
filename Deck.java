package warCardGame;

import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int currentCard;

// creates a deck of cards
public Deck() {
	this.cards = new Card [52];
	int index = 0;
	for (int suit = 0; suit<=3; suit++) {
		for (int name=1; name<=13; name++) {
			this.cards[index] = new Card (name, suit);
			index++;
		}
		
	}
}
// gets the cards array
public Card[] getCards() {
	return this.cards;
}
//shuffling the deck	
public void shuffle() 
	{
		for (int i=cards.length-1; i>0; i--) {
			int rand = (int)(Math.random() * i+1);
			Card temp = cards[i];
			cards[i] = cards[rand];
			cards[rand]= temp;
		}
		currentCard=0;
	}
// deals the cards to two players
public void deal (Player player1, Player player2) {
	int count = 0;
	for (Card card : cards) {
		if (count>26) {
			player1.playCards[count%13] = card;
		}
		else if (count<26) {
			player2.playCards[count%13] = card;
		}count++;
	}
}

public void print () {
	for (int i = 0; i<this.cards.length; i++) {
		System.out.println(this.cards[i]);
	}
} 
	}