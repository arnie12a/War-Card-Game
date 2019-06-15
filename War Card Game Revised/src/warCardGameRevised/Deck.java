package warCardGameRevised;
import java.util.ArrayList;
import java.util.Collections;



public class Deck {
	//arraylist deck
	private ArrayList<Card> Deck;
	
	String[] suitNames= {"Diamonds","Clubs","Hearts","Spades"};
	String[] rankNames= {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","king","Ace"};
	int[] rankNumberValues= {1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	public Deck() {
		Deck=new ArrayList<Card>();
	}
	
	public void createShuffledDeck() {
		//creating the shuffled deck
		int suit=4;
		int rank=13;
		for(int i=0;i<suit;i++) {
			for(int j=0;j<rank;j++) {
				Card c = new Card(suitNames[i],rankNames[j],rankNumberValues[j]);
				Deck.add(c);
			}
		}
		Collections.shuffle(Deck);
		//prints out the deck of cards
		//System.out.println(Deck);
	}
	
	public Card dealOneCard() {
		
		int first=0;
		Card temp=Deck.remove(first);
		return temp;
	}
}
