package warCardGame;

public class Card {
	private int name;
	private int suit;
	
	//creates an array for suits and names/values of cards
	public static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};	
	public static String[] names = {null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	

public String describe() {
	
	return names[this.name] + " of " + suits[this.suit];
}
	
// create a card	
public Card (int name, int suit) {
	this.name = name;
	this.suit = suit;
	}

public int getName() {
	return name;
}

public void setName(int name) {
	this.name = name;
}

public int getSuit() {
	return suit;
}

public void setSuit(int suit) {
	this.suit = suit;
}

//Displays the populated deck of cards
public static void printDeck (Card[] cards) {
for (int i=0; i<cards.length; i++) {
	System.out.println(cards[i]);
}
}
//compares two cards that are played against each other 
public int compareTo (Card that) {
	if (this.name<that.name) {
		return -1;
	}
	if (this.name > that.name) {
		return 1;}

		return 0;
}

}

