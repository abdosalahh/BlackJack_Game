package blackjack;


public class Player {
    
    public String Name;
    public int Score=0;
    private Card[] cardd = new Card[11];
    private int cardCounter = 0;

    public Card[] getCardd() {
        return this.cardd;
    }
    
    public void addCard(Card card){
    if(cardCounter < 11){
    cardd[cardCounter]=card;
    cardCounter++;
    Score += card.getValue();
}
}
}