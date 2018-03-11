package kata.banking.output;

import kata.banking.domain.MoneyAmount;
import kata.banking.domain.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionListFormatterTest {

    private TransactionListFormatter transactionListFormatter =
         new TransactionListFormatter(new TransactionFormatter());

    @Test
    public void shouldReturnHeader() {

        String header = transactionListFormatter.format(Collections.emptyList());

        assertThat(header).isEqualTo(TransactionListFormatter.HEADER);
    }

    @Test
    public void shouldPrintDepositAmountAndBalance() {

        // given
        final List<Transaction> transactions = Collections.singletonList(
             new Transaction(
                  LocalDate.of(1999, Month.JANUARY, 17),
                  MoneyAmount.positive(3500),
                  MoneyAmount.positive(3500)
             )
        );

        // when
        String statement = transactionListFormatter.format(transactions);

        // then
        assertThat(statement)
             .containsSequence(TransactionListFormatter.HEADER, "17.01.1999", "+3500", "3500");
    }

    @Test
    public void shouldPrintMultipleTransactions() {

        // given
        final List<Transaction> transactions = Arrays.asList(
             new Transaction(
                  LocalDate.of(1999, Month.JANUARY, 3),
                  MoneyAmount.positive(3500),
                  MoneyAmount.positive(3500)
             ),
             new Transaction(
                  LocalDate.of(2001, Month.MAY, 23),
                  MoneyAmount.negative(500),
                  MoneyAmount.positive(3000)
             ),
             new Transaction(
                  LocalDate.of(2002, Month.SEPTEMBER, 13),
                  MoneyAmount.positive(1500),
                  MoneyAmount.positive(4500)
             )
        );

        // when
        String statement = transactionListFormatter.format(transactions);

        // then
        assertThat(statement)
             .containsSequence(TransactionListFormatter.HEADER,
                  "03.01.1999\t+3500\t3500\n",
                  "23.05.2001\t-500\t3000\n",
                  "13.09.2002\t+1500\t4500");

    }

}
