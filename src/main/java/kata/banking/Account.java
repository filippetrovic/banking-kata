package kata.banking;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    public static final String HEADER = "Date\tAmount\tBalance\n";

    private List<String> transactionHistory = new LinkedList<>();
    private int totalBalance;

    public void deposit(int amount) {
        totalBalance += amount;
        transactionHistory.add("+" + amount + "\t" + totalBalance);
    }

    public void withdraw(int amount) {

    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (transactionHistory.size() > 0) {
            return transactionHistory.stream()
                    .collect(Collectors.joining("\n"));
        }

        return statementBuilder.toString();
    }
}
