package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BalanceLogTest {

    private BalanceLog balanceLog = new BalanceLog();

    @Test
    public void shouldReturnEmptyListWhenNoTransactionIsLogged() {

        // when
        // nothing

        // then
        assertThat(balanceLog.getTransactions())
                .isEmpty();

    }

    @Test
    public void shouldReturnTransactionWithDepositValue() {

        balanceLog.logTransaction(TransactionCommand.of(Amount.positive(100)));
        balanceLog.logTransaction(TransactionCommand.of(Amount.negative(200)));
        balanceLog.logTransaction(TransactionCommand.of(Amount.positive(300)));

        assertThat(balanceLog.getTransactions())
                .extracting(Transaction::getAmount)
                .containsExactly(
                        Amount.positive(100),
                        Amount.negative(200),
                        Amount.positive(300)
                );

    }

    @Test
    public void shouldReturnTransactionWithBalanceAtTheMomentsOfTransaction() {

        balanceLog.logTransaction(TransactionCommand.of(Amount.positive(100)));
        balanceLog.logTransaction(TransactionCommand.of(Amount.negative(200)));
        balanceLog.logTransaction(TransactionCommand.of(Amount.positive(300)));

        assertThat(balanceLog.getTransactions())
                .extracting(Transaction::getBalance)
                .containsExactly(
                        Amount.ofSigned(100),
                        Amount.ofSigned(-100),
                        Amount.ofSigned(200)
                );

    }
}
