package advanced.stage8.cardgames.cardutilities;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by leon.hunter on 2/1/2017.
 */

public class Deck extends Stack<Card> {
    public static final int CARDS_IN_PACK = 52;

    public Deck() {
        super();
        final String[] suits = {"Hearts ♥", "Diamonds ♦", "Clubs ♣", "Spades ♠"};

        for (int i = 0; i < suits.length; i++) {
            for (int j = 1; j < 13; j++) {
                Face face = new Face(j);
                Suit suit = new Suit(suits[i]);

                this.push(new Card(face, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this);
    }
}