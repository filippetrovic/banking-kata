package kata.banking.output;

import kata.banking.domain.MoneyAmount;
import kata.banking.domain.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionListFormatterTest {

    private TransactionListFormatter transactionListFormatter = new TransactionListFormatter();

    @Test
    public void shouldReturnHeader() {

        String header = transactionListFormatter.format(Collections.emptyList());

        assertThat(header).isEqualTo(TransactionListFormatter.HEADER);
    }

    @Test
    public void shouldPrintDepositAmountAndBalance() {

        // given
        final List<Transaction> transactions = Collections.singletonList(
             new Transaction(LocalDate.now(), MoneyAmount.positive(3500), MoneyAmount.positive(3500))
        );

        // when
        String statement = transactionListFormatter.format(transactions);

        // then
        assertThat(statement)
             .containsSequence("+3500", "3500");
    }

    @Test
    public void shouldPrintMultipleTransactions() {

        // given
        final List<Transaction> transactions = Arrays.asList(
             new Transaction(LocalDate.now(), MoneyAmount.positive(3500), MoneyAmount.positive(3500)),
             new Transaction(LocalDate.now(), MoneyAmount.negative(500), MoneyAmount.positive(3000)),
             new Transaction(LocalDate.now(), MoneyAmount.positive(1500), MoneyAmount.positive(4500))
        );

        // when
        String statement = transactionListFormatter.format(transactions);

        // then
        assertThat(statement)
             .containsSequence("\t+3500\t3500\n",
                  "\t-500\t3000\n",
                  "\t+1500\t4500");

    }

}
