package advanced.stage5;

import advanced.stage5.cardutilities.Card;
import advanced.stage5.cardutilities.Deck;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class Player {
    public final Profile profile;
    private final String profileName;
    private final ArrayList<Card> hand = new ArrayList<Card>();
    private final long bet;

    public Player(Profile profile) {
        this.profile = profile;
        this.profileName = profile.getName();
        this.bet = createBetAmount();
    }

    public Long getBetAmount() {
        return this.bet;
    }

    public long createBetAmount() {
        Display.printDashes();
        double playerBalance = profile.getBalance();
        long playerBet = Display.getLongInput("How much money would you like to bet this game, [ " + profileName + " ] ?");
        if (playerBet <= playerBalance) {
            return playerBet;
        } else {
            Display.println("You cannot bet more money than what is credited to your player-profile.");
            Display.printlnf("Try inputting a valid less than [ %s ]", playerBalance);
            profile.printInformation();
            return createBetAmount();
        }
    }

    public void getCard(Deck deck) {
        Card card = deck.pop();
        String cardName = card.toString();

        this.hand.add(card);
        Display.printlnf("[ %s ] has pulled a [ %s ] from the deck.", profileName, cardName);
        Display.printlnf("[ %s ] has been added to hand of [ %s ]", cardName, profileName);
        printHandTotal();
    }

    public int getHandTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.getValue();
        }
        return total;
    }

    private void printHand() {
        Display.printDashes();
        Display.println("Displaying user's current hand...");
        for (Card card : this.hand) {
            Display.println(card.toString());
        }
        Display.printDashes();
    }

    public void printHandTotal() {
        Display.printlnf("[ %s ]'s hand-total is [ %s ]", profileName, getHandTotal());
    }
}
