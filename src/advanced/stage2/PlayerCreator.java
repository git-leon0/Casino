package advanced.stage2;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class PlayerCreator {

    public Player createPlayer() {
        printDashes();
        Display.println("Creating new player...");
        String name = Display.getStringInput("Enter player's name");
        double startingBalance = Display.getDoubleInput("Enter balance");
        Player newPlayer = new Player(name, startingBalance);

        Display.println("New player created!");
        Display.println("Profile name = " + name);
        Display.println("Profile starting balance = " + startingBalance);
        printDashes();
        return newPlayer;
    }

    private void printDashes() {
        Display.println("-----------------------------------------------------");
    }
}
