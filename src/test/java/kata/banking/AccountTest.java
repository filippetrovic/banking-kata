package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private AccountImplementation accountImplementation;

    @InjectMocks
    private Account account = new Account();

    @Test
    public void shouldReturnHeader() {

        String header = account.printStatement();

        assertThat(header).isEqualTo(Account.HEADER);
    }

    @Test
    public void shouldReturnDepositAmountAndBalance() {

        // given
        when(accountImplementation.getTransactions())
                .thenReturn(Collections.singletonList(
                        new Transaction(ZonedDateTime.now(), MoneyAmount.positive(3500), MoneyAmount.positive(3500))
                ));

        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("+3500", "3500");
    }

    @Test
    public void shouldReturnMultipleTransactions() {

        // given
        when(accountImplementation.getTransactions())
                .thenReturn(Arrays.asList(
                        new Transaction(ZonedDateTime.now(), MoneyAmount.positive(3500), MoneyAmount.positive(3500)),
                        new Transaction(ZonedDateTime.now(), MoneyAmount.negative(500), MoneyAmount.positive(3000)),
                        new Transaction(ZonedDateTime.now(), MoneyAmount.positive(1500), MoneyAmount.positive(4500))
                ));


        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("\t+3500\t3500\n",
                        "\t-500\t3000\n",
                        "\t+1500\t4500");

    }

}
