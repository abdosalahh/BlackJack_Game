package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    
    public Player [] player = new Player[4];
    public Card [] deck = new Card[52];
    public int[] highscore = new int[4];
    
     public void cardssdeckk()
    {
       
        int suit = 0 , rank = 0 , value = 1;

        for(int j = 0 ; j < 52 ; j++)
        {
            if(j % 13 == 0 && j != 0)
            {
                suit++;
                rank = 0;
                value = 1;
            }
            if(value == 11 || value == 12 || value == 13)
                value = 10;
            deck[j] = new Card (suit , rank , value);
            rank++;
            value++;
         
        }
         
    }
   
     
    public Card random()
    {
        Random rand = new Random();
        Card card = null;
        do{
            
        int randomChoise = rand.nextInt(51);
        card = deck[randomChoise];
        deck[randomChoise]=null;
        
        }while(card == null);
        return card;
       
    }
    
    public void setplayer(){
        Scanner input=new Scanner(System.in);
        for(int i=0 ; i<3 ; i++){
            System.out.println("please enter name of player" + (i+1) + ":");
            player[i] = new Player();
            player[i].Name = input.next();
            player[i].addCard(this.random());
            player[i].addCard(this.random());
        }
            player[3] = new Player();
            player[3].Name = "Dealer";
            player[3].addCard(this.random());
            player[3].addCard(this.random());
    }
    
    public void updateScore(){
        for(int i=0 ; i<4 ; i++){
            if(player[i].Score <= 21){
            highscore[i] = player[i].Score;
            }
            else{
            player[i].Score=0;
        }
        }
    }
  
    
    
}