package kata.banking.domain;

public class TransactionCommand {

    private final int amount;
    private final Operation operation;

    public static TransactionCommand deposit(int amount) {
        return new TransactionCommand(Operation.DEPOSIT, amount);
    }

    public static TransactionCommand withdraw(int amount) {
        return new TransactionCommand(Operation.WITHDRAW, amount);
    }

    private TransactionCommand(Operation operation, int amount) {
        checkAmount(amount);

        this.operation = operation;
        this.amount = amount;
    }

    private void checkAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive value, but was " + amount);
        }
    }

    public int getSignedAmount() {
        return operation.getSign() * amount;
    }

    private enum Operation {
        DEPOSIT(1),
        WITHDRAW(-1);

        private final int sign;

        Operation(int sign) {
            this.sign = sign;
        }

        public int getSign() {
            return sign;
        }
    }
}
