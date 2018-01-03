package kata.banking.domain;

public class Transaction {

    private final MoneyAmount moneyAmount;
    private final MoneyAmount balance;

    public Transaction(MoneyAmount moneyAmount, MoneyAmount balance) {
        this.moneyAmount = moneyAmount;
        this.balance = balance;
    }

    public MoneyAmount getMoneyAmount() {
        return moneyAmount;
    }

    public MoneyAmount getBalance() {
        return balance;
    }
}
