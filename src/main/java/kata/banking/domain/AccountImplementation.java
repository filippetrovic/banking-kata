package kata.banking.domain;

import kata.banking.service.TimeProvider;

import java.util.LinkedList;
import java.util.List;

public class AccountImplementation {

    private List<Transaction> transactions = new LinkedList<>();
    private MoneyAmount accountBalance = MoneyAmount.zero();
    private TimeProvider timeProvider = new TimeProvider();

    public AccountImplementation() {
    }

    public void executeTransaction(TransactionCommand transactionCommand) {
        accountBalance = accountBalance.plus(transactionCommand.getMoneyAmount());

        final Transaction transaction = new Transaction(
                timeProvider.getCurrentTime(),
                transactionCommand.getMoneyAmount(),
                accountBalance);

        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}