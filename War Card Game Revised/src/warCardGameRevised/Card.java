package warCardGameRevised;

public class Card {
	private String suit,rank;
	private int rankValue;
	
	public Card(String suit, String rank,int rankValue) {
		this.suit=suit;
		this.rank=rank;
		this.rankValue=rankValue;
	}
	//get method for suit
	public String getSuit() {
		return suit;
	}
	//get method for rank
	public String getRank() {
		return rank;
	}
	//get method for rank value
	public int getRankValue() {
		return rankValue;
	}
	//toString
	public String toString() {
		return(rank + " of "+ suit);
	}
}
