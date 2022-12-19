package warCardGame;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {


//Instantiate a new deck of cards
Deck deck1 = new Deck();
//shuffle the deck of cards
deck1.shuffle();
//ask player to input the name of player 1
Scanner input = new Scanner (System.in);
System.out.println("Player One ....\n Enter Name: ");
Player player1 = new Player (input.nextLine());
// ask player to input the name of player 2
System.out.println("Player Two....\n Enter Name: ");
Player player2 = new Player (input.nextLine());
//deal cards to player 1 & player 2
deck1.deal(player1, player2);
//print out the cards in each players hand
System.out.println("---------------------------------------------------------------");
System.out.println(player1.getName());
player1.ShowPlayerCards();
System.out.println(player2.getName());
player2.ShowPlayerCards();
//initiates the game of war
for (int i=0; i<13; i++) {
Player.flip(player1.playCards, player2.playCards);

}
if (Player.playerOneScore >Player.playerTwoScore) {
	System.out.println("Congratulations - player one wins this game!");}
else if (Player.playerTwoScore>Player.playerOneScore) {
	System.out.println("Congratulations - player two wins this game!");}
else {
	System.out.println("This game is a tie!");
}
	
}

}
	
	
	

