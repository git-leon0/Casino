package advanced.stage6;

import advanced.stage6.cardutilities.Card;
import advanced.stage6.cardutilities.Deck;

import java.util.ArrayList;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class Player {
    public final Profile profile;
    private final String profileName;
    private final ArrayList<Card> hand = new ArrayList<Card>();
    private final long bet;
    private boolean isFinished;

    public Player(Profile profile) {
        this.profile = profile;
        this.profileName = profile.getName();
        this.bet = createBetAmount();
        this.isFinished = false;
    }

    public Long getBetAmount() {
        return this.bet;
    }

    public long createBetAmount() {
        Display.printDashes();
        double playerBalance = profile.getBalance();
        long playerBet = Display.getLongInput("How much money would you like to bet this game, [ %s ] ?", profileName);
        if (playerBet <= playerBalance) {
            return playerBet;
        } else {
            Display.println("You cannot bet more money than what is credited to your player-profile.");
            Display.println("Try inputting a valid less than [ %s ]", playerBalance);
            profile.printInformation();
            return createBetAmount();
        }
    }

    public void getCard(Deck deck) {
        Card card = deck.pop();
        String cardName = card.toString();

        this.hand.add(card);
        Display.println("[ %s ] has been added to hand of [ %s ]", cardName, profileName);
        printHandTotal();
    }

    public int getHandTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.getValue();
        }
        return total;
    }

    public void printHand() {
        Display.printDashes();
        if (!this.hand.isEmpty()) {
            Display.println("Displaying the hand of [ %s ]", profileName);
            for (Card card : this.hand) {
                Display.println(card.toString());
            }
        } else {
            Display.println("The contents of [ %s ]'s hand is empty", profileName);
        }
    }

    public void printHandTotal() {
        Display.println("[ %s ]'s hand-total is [ %s ]", profileName, getHandTotal());
    }

    public String getState() {
        int handTotal = getHandTotal();
        if (handTotal == 21) {
            return "blackjack";
        } else if (handTotal > 21) {
            return "bust";
        } else if (!isFinished) {
            return "under";
        } else {
            return "done";
        }
    }

    public void finish() {
        this.isFinished = true;
    }
}
