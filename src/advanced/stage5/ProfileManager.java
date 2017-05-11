package advanced.stage5;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class ProfileManager {
    public static Profile createProfile() {
        Display.printDashes();
        Display.println("Creating new player profile...");

        String name = Display.getStringInput("Enter player's name");
        double startingBalance = Display.getDoubleInput("Enter balance");
        Profile newPlayer = new Profile(name, startingBalance);
        Casino.registerPlayer(newPlayer);

        return newPlayer;
    }

    public static Profile[] createProfiles(int numberOfPlayers) {
        Profile[] players = new Profile[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Profile someNewGuy = createProfile();
            players[i] = someNewGuy;
        }
        return players;
    }


    public static Profile[] manageProfiles(int numberOfPlayers) {
        Profile[] profiles = new Profile[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Display.printDashes();
            Display.printlnf("Requesting action regarding player number %s...", i);
            String userDecision = Display.getStringInput("Would you like to [create] a new profile, or [select] a preexisting?");
            if ("create".equalsIgnoreCase(userDecision)) {
                profiles[i] = ProfileManager.createProfile();
            } else if("select".equalsIgnoreCase(userDecision)) {
                profiles[i] = ProfileManager.selectProfile();
            } else {
                Display.printlnf("[ %s ] is not recognized as a valid command.", userDecision);
                profiles[i] = manageProfiles(1)[0];
            }
        }
        return profiles;
    }

    public static Profile selectProfile() {
        if (Casino.profiles.size() > 0) {
            printProfilesInformation();
            long playerId = Display.getLongInput("Please enter the desired player-profile's id number: ");
            for (Profile player : Casino.profiles) {
                if (player.getProfileId() == playerId) {
                    return player;
                }
            }
            Display.printlnf("[ %s ] is not a player-id that our records recognize.", playerId);
        } else {
            Display.println("There are currently no profiles in our records.");
            Display.println("Try creating some player-accounts first.");
        }
        return createProfile();
    }

    private static void printProfilesInformation() {
        Display.println("Displaying a list of player-profiles registered at our Casino...");
        for (Profile player : Casino.profiles) {
            player.printInformation();
        }
    }
}
