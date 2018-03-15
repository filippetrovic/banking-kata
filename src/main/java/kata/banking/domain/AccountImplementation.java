package kata.banking.domain;

import kata.banking.service.TimeProvider;

import java.util.List;

public class AccountImplementation {

    private TransactionHistory transactionHistory;
    private TimeProvider timeProvider;

    public AccountImplementation(TransactionHistory transactionHistory, TimeProvider timeProvider) {
        this.transactionHistory = transactionHistory;
        this.timeProvider = timeProvider;
    }

    public void executeTransaction(TransactionCommand transactionCommand) {
        MoneyAmount accountBalanceBeforeThisTransaction = transactionHistory.getLastTransaction()
                .map(Transaction::getBalance)
                .orElse(MoneyAmount.zero());

        final MoneyAmount newAccountBalance = accountBalanceBeforeThisTransaction
                .plus(transactionCommand.getMoneyAmount());

        final Transaction transaction = new Transaction(
                timeProvider.getCurrentTime(),
                transactionCommand.getMoneyAmount(),
                newAccountBalance);

        transactionHistory.addToHistory(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionHistory.getHistory();
    }
}