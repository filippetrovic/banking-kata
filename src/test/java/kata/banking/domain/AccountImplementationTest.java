package kata.banking.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountImplementationTest {

    @Mock
    private TransactionHistory transactionHistory;

    @InjectMocks
    private AccountImplementation accountImplementation = new AccountImplementation();

    @Test
    public void shouldReturnEmptyListWhenNoTransactionIsLogged() {

        when(transactionHistory.getHistory()).thenReturn(Collections.emptyList());

        // then
        assertThat(accountImplementation.getTransactions())
                .isEmpty();

    }

    @Test
    public void shouldReturnResultsOfGetHistory() {
        // given
        List<Transaction> fakeValues = Arrays.asList(
                new Transaction(LocalDate.now(), MoneyAmount.positive(123), MoneyAmount.positive(123)),
                new Transaction(LocalDate.now(), MoneyAmount.negative(123), MoneyAmount.zero())
        );
        when(transactionHistory.getHistory()).thenReturn(fakeValues);

        // when
        final List<Transaction> returnedTransactions = accountImplementation.getTransactions();

        // then
        assertThat(returnedTransactions).containsExactlyElementsOf(fakeValues);
    }

    @Test
    public void shouldInvokeAddToHistoryWithExpectedTransactionWhenHistoryIsEmpty() {
        // given
        when(transactionHistory.getLastTransaction()).thenReturn(Optional.empty());

        // when
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(123)));

        // then
        final ArgumentCaptor<Transaction> argCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionHistory).addToHistory(argCaptor.capture());

        final Transaction argument = argCaptor.getValue();
        assertThat(argument.getTransactionAmount()).isEqualTo(MoneyAmount.positive(123));
        assertThat(argument.getBalance()).isEqualTo(MoneyAmount.positive(123));
    }

    @Test
    public void shouldInvokeAddToHistoryWithExpectedTransactionWhenHistoryIsNotEmpty() {
        // given
        when(transactionHistory.getLastTransaction())
                .thenReturn(Optional.of(new Transaction(
                        LocalDate.now(),
                        MoneyAmount.positive(100),
                        MoneyAmount.positive(100))
                ));

        // when
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(200)));

        // then
        final ArgumentCaptor<Transaction> argCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionHistory).addToHistory(argCaptor.capture());

        final Transaction argument = argCaptor.getValue();
        assertThat(argument.getTransactionAmount()).isEqualTo(MoneyAmount.positive(200));
        assertThat(argument.getBalance()).isEqualTo(MoneyAmount.positive(300));
    }

}
