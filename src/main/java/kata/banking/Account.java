package kata.banking;

public class Account {

    public static final String HEADER = "Date\tAmount\tBalance\n";

    private int balance;
    private int deposit;

    public void deposit(int amount) {
        balance = amount;
        deposit = amount;
    }

    public void withdraw(int amount) {

    }

    public String printStatement() {
        final StringBuilder statementBuilder = new StringBuilder(HEADER);

        if (balance > 0) {
            statementBuilder.append("+").append(deposit);
            statementBuilder.append("\t").append(balance);
        }

        return statementBuilder.toString();
    }
}
