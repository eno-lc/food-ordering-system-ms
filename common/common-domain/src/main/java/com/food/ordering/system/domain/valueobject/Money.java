package com.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author Enis Halilaj
 * Money is a value object that represents a monetary amount.
 * Uses BigDecimal to represent the amount.
 * It is immutable.
 */

public class Money {
    private final BigDecimal amount;
    public static final Money ZERO = new Money(BigDecimal.ZERO);
    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


    /**
     * @return boolean
     * We use compareTo() method to compare two BigDecimal objects.
     * We do not use equals() method because it is not suitable for comparing BigDecimal objects.
     * isGreaterThanZero() method returns true if the amount of the money is greater than zero.
     */
    public boolean isGreaterThanZero(){
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * @param money
     * @return boolean
     * We use compareTo() method to compare two BigDecimal objects.
     * We do not use equals() method because it is not suitable for comparing BigDecimal objects.
     * isGreaterThan() method returns true if the amount of the money is greater than the amount of the money passed as a parameter.
     */
    public boolean isGreaterThan(Money money){
        return this.amount != null && this.amount.compareTo(money.getAmount()) > 0;
    }

    /**
     * @param money
     * @return Money
     * We use add() method to add an amount to the money.
     */
    public Money add(Money money){
        return new Money(setScale(this.amount.add(money.getAmount())));
    }

    /**
     * @param money
     * @return Money
     * We use subtract() method to subtract an amount from the money.
     */
    public Money subtract(Money money){
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }


    /**
     * @param multiplier
     * @return Money
     * We use multiply() method to multiply the money by a multiplier.
     */
    public Money multiply(int multiplier){
        return new Money(setScale(this.amount.multiply(BigDecimal.valueOf(multiplier))));
    }

    /**
     * @param input
     * @return BigDecimal with 2 decimal places
     * We use HALF_EVEN rounding mode.
     * HALF_EVEN is the default rounding mode for BigDecimal.
     * HALF_EVEN is the rounding mode that minimizes cumulative error when applied repeatedly over a sequence of calculations.
     * It is a general-purpose rounding mode that is usually the best choice for applications whose monetary amounts are represented in decimal form.
     * setScale() method returns a BigDecimal whose value is equal to this BigDecimal, with the scale of this BigDecimal set to the specified value.
     */
    private BigDecimal setScale(BigDecimal input){
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
