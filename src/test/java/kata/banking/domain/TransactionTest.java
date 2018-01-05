package kata.banking.domain;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {
    @Test
    public void shouldReturnAllFieldsValid() {

        // given
        final MoneyAmount balance = MoneyAmount.positive(300);
        final MoneyAmount amount = MoneyAmount.negative(100);
        final ZonedDateTime time = ZonedDateTime.now();

        // when
        final Transaction transaction = new Transaction(time, amount, balance);

        // then
        assertThat(transaction.getBalance()).isEqualTo(balance);
        assertThat(transaction.getTransactionAmount()).isEqualTo(amount);
        assertThat(transaction.getTime()).isEqualTo(time);
    }
}
