package kata.banking.domain;

public class Transaction {

    private final int amount;
    private final int balance;

    public Transaction(int amount, int balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }
}
