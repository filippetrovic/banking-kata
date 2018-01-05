package kata.banking.domain;

import kata.banking.service.TimeProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountImplementationDateProviderTest {

    @Mock
    private TimeProvider timeProvider;

    @InjectMocks
    private AccountImplementation accountImplementation = new AccountImplementation();

    @Test
    public void shouldInvokeTimeProviderWhenExecutingTransactionCommand() {
        // given
        final TransactionCommand command = TransactionCommand.of(MoneyAmount.positive(100));

        // when
        accountImplementation.executeTransaction(command);

        // then
        verify(timeProvider).getCurrentTime();

    }

    @Test
    public void shouldCreateTransactionWithGivenDateTime() {

        // given
        final ZonedDateTime mockTime = ZonedDateTime.now();
        when(timeProvider.getCurrentTime()).thenReturn(mockTime);

        // when
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(100)));

        // then
        final List<Transaction> transactions = accountImplementation.getTransactions();

        assertThat(transactions).isNotNull();
        assertThat(transactions).hasSize(1);
        assertThat(transactions.get(0).getTime()).isNotNull();
        assertThat(transactions.get(0).getTime()).isEqualTo(mockTime);

    }
}
