package advanced.stage2;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class Casino {
    public void start() {
        PlayerCreator playerCreator = new PlayerCreator();

        Display.println("Welcome to my casino!");
        String gameSelection = Display.getStringInput("Which game would you like to play?");
        Player player1 = playerCreator.createPlayer();
    }
}
