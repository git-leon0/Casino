package advanced.stage6;

import advanced.stage6.cardutilities.Deck;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class Dealer extends Player {
    private final Deck deck = new Deck();

    public Dealer() {
        super(new Profile("DEALER", -1));
        //this.deck.shuffle();
    }

    @Override
    public long createBetAmount() {
        return 0;
    }

    @Override
    public String getState() {
        return "dealer";
    }

    public void deal(Player player, int numberOfCards) {
        Display.printDashes();
        Display.println("The dealer is dealing cards to [ %s ]", player.profile.getName());
        for (int i = 0; i < numberOfCards; i++) {
            player.getCard(this.deck);
        }
    }

    public void hit() {
        while (getHandTotal() < 17) {
            deal(this, 1);
        }
    }
}
