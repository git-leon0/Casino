package advanced.stage5;

public class Profile {
    private final long profileId;
    private final String name;
    private double balance;

    public Profile(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.profileId = System.currentTimeMillis();
    }

    public void printInformation() {
        Display.printDashes();

        Display.println("Printing profile details");
        Display.println("\tName:\t\t " + getName());
        Display.println("\tBalance:\t " + getBalance());
        Display.println("\tId:\t\t\t " + getProfileId());
    }

    public void increaseBalance(double amount) {
        double oldBalance = getBalance();
        double newBalance = oldBalance + amount;
        String deltaStr = newBalance > oldBalance ? "increased" : "decreased";

        setBalance(newBalance);
        Display.printlnf("[ %s ]'s balance has %s from [ %s ] to [ %s ]", name, deltaStr, oldBalance, newBalance);
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

    public Long getProfileId() {
        return this.profileId;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
}
