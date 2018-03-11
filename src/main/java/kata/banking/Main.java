package kata.banking;

public class Main {

    public static void main(String [] args) {

        final Account account = new Account();

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
