package seedu.address.model.partnercourse;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
public class PartnerUniversity {
    public static final String MESSAGE_CONSTRAINTS = "PartnerUniversity can take any values, and it should not be blank";
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    public PartnerUniversity(String partnerUniversity) {
        requireNonNull(partnerUniversity);
        checkArgument(isValidParnerUniversity(partnerUniversity), MESSAGE_CONSTRAINTS);
        value = partnerUniversity;
    }

    public static boolean isValidParnerUniversity(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerUniversity)) {
            return false;
        }

        PartnerUniversity otherPartnerUniversity = (PartnerUniversity) other;

        return value.equals(otherPartnerUniversity.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
