package kata.banking.domain;

import java.util.Objects;

public class MoneyAmount {
    private final int amount;

    public static MoneyAmount positive(int amount) {
        checkAmount(amount);
        return ofSigned(amount);
    }

    public static MoneyAmount negative(int amount) {
        checkAmount(amount);
        return ofSigned(amount).negative();
    }

    public static MoneyAmount zero() {
        return ofSigned(0);
    }

    public static MoneyAmount ofSigned(int amount) {
        return new MoneyAmount(amount);
    }

    private static void checkAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be non negative, but was " + amount);
        }
    }

    private MoneyAmount(int amount) {
        this.amount = amount;
    }

    public int intValue() {
        return amount;
    }

    public MoneyAmount negative() {
        return ofSigned(-amount);
    }

    public MoneyAmount plus(MoneyAmount other) {
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

        MoneyAmount other = (MoneyAmount) o;
        return amount == other.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "MoneyAmount{" +
                "amount=" + amount +
                '}';
    }
}
