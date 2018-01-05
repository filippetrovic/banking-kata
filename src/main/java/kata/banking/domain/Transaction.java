package kata.banking.domain;

import java.time.ZonedDateTime;

public class Transaction {

    private final MoneyAmount transactionAmount;
    private final MoneyAmount balance;
    private ZonedDateTime time;

    public Transaction(ZonedDateTime time, MoneyAmount transactionAmount, MoneyAmount balance) {
        this.time = time;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
    }

    public MoneyAmount getTransactionAmount() {
        return transactionAmount;
    }

    public MoneyAmount getBalance() {
        return balance;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
