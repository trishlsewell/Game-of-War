package warCardGame;

public class Player {
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_RESET = "\u001B[0m";
public int score;
String name;
static int playerOneScore = 0;
static int playerTwoScore = 0;
Card[] playCards = new Card[13];

//creates a new player
public Player (String name) {
	this.name = name;
	}
//shows the cards in each players hand
public void ShowPlayerCards() {
	System.out.println("---------------------------------------------------------------");
	for (Card card:playCards) {
		if (card!=null)
			System.out.println(card.describe());
	}System.out.println("---------------------------------------------------------------");
}public String getName() {
	return name;
}
//plays a round of war & initiates the printRoundResults method each time a round is played.
 public static void flip (Card[] deck1, Card[] deck2) {
	
	//create a new discard pile for played cards
	Card[] pile = new Card [52];
	//start playing with the first card of each players deck
	Card playerOneCard = deck1[0];
	Card playerTwoCard = deck2[0];
	//play top card
	removeTopCard(deck1);
	addCardToBottom(pile,playerOneCard);
	removeTopCard(deck2);
	addCardToBottom(pile,playerTwoCard);

int comparison = score (playerOneCard, playerTwoCard);
printRoundResults(playerOneCard, playerTwoCard);
if (comparison > 0) {
	while (hasCards(pile)) {
		addCardToBottom(deck1, pile[0]);
		removeTopCard(pile);
	}
	
	}
	else if (comparison <0) {
			while (hasCards(pile)) {
			addCardToBottom(deck2,pile[0]);
			removeTopCard(pile);
		}
	}
}
//prints the results of each round of war
private static void printRoundResults (Card playerOneCard, Card playerTwoCard) {
	
	System.out.println("Player 1 plays " + playerOneCard.describe());
	System.out.println("Player 2 plays " + playerTwoCard.describe());
	int comparison = score (playerOneCard, playerTwoCard);
	if (comparison==0) {
		System.out.println("This is a tie");}
	else if (comparison >0) { 
		playerOneScore++; {
	}
		System.out.println("Player one wins this round!");}
	else {
		playerTwoScore++;{
		System.out.println("Player two wins this round!");
		}
	}System.out.println(ANSI_RED + "Player one's score: " + playerOneScore + " Player two's score: " + playerTwoScore +"\n" + ANSI_RESET);
}
//places card at the bottom of players deck after it has been played
private static void addCardToBottom (Card[] deck, Card newCard) {
	for (int i=0; i<deck.length; i++) {
		if (deck[i] == null) {
			deck[i] = newCard;
			return;}
		}
}
//removes the card from the top of the deck
private static void removeTopCard (Card[] deck) {
	for (int i=0; i<deck.length -1; i++) {
		deck[i] = deck[i+1];
	}
}
//determines who wins each round
private static int score (Card card1, Card card2) {
	
	int playerOneNumber = card1.compareTo(card2);
	int playerTwoNumber = card2.compareTo(card1);
	
	
	if (playerOneNumber == playerTwoNumber) {
		return 0;}
	if (playerTwoNumber <playerOneNumber) {
		
		
	return 1;}
if (playerTwoNumber >playerOneNumber) {
	
	return -1;}


return 1;
}

//determines whether or not each player has cards in their deck (not used right now)
public static boolean hasCards (Card[] deck) {
	for (int i=0; i<deck.length; i++) {
		if (deck[i] !=null) {
			return true;
			
		}
	}
	return false;

}
}


