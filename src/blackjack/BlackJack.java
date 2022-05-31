package blackjack;
import java.util.Scanner;
public class BlackJack {
static Game game = new Game();
public static void main(String[] args) {

    GUI gui = new GUI();

    game.cardssdeckk();
    game.setplayer();

    gui.runGUI(game.deck,
               game.player[0].getCardd(),
               game.player[1].getCardd(),
               game.player[2].getCardd(),
               game.player[3].getCardd());
    
    playersRound(gui);
    game.updateScore();
    DealersRound(gui);
    game.updateScore();
    testRound();  
 }
public static void playersRound(GUI gui){
    Scanner input = new Scanner(System.in);
    
    for(int i=0 ; i<3 ; i++){
       int x;
       while(true) {
       System.out.println("Player number" + (i+1));
       System.out.println("press 1 to Hit"+"  &&&  "+"press 2 to stand");
       x=input.nextInt();
       if(x==1) { 
          CardPlayer(i , gui);
       }
       else if(x == 2) {
           break;
       }
       }
    }
   }
public static void CardPlayer(int index , GUI gui){
    Card card = game.random();
    game.player[index].addCard(card);
    gui.updatePlayerHand(card , index);
}
public static void DealersRound(GUI gui){
    
 boolean DealerisWin = true;
 int highscore = 0;
    for(int i=0 ; i<4 ; i++){
        if(game.highscore[i] >= game.player[3].Score){
            DealerisWin = false;
        }
        if(game.highscore[i] > highscore){
         highscore = game.highscore[i];   
        }
    }
    if(DealerisWin == false){
        CardDealer(gui , highscore);
    }
    else{
        return;
    }
}
public static void CardDealer(GUI gui , int highscore){
    
    while (game.player[3].Score < highscore){
    Card card = game.random();
    game.player[3].addCard(card);
    gui.updateDealerHand(card , game.deck);
    }
}
public static void testRound(){
    
    int highscore = 0;
    int k=0;
    int WinnerPlayer = -1;
    for(int i=0 ; i<4 ; i++){
        if(game.highscore[i] > highscore){
            highscore = game.highscore[i];
            WinnerPlayer= i;
        }   
    }
    
    for(int y=0 ; y<4 ; y++ ){
        if(game.highscore[y] == highscore ){
            k++;
        }
    }
    
    if(WinnerPlayer >= 0 && k==1){
        System.out.println("The Winner player in the Round is ---->"+" " + game.player[WinnerPlayer].Name+"     " + "His Score is ---->" + highscore);
        System.out.println("Congratulation" + "   " + game.player[WinnerPlayer].Name );
    }
    else{
        System.out.println("BUSH");
    }
}
}