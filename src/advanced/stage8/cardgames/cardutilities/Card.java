package advanced.stage8.cardgames.cardutilities;

/**
 * Created by leon.hunter on 2/1/2017.
 */

public class Card {
    private final Suit suit;
    private final Face face;
    private final int value;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
        this.value = getValue();
    }

    public Face getFace() {
        return this.face;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.getFace().getValue();
    }

    public String toString() {
        return getFace() + " of " + getSuit();
    }
}