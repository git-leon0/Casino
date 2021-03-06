package advanced.stage6;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJack {
    private Player[] currentPlayers;
    private Dealer dealer;

    public BlackJack() {
    }

    public void start() {
        setup();
        play();
        dealer.hit();
        play(dealer);
        play();
    }

    public void play() {
        for (Player player : currentPlayers) {
            play(player);
        }
    }

    private void play(Player player) {
        String moveDecision;
        do {
            String playerState = player.getState();
            String playerName = player.profile.getName();
            double playerBalance = player.profile.getBalance();
            int playerHandTotal = player.getHandTotal();
            int dealerHandTotal = dealer.getHandTotal();
            int bet = player.getBetAmount().intValue();

            Display.printDashes();
            Display.println("Hey, %s!", playerName);
            Display.println("Your current balance is %s", playerBalance);
            Display.println("Your current hand-total is %s", playerHandTotal);
            Display.printDashes();

            switch (playerState) {
                case "blackjack":
                    Display.println("Player BlackJack!");
                    player.profile.increaseBalance(bet);
                    return;
                case "bust":
                    Display.println("Player Bust!");
                    player.profile.decreaseBalance(bet);
                    return;
                case "done":
                    String baseMessage = "[ %s ] has a %s  hand then the dealer.";
                    if (playerHandTotal > dealerHandTotal) {
                        Display.println(baseMessage, playerName, "better");
                        player.profile.increaseBalance(bet);
                    } else {
                        Display.println(baseMessage, playerName, "worse");
                        player.profile.decreaseBalance(bet);
                    }
                    return;
                default:
                    Display.println("%s, your available moves are [hit], [stand], [split], [view hand].", playerName);
                    moveDecision = Display.getStringInput("What action would you like to take?");

                    switch (moveDecision.toLowerCase()) {
                        case "hit":
                            dealer.deal(player, 1);
                            break;
                        case "stand":
                            player.finish();
                            break;
                        case "split":
                            break;
                        case "view hand":
                            player.printHand();
                            break;
                        case "view table":
                            this.printTable();
                        default:
                            Display.println("Invalid command!");
                            continue;
                    }
                    break;
            }
        } while (!"stand".equalsIgnoreCase(moveDecision));
    }

    private void printTable() {
        for (Player player : currentPlayers) {
            player.printHand();
        }
        dealer.printHand();
    }

    private void setup() {
        Display.println("Beginning a game of BlackJack...");
        int numberOfPlayers = Display.getIntegerInput("How many players will be playing?");
        Profile[] profiles = ProfileManager.manageProfiles(numberOfPlayers);
        this.currentPlayers = new Player[numberOfPlayers];
        this.dealer = new Dealer();

        for (int i = 0; i < currentPlayers.length; i++) {
            Player player = new Player(profiles[i]);
            this.currentPlayers[i] = player;
        }

        for (Player player : currentPlayers) {
            dealer.deal(player, 2);
        }
    }

}
