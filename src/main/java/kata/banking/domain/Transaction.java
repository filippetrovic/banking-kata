package kata.banking.domain;

public class Transaction {

    private final Amount amount;
    private final Amount balance;

    public Transaction(Amount amount, Amount balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public Amount getAmount() {
        return amount;
    }

    public Amount getBalance() {
        return balance;
    }
}
