package kata.banking.domain;

public class TransactionCommand {

    private final MoneyAmount moneyAmount;

    public static TransactionCommand of(MoneyAmount moneyAmount) {
        return new TransactionCommand(moneyAmount);
    }

    private TransactionCommand(MoneyAmount moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public MoneyAmount getMoneyAmount() {
        return moneyAmount;
    }
}
