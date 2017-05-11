package advanced.stage3;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class Casino {
    public static ArrayList<Player> players = new ArrayList<Player>();
    public static void start() {
        Display.println("Welcome to my casino!");
        String gameSelection = Display.getStringInput("Which game would you like to play?");
        Player player1 = PlayerCreator.createPlayer();
    }

    public static void registerPlayer(Player someNewGuy) {
        String someNewGuysName = someNewGuy.getName();
        Display.println("The Casino has registered a new player!");
        Display.println("Homie's name is " + someNewGuysName);
        players.add(someNewGuy);
    }
}
