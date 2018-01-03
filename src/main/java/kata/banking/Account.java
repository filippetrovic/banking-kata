package kata.banking;

import kata.banking.domain.BalanceLog;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.TransactionCommand;

import java.util.stream.Collectors;

public class Account {

    public static final String HEADER = "Date\tMoneyAmount\tBalance\n";

    private final BalanceLog balanceLog = new BalanceLog();

    public void deposit(int amount) {
        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.positive(amount)));
    }

    public void withdraw(int amount) {
        balanceLog.logTransaction(TransactionCommand.of(MoneyAmount.negative(amount)));
    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (balanceLog.getTransactions().size() > 0) {
            return balanceLog.getTransactions().stream()
                    .map(transaction -> String.format("???\t%+d\t%d",
                            transaction.getMoneyAmount().intValue(),
                            transaction.getBalance().intValue()))
                    .collect(Collectors.joining("\n"));
        }

        return statementBuilder.toString();
    }
}
