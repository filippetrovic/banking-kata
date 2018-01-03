package kata.banking.domain;

public class Transaction {

    private final MoneyAmount transactionAmount;
    private final MoneyAmount balance;

    public Transaction(MoneyAmount transactionAmount, MoneyAmount balance) {
        this.transactionAmount = transactionAmount;
        this.balance = balance;
    }

    public MoneyAmount getTransactionAmount() {
        return transactionAmount;
    }

    public MoneyAmount getBalance() {
        return balance;
    }
}
