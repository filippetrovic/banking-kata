package kata.banking.output;

import kata.banking.domain.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionListFormatter {

    public static final String HEADER = "Date\tMoneyAmount\tBalance\n";

    private TransactionFormatter transactionFormatter;

    public TransactionListFormatter(TransactionFormatter transactionFormatter) {
        this.transactionFormatter = transactionFormatter;
    }

    public String format(List<Transaction> transactionList) {
        return transactionList.stream()
             .map(transactionFormatter::formatTransaction)
             .collect(Collectors.joining("\n", HEADER, ""));
    }

}