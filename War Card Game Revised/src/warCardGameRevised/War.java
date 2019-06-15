package warCardGameRevised;

import java.util.ArrayList;
import java.util.Collections;

public class War {
	private ArrayList<Card> p1, p2, tempP1, tempP2;
	private Deck d1;
	private int numRounds=0;

	public War() {
		// creates the shuffled deck of cards
		d1 = new Deck();
		d1.createShuffledDeck();

		// distribute the deck of cards amongst the two players
		p1 = new ArrayList<Card>();
		p2 = new ArrayList<Card>();
		for (int i = 0; i < 26; i++) {
			p1.add(d1.dealOneCard());
			p2.add(d1.dealOneCard());
		}

		// prints out the cards in player 1 and 2
		System.out.println(p1);
		System.out.println(p2);

	}

	// moves all the cards of the previous rounds to the winning player
	public void moveCards(ArrayList<Card> uno, ArrayList<Card> dos, ArrayList<Card> target, String winner) {
		while (uno.size() != 0) {
			target.add(uno.remove(0));
			target.add(dos.remove(0));
		}
		System.out.println(winner + " won this round");
	}

	// if the cards being compared have the same rank
	public void equal(ArrayList<Card> uno, ArrayList<Card> dos, ArrayList<Card> tempUno, ArrayList<Card> tempDos) {
		System.out.println("Both cards are equal.....Time for war\n");
			if(uno.size()>=3 && dos.size()>=3) {
			for (int i = 0; i < 2; i++) {
				tempUno.add(uno.remove(0));
				tempDos.add(dos.remove(0));
			}
			Collections.shuffle(tempUno);
			Collections.shuffle(tempDos);
			}
			else {
				if(uno.size()<3) {
					System.out.println("Player 1 does not have enough cards for war\nPlayer 2 wins the war card game");
				}
				else {
					System.out.println("Player 2 does not have enough cards for war\nPlayer 1 wins the war card game");
				}
			}
	}

	public void Stats(ArrayList<Card> Uno, ArrayList<Card> Dos) {
		System.out.println("Player 1: " + Uno.size() + " cards");
		System.out.println("Player 2: " + Dos.size() + " cards\n");
	}

	public void IncNumRounds(int a) {
		System.out.println("Number of rounds: " + a);
	}

	public void End(ArrayList<Card> Uno, ArrayList<Card> Dos) {
		if (Uno.size() <3) {
			System.out.println("Player 2 won the game of war");
		} else{
			System.out.println("Player 1 won the game of war");
		}
	}

	public void Play() {
		// intitializing temporary arraylist
		tempP1 = new ArrayList<Card>();
		tempP2 = new ArrayList<Card>();

		

		while (p1.size() >3 && p1.size() >3) {
			tempP1.add(p1.remove(0));
			tempP2.add(p2.remove(0));

			// if Card 1 > Card 2
			if (tempP1.get(0).getRankValue() > tempP2.get(0).getRankValue()) {
				moveCards(tempP1, tempP2, p1, "Player 1");
				Stats(p1, p2);
				
				// if Card 1 < Card 2
			} else if (tempP1.get(0).getRankValue() < tempP2.get(0).getRankValue()) {
				moveCards(tempP1, tempP2, p2, "Player 2");
				Stats(p1, p2);
				numRounds++;
				IncNumRounds(numRounds);
				// if Card 1==Card 2
			} else {
				equal(p1, p2, tempP1, tempP2);
				numRounds++;
				IncNumRounds(numRounds);
			}
		}

		// so that the cards in the 2 decks wont have the same pattern as the number of
				// rounds go to infinity
				Collections.shuffle(p1);
				Collections.shuffle(p2);
		
		End(p1, p2);
	}
}
