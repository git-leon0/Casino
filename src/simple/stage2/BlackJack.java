package simple.stage2;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJack {
    public BlackJack() {
    }

    public void play() {
        // get first person in ArrayList
        Player someDude = Casino.players.get(0);

        // ask them to play the game
        Display.println("Hey " + someDude.getName() + "!");
        Display.println("Are you ready to play BlackJack?");
        String someDudesDecision = Display.getStringInput("Enter [ yes ] or [ no ]");
        if(someDudesDecision.equalsIgnoreCase("yes")) {
            Display.println("Beginning game");
            // blackjack logic
        } else {
            Display.println("Quitting game");
            // go back to Casino game-selection screen
        }
    }
}
