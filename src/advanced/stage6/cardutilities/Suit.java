package advanced.stage6.cardutilities;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class Suit {
    private String name;

    public Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName();
    }
}