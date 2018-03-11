package kata.banking.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionHistoryTest {

    private TransactionHistory transactionHistory = new TransactionHistory();

    @Test
    public void shouldReturnEmptyOptionalWhenHistoryIsEmpty() {

        Optional<Transaction> lastHistoryElement = transactionHistory.getLastTransaction();

        assertThat(lastHistoryElement).isEmpty();

    }

    @Test
    public void shouldReturnLastHistoryElement() {

        // given
        Transaction transaction = new Transaction(
             LocalDate.now(),
             MoneyAmount.positive(200),
             MoneyAmount.positive(300));

        // when
        transactionHistory.addToHistory(transaction);
        Optional<Transaction> lastHistoryElement = transactionHistory.getLastTransaction();

        // then
        assertThat(lastHistoryElement).isNotEmpty();

        final Transaction transactionFromHistory = lastHistoryElement.get();
        assertThat(transactionFromHistory.getTransactionAmount()).isEqualTo(MoneyAmount.positive(200));
        assertThat(transactionFromHistory.getBalance()).isEqualTo(MoneyAmount.positive(300));
    }

}
