package kata.banking.output;

import kata.banking.domain.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionListFormatter {

    public static final String HEADER = "Date\tMoneyAmount\tBalance\n";

    public String format(List<Transaction> transactionList) {
        if (transactionList.isEmpty()) {
            return HEADER;
        }

        return transactionList.stream()
             .map(transaction -> String.format("???\t%+d\t%d",
                  transaction.getTransactionAmount().intValue(),
                  transaction.getBalance().intValue()))
             .collect(Collectors.joining("\n"));
    }

}