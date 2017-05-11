package simple.stage2;


import java.util.ArrayList;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class Casino {
    public static ArrayList<Player> players = new ArrayList<Player>();
    public void start() {
        Display.println("Welcome to my casino!");
        String gameSelection = Display.getStringInput("Which game would you like to play?");
        
        Player player1 = new Player();
        players.add(player1);

        BlackJack blackJackGame = new BlackJack();
        blackJackGame.play();
    }
}
