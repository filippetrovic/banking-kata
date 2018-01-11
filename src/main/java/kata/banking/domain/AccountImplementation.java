package kata.banking.domain;

import kata.banking.service.TimeProvider;

import java.util.List;

public class AccountImplementation {

    private final TransactionHistory transactionHistory = new TransactionHistory();
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

        transactionHistory.addToHistory(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionHistory.getHistory();
    }
}