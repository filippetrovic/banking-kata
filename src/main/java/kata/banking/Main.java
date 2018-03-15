package kata.banking;

import kata.banking.domain.AccountImplementation;
import kata.banking.domain.TransactionHistory;
import kata.banking.output.TransactionFormatter;
import kata.banking.output.TransactionListFormatter;
import kata.banking.service.TimeProvider;

public class Main {

    public static void main(String[] args) {

        final Account account = new Account(
             new AccountImplementation(
                  new TransactionHistory(),
                  new TimeProvider()
             ),
             new TransactionListFormatter(new TransactionFormatter())
        );

        account.withdraw(100);
        account.deposit(300);
        account.withdraw(200);

        System.out.println(account.printStatement());

        account.deposit(1000);
        account.deposit(1000);
        account.withdraw(500);

        System.out.println(account.printStatement());

    }

}
