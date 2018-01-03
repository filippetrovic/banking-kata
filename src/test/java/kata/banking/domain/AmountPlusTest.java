package kata.banking.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class AmountPlusTest {

    @Parameters(name = "{0} + {1} = {2}")
    public static Iterable<Object[]> testCases() {
        return Arrays.asList(
                new Object[]{1, 2, 3},
                new Object[]{-1, -1, -2},
                new Object[]{-1, 1, 0},
                new Object[]{4, -1, 3},
                new Object[]{2, -10, -8},
                new Object[]{-1, 10, 9},
                new Object[]{-10, 1, -9}
        );
    }

    private final int first;
    private final int second;
    private final int expected;

    public AmountPlusTest(int first, int second, int expected) {
        this.first = first;
        this.second = second;
        this.expected = expected;
    }

    @Test
    public void test() {
        final Amount result = Amount.ofSigned(first).plus(Amount.ofSigned(second));

        assertThat(result).isEqualTo(Amount.ofSigned(expected));
    }
}
