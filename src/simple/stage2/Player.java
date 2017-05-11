package simple.stage2;

public class Player {
    private final String name;
    private double balance;

    // When constructor is called
    // prompt user to input initial values
    public Player() {
        this.name = Display.getStringInput("Enter player's name");
        this.balance = Display.getDoubleInput("Enter balance");
    }

    public void increaseBalance(double amount) {
        double currentBalance = getBalance();
        setBalance(currentBalance + amount);
    }

    public void decreaseBalance(double amount) {
        increaseBalance(amount * -1);
    }

    public double getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}
