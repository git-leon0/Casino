package advanced.stage3;
public class Player {
    private final String name;
    private double balance;

    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
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
