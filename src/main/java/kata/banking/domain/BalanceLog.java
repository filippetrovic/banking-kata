package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class BalanceLog {

    private List<Transaction> transactions = new LinkedList<>();
    private int totalBalance;

    public BalanceLog() {
    }

    public void logTransaction(TransactionCommand transactionCommand) {
        totalBalance += transactionCommand.getSignedAmount();
        transactions.add(new Transaction(transactionCommand.getSignedAmount(), totalBalance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}