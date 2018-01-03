package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountImplementationTest {

    private AccountImplementation accountImplementation = new AccountImplementation();

    @Test
    public void shouldReturnEmptyListWhenNoTransactionIsLogged() {

        // when
        // nothing

        // then
        assertThat(accountImplementation.getTransactions())
                .isEmpty();

    }

    @Test
    public void shouldReturnTransactionWithDepositValue() {

        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(100)));
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.negative(200)));
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(300)));

        assertThat(accountImplementation.getTransactions())
                .extracting(Transaction::getTransactionAmount)
                .containsExactly(
                        MoneyAmount.positive(100),
                        MoneyAmount.negative(200),
                        MoneyAmount.positive(300)
                );

    }

    @Test
    public void shouldReturnTransactionWithBalanceAtTheMomentsOfTransaction() {

        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(100)));
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.negative(200)));
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(300)));

        assertThat(accountImplementation.getTransactions())
                .extracting(Transaction::getBalance)
                .containsExactly(
                        MoneyAmount.ofSigned(100),
                        MoneyAmount.ofSigned(-100),
                        MoneyAmount.ofSigned(200)
                );

    }
}
