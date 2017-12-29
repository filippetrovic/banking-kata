package kata.banking;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    public static final String HEADER = "Date\tAmount\tBalance\n";

    private int balance;
    private int deposit;

    private List<String> transactionHistory = new LinkedList<>();
    private int totalBalance;

    public void deposit(int amount) {
        balance = amount;
        deposit = amount;
        totalBalance += amount;
        transactionHistory.add("+" + amount + "\t" + totalBalance);
    }

    public void withdraw(int amount) {

    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (transactionHistory.size() > 1) {
            return transactionHistory.stream()
                    .collect(Collectors.joining("\n"));
        }

        if (balance > 0) {
            statementBuilder.append("+").append(deposit);
            statementBuilder.append("\t").append(balance);
        }

        return statementBuilder.toString();
    }
}
