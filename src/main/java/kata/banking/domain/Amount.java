package kata.banking.domain;

public class Amount {
    private final int amount;

    public static Amount negative(int amount) {
        checkAmount(amount);
        return new Amount(-amount);
    }

    public static Amount positive(int amount) {
        checkAmount(amount);
        return new Amount(amount);
    }

    private static void checkAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be non negative, but was " + amount);
        }
    }

    private Amount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
