package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.Transaction;
import kata.banking.output.TransactionListFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountFormatterTest {

    @Mock
    private AccountImplementation accountImplementation;

    @Mock
    private TransactionListFormatter transactionListFormatter;

    @InjectMocks
    private Account account = new Account();

    @Test
    public void shouldInvokeFormatWithEmptyList() {

        // when
        account.printStatement();

        // then
        verify(transactionListFormatter).format(Collections.emptyList());

    }

    @Test
    public void shouldInvokeFormatWithTransactionList() {

        // given
        List<Transaction> transactionList = Arrays.asList(
             new Transaction(LocalDate.now(), MoneyAmount.positive(200), MoneyAmount.positive(200)),
             new Transaction(LocalDate.now(), MoneyAmount.negative(100), MoneyAmount.positive(100))
        );

        when(accountImplementation.getTransactions())
             .thenReturn(transactionList);

        // when
        account.printStatement();

        // then
        verify(transactionListFormatter).format(transactionList);

    }
}
