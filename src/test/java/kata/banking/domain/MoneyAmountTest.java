package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyAmountTest {

    @Test
    public void shouldCreateNegativeAmount() {

        final MoneyAmount negative = MoneyAmount.negative(300);

        assertThat(negative.intValue())
                .isNegative()
                .isEqualTo(-300);

    }

    @Test
    public void shouldCreatePositiveAmount() {

        final MoneyAmount negative = MoneyAmount.positive(300);

        assertThat(negative.intValue())
                .isPositive()
                .isEqualTo(300);

    }

    @Test
    public void shouldCreateZeroAmount() {
        final MoneyAmount zero = MoneyAmount.zero();

        assertThat(zero.intValue())
                .isEqualTo(0);
    }

    @Test
    public void shouldNegateAmount() {
        // given
        final MoneyAmount negativeAmount = MoneyAmount.negative(300);

        // when
        final MoneyAmount positiveAmount = negativeAmount.negative();

        // then
        assertThat(positiveAmount.intValue())
                .isPositive()
                .isEqualTo(300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeIsUsedWithNegative() {
        MoneyAmount.negative(-300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeIsUsedWithZero() {
        MoneyAmount.negative(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPositiveIsUsedWithNegative() {
        MoneyAmount.positive(-400);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPositiveIsUsedWithZero() {
        MoneyAmount.positive(0);
    }
}
