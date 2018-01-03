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

        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.positive(100)));
        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.negative(200)));
        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.positive(300)));

        assertThat(balanceLog.getTransactions())
                .extracting(Transaction::getMoneyAmount)
                .containsExactly(
                        MoneyAmount.positive(100),
                        MoneyAmount.negative(200),
                        MoneyAmount.positive(300)
                );

    }

    @Test
    public void shouldReturnTransactionWithBalanceAtTheMomentsOfTransaction() {

        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.positive(100)));
        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.negative(200)));
        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.positive(300)));

        assertThat(balanceLog.getTransactions())
                .extracting(Transaction::getBalance)
                .containsExactly(
                        MoneyAmount.ofSigned(100),
                        MoneyAmount.ofSigned(-100),
                        MoneyAmount.ofSigned(200)
                );

    }
}
