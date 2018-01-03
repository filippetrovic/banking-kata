package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCommandTest {

    @Test
    public void shouldCreateCommandWithPositiveAmount() {

        final TransactionCommand command = TransactionCommand.deposit(300);

        assertThat(command.getSignedAmount()).isPositive();
    }

    @Test
    public void shouldCreateCommandWithNegativeAmount() {

        final TransactionCommand command = TransactionCommand.withdraw(300);

        assertThat(command.getSignedAmount()).isNegative();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAmountIsNegative() {

        TransactionCommand.deposit(-300);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAmountIsZero() {

        TransactionCommand.withdraw(0);

    }
}
