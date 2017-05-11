package advanced.stage3;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class PlayerCreator {

    public static Player createPlayer() {
        Display.printDashes();
        Display.println("Creating new player profile...");
        String name = Display.getStringInput("Enter player's name");
        double startingBalance = Display.getDoubleInput("Enter balance");
        Player newPlayer = new Player(name, startingBalance);
        Casino.registerPlayer(newPlayer);
        Display.printDashes();
        return newPlayer;
    }
}
