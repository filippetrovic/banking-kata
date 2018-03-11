package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.MoneyAmount;
import kata.banking.domain.TransactionCommand;
import kata.banking.output.TransactionListFormatter;

public class Account {

    private AccountImplementation accountImplementation = new AccountImplementation();
    private TransactionListFormatter transactionListFormatter = new TransactionListFormatter();

    public void deposit(int amount) {
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.positive(amount)));
    }

    public void withdraw(int amount) {
        accountImplementation.executeTransaction(TransactionCommand.of(MoneyAmount.negative(amount)));
    }

    public String printStatement() {
        return transactionListFormatter.format(accountImplementation.getTransactions());
    }

}
