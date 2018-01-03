package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class BalanceLog {

    private List<Transaction> transactions = new LinkedList<>();
    private int totalBalance;

    public BalanceLog() {
    }

    public void deposit(int amount) {
        totalBalance += amount;
        transactions.add(new Transaction(amount, totalBalance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}