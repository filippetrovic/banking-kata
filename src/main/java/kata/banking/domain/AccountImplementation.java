package kata.banking.domain;

import kata.banking.service.TimeProvider;

import java.util.List;

public class AccountImplementation {

    private TransactionHistory transactionHistory = new TransactionHistory();
    private TimeProvider timeProvider = new TimeProvider();

    public AccountImplementation() {
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