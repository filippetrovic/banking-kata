package kata.banking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account = new Account();

    @Test
    public void shouldReturnHeader() {

        String header = account.printStatement();

        assertThat(header).isEqualTo(Account.HEADER);
    }

    @Test
    public void shouldReturnDepositAmountAndBalance() {

        // given
        account.deposit(3500);

        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("+3500", "3500");
    }

    @Test
    public void shouldReturnMultipleTransactions() {

        // given
        account.deposit(3500);
        account.deposit(1500);

        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("+3500", "3500", "\n", "+1500", "5000");

    }
}
