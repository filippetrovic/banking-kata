package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionCommandTest {

    @Test
    public void shouldCreateCommandWithAmount() {

        final TransactionCommand command = TransactionCommand.of(Amount.positive(300));

        assertThat(command.getAmount())
                .isEqualTo(Amount.positive(300));
    }

}
