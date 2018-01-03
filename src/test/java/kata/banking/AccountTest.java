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
        account.withdraw(500);
        account.deposit(1500);

        // when
        String statement = account.printStatement();

        // then
        assertThat(statement)
                .containsSequence("\t+3500\t3500\n",
                        "\t-500\t3000\n",
                        "\t+1500\t4500");

    }

}
