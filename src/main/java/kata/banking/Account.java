package kata.banking;

import kata.banking.domain.BalanceLog;
import kata.banking.domain.TransactionCommand;

import java.util.stream.Collectors;

public class Account {

    public static final String HEADER = "Date\tAmount\tBalance\n";

    private final BalanceLog balanceLog = new BalanceLog();

    public void deposit(int amount) {
        balanceLog.logTransaction(TransactionCommand.deposit(amount));
    }

    public void withdraw(int amount) {

    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (balanceLog.getTransactions().size() > 0) {
            return balanceLog.getTransactions().stream()
                    .map(transaction -> String.format("+%d\t%d", transaction.getAmount(), transaction.getBalance()))
                    .collect(Collectors.joining("\n"));
        }

        return statementBuilder.toString();
    }
}
