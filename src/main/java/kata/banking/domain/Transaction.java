package kata.banking.domain;

import java.time.LocalDate;

public class Transaction {

    private final MoneyAmount transactionAmount;
    private final MoneyAmount balance;
    private LocalDate time;

    public Transaction(LocalDate time, MoneyAmount transactionAmount, MoneyAmount balance) {
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

    public LocalDate getTime() {
        return time;
    }
}
