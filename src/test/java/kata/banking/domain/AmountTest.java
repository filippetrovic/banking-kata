package kata.banking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void shouldCreateNegativeAmount() {

        final Amount negative = Amount.negative(300);

        assertThat(negative.getAmount())
                .isNegative()
                .isEqualTo(-300);

    }

    @Test
    public void shouldCreatePositiveAmount() {

        final Amount negative = Amount.positive(300);

        assertThat(negative.getAmount())
                .isPositive()
                .isEqualTo(300);

    }

    @Test
    public void shouldCreateZeroAmount() {
        final Amount zero = Amount.zero();

        assertThat(zero.getAmount())
                .isEqualTo(0);
    }

    @Test
    public void shouldNegateAmount() {
        // given
        final Amount negativeAmount = Amount.negative(300);

        // when
        final Amount positiveAmount = negativeAmount.negative();

        // then
        assertThat(positiveAmount.getAmount())
                .isPositive()
                .isEqualTo(300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeIsUsedWithNegative() {
        Amount.negative(-300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativeIsUsedWithZero() {
        Amount.negative(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPositiveIsUsedWithNegative() {
        Amount.positive(-400);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenPositiveIsUsedWithZero() {
        Amount.positive(0);
    }
}
