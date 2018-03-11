package kata.banking.output;

import kata.banking.domain.MoneyAmount;
import kata.banking.domain.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class TransactionFormatterTest {

    private TransactionFormatter transactionFormatter = new TransactionFormatter();

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenTransactionIsNull() {
        transactionFormatter.formatTransaction(null);
    }

    @Test
    public void shouldFormatPositiveTransactionAsRequired() {

        // given
        Transaction transaction = new Transaction(
             LocalDate.of(2018, Month.AUGUST, 12),
             MoneyAmount.positive(200),
             MoneyAmount.positive(300));

        // when
        String result = transactionFormatter.formatTransaction(transaction);

        // then
        Assertions.assertThat(result)
             .isEqualTo("???\t+200\t300");

    }

    @Test
    public void shouldFormatNegativeTransactionAsRequired() {

        // given
        Transaction transaction = new Transaction(
             LocalDate.of(2018, Month.AUGUST, 12),
             MoneyAmount.negative(500),
             MoneyAmount.negative(300));

        // when
        String result = transactionFormatter.formatTransaction(transaction);

        // then
        Assertions.assertThat(result)
             .isEqualTo("???\t-500\t-300");

    }
}
