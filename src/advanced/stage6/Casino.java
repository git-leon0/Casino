package advanced.stage6;


import java.util.ArrayList;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public final class Casino {
    public static final ArrayList<Profile> profiles = new ArrayList<Profile>();
    private static final BlackJack blackjack = new BlackJack();
    private static final GoFish gofish = new GoFish();

    public static final void start() {
        while (true) {
            Display.println("\n");
            Display.printDashes();

            Display.println("Welcome to MyCasino main menu!");
            Display.println("From here, you can [create profile], [select game], [exit]");
            String userInput = Display.getStringInput("What would you like to do?");

            Display.printDashes();
            Display.println("\n");
            switch (userInput.toLowerCase()) {
                case "create profile":
                    int numberOfProfiles = Display.getIntegerInput("How many player profiles would you like to create?");
                    ProfileManager.createProfiles(numberOfProfiles);
                    break;
                case "select profile":
                    ProfileManager.selectProfile();
                    break;
                case "select game":
                    selectGame();
                    break;
                case "exit":
                    Display.printDashes();
                    Display.println("Good bye!");
                    ProfileManager.printProfilesInformation();
                    return;
                default:
                    Display.println("[ %s ] is not a recognized command!", userInput);
                    Display.println("Going back to main menu...");
                    break;
            }
        }
    }

    public static void selectGame() {
        String gameSelection = Display.getStringInput("Would you like ot play [BlackJack] or [GoFish]?");
        if (gameSelection.equalsIgnoreCase("blackjack")) {
            blackjack.start();
        } else {
            gofish.play();
        }
    }

    public static final void registerPlayer(Profile someDude) {
        Display.printDashes();
        String name = someDude.getName();
        Display.println("Checking my database to see if I know you like that...");
        if (profiles.contains(someDude)) {
            Display.println("Oh, %s! I didn't realize it was you! Welcome back!", name);
            someDude.printInformation();
        } else {
            Display.println("The Casino has registered a new profile!");
            Display.println("Homie's profile-name is " + name);
            profiles.add(someDude);
        }
    }
}