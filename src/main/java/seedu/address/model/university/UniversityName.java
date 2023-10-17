package seedu.address.model.university;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class UniversityName {
    public static final String MESSAGE_CONSTRAINTS = "UniversityName can take any values, and it should not be blank";

    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    public UniversityName(String universityname) {
        requireNonNull(universityname);
        checkArgument(isValidUniversityName(universityname), MESSAGE_CONSTRAINTS);
        value = universityname;
    }

    public static boolean isValidUniversityName(String test) {
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

        if (!(other instanceof UniversityName)) {
            return false;
        }

        UniversityName otherUniversityName = (UniversityName) other;
        return value.equals(otherUniversityName.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
