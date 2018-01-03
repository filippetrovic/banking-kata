package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCommandTest {

    @Test
    public void shouldCreateCommandWithPositiveAmount() {

        final TransactionCommand command = TransactionCommand.of(Amount.positive(300));

        assertThat(command.getSignedAmount()).isPositive();
    }

    @Test
    public void shouldCreateCommandWithNegativeAmount() {

        final TransactionCommand command = TransactionCommand.of(Amount.negative(300));

        assertThat(command.getSignedAmount()).isNegative();
    }

}
