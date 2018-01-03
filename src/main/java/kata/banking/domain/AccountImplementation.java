package kata.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class AccountImplementation {

    private List<Transaction> transactions = new LinkedList<>();
    private MoneyAmount accountBalance = MoneyAmount.zero();

    public AccountImplementation() {
    }

    public void executeTransaction(TransactionCommand transactionCommand) {
        accountBalance = accountBalance.plus(transactionCommand.getMoneyAmount());
        transactions.add(new Transaction(transactionCommand.getMoneyAmount(), accountBalance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}