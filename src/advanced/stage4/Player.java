package advanced.stage4;

public class Player {
    private final long playerId;
    private final String name;
    private double balance;

    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.playerId = System.currentTimeMillis();
    }

    public void printInformation() {
        Display.println("\n");
        Display.printDashes();

        Display.println("Printing player details");
        Display.println("\tName:\t\t " + getName());
        Display.println("\tBalance:\t " + getBalance());
        Display.println("\tId:\t\t\t " + getPlayerId());

        Display.printDashes();
        Display.println("\n");
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

    public Long getPlayerId() {
        return this.playerId;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}
