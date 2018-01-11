package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TransactionHistory {

    private LinkedList<Transaction> transactionHistory = new LinkedList<>();

    public TransactionHistory() {
    }

    public List<Transaction> getHistory() {
        return transactionHistory;
    }

    public void addToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public Optional<Transaction> getLastTransaction() {

        if (transactionHistory.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(transactionHistory.getLast());
    }
}