package advanced.stage4;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public final class Casino {
    public static final ArrayList<Player> players = new ArrayList<Player>();
    private static final BlackJack blackjack = new BlackJack();
    private static final GoFish gofish = new GoFish();

    public static final void start() {
        while(true) {
            Display.println("\n");
            Display.printDashes();

            Display.println("Welcome to my the Casino main menu!");
            Display.println("From here, you can [create account], [select account], [select game], [exit]");
            String userInput = Display.getStringInput("What would you like to do?");

            Display.printDashes();
            Display.println("\n");
            switch (userInput.toLowerCase()) {
                case "create account":
                    PlayerCreator.createPlayerProfiles(-1);
                    break;
                case "select account":
                    PlayerSelector.selectPlayerProfile();
                    break;
                case "select game":
                    selectGame();
                case "exit":
                    return;
                default:
                    Display.printlnf("[ %s ] is not a recognized command!", userInput);
                    Display.println("Going back to main menu...");
                    break;
            }
        }
    }

    public static void selectGame() {
        String gameSelection = Display.getStringInput("Which game would you like to play?");
        if(gameSelection.equalsIgnoreCase("blackjack")) {
            blackjack.play();
        } else {
            gofish.play();
        }
    }

    public static final void registerPlayer(Player someNewGuy) {
        String someNewGuysName = someNewGuy.getName();
        Display.println("The Casino has registered a new player!");
        Display.println("Homie's name is " + someNewGuysName);
        players.add(someNewGuy);
    }

    public static final void checkForPlayer(Player someOldGuy) {
        String name = someOldGuy.getName();
        Display.println("Checking my database to see if I know you like that...");
        if (players.contains(someOldGuy)) {
            Display.printlnf("Oh, %s! I didn't realize it was you! Welcome back!", name);
            someOldGuy.printInformation();
        } else {
            Display.println("The Casino has registered a new player!");
            Display.println("Homie's name is " + name);
            players.add(someOldGuy);
        }
    }
}