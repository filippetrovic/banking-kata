package kata.banking;

import kata.banking.domain.BalanceLog;

import java.util.stream.Collectors;

public class Account {

    public static final String HEADER = "Date\tAmount\tBalance\n";

    private final BalanceLog balanceLog = new BalanceLog();

    public void deposit(int amount) {
        balanceLog.deposit(amount);
    }

    public void withdraw(int amount) {

    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (balanceLog.getTransactionHistory().size() > 0) {
            return balanceLog.getTransactionHistory().stream()
                    .collect(Collectors.joining("\n"));
        }

        return statementBuilder.toString();
    }
}
