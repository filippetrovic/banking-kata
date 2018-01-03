package kata.banking.domain;

import java.util.Objects;

public class Amount {
    private final int amount;

    public static Amount positive(int amount) {
        checkAmount(amount);
        return ofSigned(amount);
    }

    public static Amount negative(int amount) {
        checkAmount(amount);
        return ofSigned(amount).negative();
    }

    public static Amount ofSigned(int amount) {
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

    public Amount negative() {
        return ofSigned(-amount);
    }

    public Amount plus(Amount other) {
        return ofSigned(this.amount + other.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Amount other = (Amount) o;
        return amount == other.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
