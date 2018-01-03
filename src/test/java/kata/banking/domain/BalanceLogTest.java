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

        balanceLog.logTransaction(TransactionCommand.deposit(100));
        balanceLog.logTransaction(TransactionCommand.withdraw(200));
        balanceLog.logTransaction(TransactionCommand.deposit(300));

        assertThat(balanceLog.getTransactions())
                .extracting(Transaction::getAmount)
                .containsExactly(100, -200, 300);

    }

    @Test
    public void shouldReturnTransactionWithBalanceAtTheMomentsOfTransaction() {

        balanceLog.logTransaction(TransactionCommand.deposit(100));
        balanceLog.logTransaction(TransactionCommand.withdraw(200));
        balanceLog.logTransaction(TransactionCommand.deposit(300));

        assertThat(balanceLog.getTransactions())
                .extracting(Transaction::getBalance)
                .containsExactly(100, -100, 200);

    }
}