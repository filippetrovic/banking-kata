package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class BalanceLog {

    private List<String> transactionHistory = new LinkedList<>();
    private int totalBalance;

    public BalanceLog() {
    }

    public void deposit(int amount) {
        totalBalance += amount;
        getTransactionHistory().add("+" + amount + "\t" + totalBalance);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

}