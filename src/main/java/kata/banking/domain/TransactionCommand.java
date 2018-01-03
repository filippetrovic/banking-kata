package kata.banking.domain;

public class TransactionCommand {

    private final Amount amount;

    public static TransactionCommand of(Amount amount) {
        return new TransactionCommand(amount);
    }

    private TransactionCommand(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }
}
