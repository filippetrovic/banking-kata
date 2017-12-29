package kata.banking;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AccountTest {

    @Test
    public void shouldReturnHeader() {

        Account account = new Account();

        String header = account.printStatement();

        Assertions.assertThat(header).isEqualTo(Account.HEADER);
    }


}
