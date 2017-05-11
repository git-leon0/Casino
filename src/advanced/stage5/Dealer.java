package advanced.stage5;

import advanced.stage5.cardutilities.Deck;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class Dealer extends Player {
    private final Deck deck = new Deck();

    public Dealer() {
        super(new Profile("DEALER", -1));
        shuffle();
    }

    @Override
    public long createBetAmount() {
        return -1;
    }

    public void shuffle() {
        this.deck.shuffle();
    }

    public void deal(Player player, int numberOfCards) {
        Display.printDashes();
        Display.printlnf("The dealer is dealing cards to [ %s ]", player.profile.getName());
        for (int i = 0; i < numberOfCards; i++) {
            player.getCard(this.deck);
        }
    }

    public void initialHit() {
        while(getHandTotal() < 17) {
            deal(this, 1);
        }
    }
}
