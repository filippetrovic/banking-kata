package kata.banking.output;

import kata.banking.domain.Transaction;

import java.util.Objects;

public class TransactionFormatter {

    public TransactionFormatter() {
    }

    public String formatTransaction(Transaction transaction) {
        Objects.requireNonNull(transaction, "Transaction can not null");

        return String.format("???\t%+d\t%d",
             transaction.getTransactionAmount().intValue(),
             transaction.getBalance().intValue());
    }
}