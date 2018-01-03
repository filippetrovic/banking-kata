package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCommandTest {

    @Test
    public void shouldCreateCommandWithAmount() {

        final TransactionCommand command = TransactionCommand.of(MoneyAmount.positive(300));

        assertThat(command.getMoneyAmount())
                .isEqualTo(MoneyAmount.positive(300));
    }

}
