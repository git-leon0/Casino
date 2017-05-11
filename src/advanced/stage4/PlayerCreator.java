package advanced.stage4;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class PlayerCreator {
    public static Player createPlayerProfile() {
        Display.printDashes();
        Display.println("Creating new player profile...");
        String name = Display.getStringInput("Enter player's name");
        double startingBalance = Display.getDoubleInput("Enter balance");
        Player newPlayer = new Player(name, startingBalance);
        Casino.registerPlayer(newPlayer);
        Display.printDashes();
        return newPlayer;
    }

    public static Player[] createPlayerProfiles(int numberOfPlayers) {
        Player[] players = new Player[numberOfPlayers];
        for(int i=0; i<numberOfPlayers; i++) {
            Player someNewGuy = createPlayerProfile();
            players[i] = someNewGuy;
        }
        return players;
    }
}
