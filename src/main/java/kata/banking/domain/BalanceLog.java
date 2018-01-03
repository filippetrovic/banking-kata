package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class BalanceLog {

    private List<Transaction> transactions = new LinkedList<>();
    private Amount totalBalanceAmount = Amount.zero();

    public BalanceLog() {
    }

    public void logTransaction(TransactionCommand transactionCommand) {
        totalBalanceAmount = totalBalanceAmount.plus(transactionCommand.getAmount());
        transactions.add(new Transaction(transactionCommand.getAmount().getAmount(), totalBalanceAmount.getAmount()));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}