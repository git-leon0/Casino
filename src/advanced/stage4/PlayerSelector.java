package advanced.stage4;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class PlayerSelector {

    public static Player[] selectPlayerProfiles(int numberOfPlayers) {
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Display.printlnf("Requesting action regarding player number %s...", i);
            String userDecision = Display.getStringInput("Would you like to [create] a new account, or [select] a preexisting?");
            if (userDecision.equalsIgnoreCase("create")) {
                players[i] = PlayerCreator.createPlayerProfile();
            } else {
                players[i] = PlayerSelector.selectPlayerProfile();
            }
        }
        return players;
    }

    public static Player selectPlayerProfile() {
        if (Casino.players.size() > 0) {
            Display.println("Try inputting a player-id from the list below!");
            printPlayersInformation();
            long playerId = Display.getLongInput("Please enter the desired player-profile's id number: ");
            for (Player player : Casino.players) {
                if (player.getPlayerId() == playerId) {
                    return player;
                }
            }
            Display.printlnf("[ %s ] is not a player-id that our records recognize.", playerId);
        } else {
            Display.println("There are currently no profiles in our records.");
            Display.println("Try creating some player-accounts first.");
        }
        return null;
    }

    private static void printPlayersInformation() {
        Display.println("Displaying a list of player-profiles registered at our Casino...");
        for (Player player : Casino.players) {
            player.printInformation();
        }
    }
}
