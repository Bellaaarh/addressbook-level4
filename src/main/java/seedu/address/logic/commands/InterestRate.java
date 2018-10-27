package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;

import seedu.address.model.transaction.Interest;


/**
 * Represents the interest value and the given scheme .
 */
public class InterestRate {
    public static final String MESSAGE_INTEREST_RATE_CONSTRAINTS =
            "Interest value should be a real number rounded to two decimal places";
    public static final String TRANSACTION_INTEREST_RATE_VALIDATION_REGEX = "\\d{1,2}.\\d{1,2}\\%";
    public final double value;

    public InterestRate(String interestRate) {
        requireNonNull(interestRate);
        checkArgument(isValidInterestRate(interestRate), MESSAGE_INTEREST_RATE_CONSTRAINTS);
        this.value = Double.parseDouble(interestRate.replace("%", ""));
    }

    public double getValue() {
        return value;
    }

    /**
     * Returns true if the given string contains valid parameters for interest calculation.
     *
     * @param test the command line argument to be parsed
     */
    public static boolean isValidInterestRate(String test) {
        return test.toLowerCase().matches(TRANSACTION_INTEREST_RATE_VALIDATION_REGEX);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Interest)) {
            return false;
        }
        InterestRate interestRate = (InterestRate) other;
        return other == this || (interestRate.value == interestRate.value);
    }

    @Override
    public String toString() {
        return "" + value + "%";
    }
}
