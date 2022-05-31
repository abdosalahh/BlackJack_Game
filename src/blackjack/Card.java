package blackjack;


public class Card {
    private final int suit , rank , value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    
    public Card(Card card)
    {
        this.suit = card.suit;
        this.rank = card.rank;
        this.value = card.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
    
}