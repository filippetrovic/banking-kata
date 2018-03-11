package kata.banking.output;

import kata.banking.domain.Transaction;

import java.util.Objects;

public class TransactionFormatter {

    public TransactionFormatter() {
    }

    public String formatTransaction(Transaction transaction) {
        Objects.requireNonNull(transaction, "Transaction can not null");

        return String.format("%1$td.%1$tm.%1$tY\t%2$+d\t%3$d",
             transaction.getTime(),
             transaction.getTransactionAmount().intValue(),
             transaction.getBalance().intValue());
    }
}