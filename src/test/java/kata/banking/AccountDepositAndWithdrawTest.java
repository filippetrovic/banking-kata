package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.TransactionCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountDepositAndWithdrawTest {

    @Mock
    private AccountImplementation accountImplementation;

    @InjectMocks
    private Account account = new Account();

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
