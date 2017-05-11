package advanced.stage5;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class BlackJack {
    private Player[] currentPlayers;
    private Dealer dealer;

    public BlackJack() {
    }

    public void start() {
        Display.println("Beginning a game of BlackJack...");
        setup();
        for (Player currentPlayer : this.currentPlayers) {
            play(currentPlayer);
        }
    }

    public void play(Player player) {
        Display.printDashes();
        String name = player.profile.getName();
        double balance = player.profile.getBalance();
        int handTotal = player.getHandTotal();

        Display.printlnf("Hey, %s!", name);
        Display.printlnf("Your current balance is %s", balance);
        Display.printlnf("Your current hand-total is %s", player.getHandTotal());
        if (handTotal == 21) {
            Display.println("Player BlackJack!");
            player.profile.increaseBalance(player.getBetAmount());
        } else if (handTotal < 21) {
            String moveDecision;
            do {
                Display.println("Available moves are [hit], [stand], [split], [fold].");
                moveDecision = Display.getStringInput("What action would you like to take?");

                switch (moveDecision.toLowerCase()) {
                    case "hit":
                        dealer.deal(player, 1);
                        break;
                    case "stand":
                        dealer.deal(dealer, 1);
                        break;
                    case "split":
                        break;
                    default:
                        Display.println("Invalid command!");
                        break;
                }

            } while (!moveDecision.equalsIgnoreCase("fold"));

        } else {
            Display.println("Player bust!");
            player.profile.decreaseBalance(player.getBetAmount());
        }
    }

    private void setup() {
        int numberOfPlayers = Display.getIntegerInput("How many players will be playing?");
        Profile[] profiles = ProfileManager.manageProfiles(numberOfPlayers);
        this.currentPlayers = new Player[numberOfPlayers];
        this.dealer = new Dealer();
        for (int i = 0; i < currentPlayers.length; i++) {
            Player player = new Player(profiles[i]);
            this.currentPlayers[i] = player;
            dealer.deal(player, 2);
        }
        dealer.deal(dealer, 2);
    }

}
