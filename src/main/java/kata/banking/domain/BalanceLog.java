package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class BalanceLog {

    private List<Transaction> transactions = new LinkedList<>();
    private MoneyAmount accountBalance = MoneyAmount.zero();

    public BalanceLog() {
    }

    public void logTransaction(TransactionCommand transactionCommand) {
        accountBalance = accountBalance.plus(transactionCommand.getMoneyAmount());
        transactions.add(new Transaction(transactionCommand.getMoneyAmount(), accountBalance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}