package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.Transaction;
import kata.banking.domain.TransactionCommand;
import kata.banking.output.TransactionListFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
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

        assertThat(header).isEqualTo(TransactionListFormatter.HEADER);
    }

    @Test
    public void shouldPrintDepositAmountAndBalance() {

        // given
        when(accountImplementation.getTransactions())
                .thenReturn(Collections.singletonList(
                        new Transaction(
                                LocalDate.now(),
                                MoneyAmount.positive(3500),
                                MoneyAmount.positive(3500)
                        )
                ));

        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("+3500", "3500");
    }

    @Test
    public void shouldPrintMultipleTransactions() {

        // given
        when(accountImplementation.getTransactions())
                .thenReturn(Arrays.asList(
                        new Transaction(LocalDate.now(), MoneyAmount.positive(3500), MoneyAmount.positive(3500)),
                        new Transaction(LocalDate.now(), MoneyAmount.negative(500), MoneyAmount.positive(3000)),
                        new Transaction(LocalDate.now(), MoneyAmount.positive(1500), MoneyAmount.positive(4500))
                ));


        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("\t+3500\t3500\n",
                        "\t-500\t3000\n",
                        "\t+1500\t4500");

    }

    @Test
    public void shouldInvokeAccountImplementationOnDeposit() {


        // when
        account.deposit(3500);

        // then
        verify(accountImplementation).executeTransaction(
                TransactionCommand.of(MoneyAmount.positive(3500))
        );
    }

    @Test
    public void shouldInvokeAccountImplementationOnWithdraw() {


        // when
        account.withdraw(500);

        // then
        verify(accountImplementation).executeTransaction(
                TransactionCommand.of(MoneyAmount.negative(500))
        );
    }
}
