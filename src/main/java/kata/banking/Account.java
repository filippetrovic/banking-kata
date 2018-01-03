package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.TransactionCommand;

import java.util.stream.Collectors;

public class Account {

    public static final String HEADER = "Date\tMoneyAmount\tBalance\n";

    private final AccountImplementation accountImplementation = new AccountImplementation();

    public void deposit(int amount) {
        accountImplementation.logTransaction(TransactionCommand.of(MoneyAmount.positive(amount)));
    }

    public void withdraw(int amount) {
        accountImplementation.logTransaction(TransactionCommand.of(MoneyAmount.negative(amount)));
    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (accountImplementation.getTransactions().size() > 0) {
            return accountImplementation.getTransactions().stream()
                    .map(transaction -> String.format("???\t%+d\t%d",
                            transaction.getMoneyAmount().intValue(),
                            transaction.getBalance().intValue()))
                    .collect(Collectors.joining("\n"));
        }

        return statementBuilder.toString();
    }
}
