package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class TransactionHistory {

    private List<Transaction> transactionHistory = new LinkedList<>();

    public TransactionHistory() {
    }

    public List<Transaction> getHistory() {
        return transactionHistory;
    }

    public void addToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }
}