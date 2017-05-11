package simple.stage1;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class Casino {
    public void start() {
        Display.println("Welcome to my casino!");
        String gameSelection = Display.getStringInput("Which game would you like to play?");
        Player player1 = new Player();
    }
}