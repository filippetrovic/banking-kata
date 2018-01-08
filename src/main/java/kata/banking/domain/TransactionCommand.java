package kata.banking.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionCommand that = (TransactionCommand) o;
        return Objects.equals(moneyAmount, that.moneyAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyAmount);
    }
}
