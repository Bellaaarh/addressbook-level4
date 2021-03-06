package seedu.address.model.transaction;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the type of transaction recorded in the database.
 * Guarantees: immutable; is valid as declared in {@link #isValidType(String)}
 */
public class Type {
    public static final String MESSAGE_TRANSACTION_TYPE_CONSTRAINTS =
            "The transaction must be either a loan/debt";
    public final String value;

    /**
     * Constructs an {@code Type}.
     *
     * @param Type A valid transaction type.
     */
    public Type(String Type) {
        requireNonNull(Type);
        checkArgument(isValidType(Type), MESSAGE_TRANSACTION_TYPE_CONSTRAINTS);
        value = Type;
    }


    /**
     * Returns true if a given string is a valid transaction amount.
     *
     * @param test the command line argument to be parsed
     */
    public static boolean isValidType(String test) {
        String lower = test.toLowerCase();
        return lower.equals("loan") || lower.equals("debt");
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Type)) {
            return false;
        }
        Type Type = (Type) other;
        return other == this || value.equals(Type.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
