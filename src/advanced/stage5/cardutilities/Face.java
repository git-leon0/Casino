package advanced.stage5.cardutilities;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class Face {
    private String name;
    private int value;

    private final int HIGH_ACE = 11;
    private final int LOW_ACE = 1;

    public Face(int face) {
        switch (face) {
            case 1:
                setName("Ace");
                setValue(11);
                break;
            case 2:
                setName("Two");
                setValue(2);
                break;
            case 3:
                setName("Three");
                setValue(3);
                break;
            case 4:
                setName("Four");
                setValue(4);
                break;
            case 5:
                setName("Five");
                setValue(5);
                break;
            case 6:
                setName("Six");
                setValue(6);
                break;
            case 7:
                setName("Seven");
                setValue(7);
                break;
            case 8:
                setName("Eight");
                setValue(8);
                break;
            case 9:
                setName("Nine");
                setValue(9);
                break;
            case 10:
                setName("Ten");
                setValue(10);
                break;
            case 11:
                setName("Jack");
                setValue(10);
                break;
            case 12:
                setName("Queen");
                setValue(10);
                break;
            case 13:
                setName("King");
                setValue(10);
                break;
            default:
                break;
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isAce() {
        return name.equals("Ace");
    }

    public boolean isLowAce() {
        return name.equals("Ace") && getValue() == LOW_ACE;
    }

    public void switchAce() {
        if (isAce() && getValue() == HIGH_ACE) {
            setValue(LOW_ACE);
        }
    }

    public String toString() {
        return getName();
    }
}