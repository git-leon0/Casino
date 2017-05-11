package advanced.stage4;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJack {
    private Player[] currentPlayers;
    public BlackJack() {
    }

    public void play() {
        Display.println("Beginning a game of BlackJack...");
        int numberOfPlayers = Display.getIntegerInput("How many profiles will be playing?");
        this.currentPlayers = PlayerSelector.selectPlayerProfiles(numberOfPlayers);
    }
}
