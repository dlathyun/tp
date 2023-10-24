package seedu.address.model.localcourse;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.SeplendidDataType;

/**
 * Represents a Local Course in SEPlendid.
 * Guarantees: details are present and not null, field values are validated and immutable.
 */
public class LocalCourse implements SeplendidDataType {

    // Identity fields
    private final LocalCode localCode;

    // Data fields
    private final LocalName localName;
    private final LocalUnit localUnit;

    /**
     * Every field must be present and not null
     */
    public LocalCourse(LocalCode localCode, LocalName localName, LocalUnit localUnit) {
        requireAllNonNull(localCode, localName, localUnit);
        this.localCode = localCode;
        this.localName = localName;
        this.localUnit = localUnit;
    }

    // Getters
    public LocalCode getLocalCode() {
        return localCode;
    }

    public LocalName getLocalName() {
        return localName;
    }

    public LocalUnit getLocalUnit() {
        return localUnit;
    }

    /**
     * Returns true if both LocalCourses have the same localCode.
     * Assumption: localCode is the primary key i.e. there exists
     * no two distinct LocalCourses with the same localCode.
     *
     * @param otherLocalCourse This is the other local course.
     */
    public boolean isSameLocalCourse(LocalCourse otherLocalCourse) {
        if (otherLocalCourse == this) {
            return true;
        }

        return otherLocalCourse != null
                && otherLocalCourse.getLocalCode().equals(getLocalCode());
    }

    /**
     * Returns true if both LocalCourses have the same identity and data fields.
     * This defines a stronger notion of equality between two local courses.
     *
     * @param other The other presumably LocalCourse object to compare with.
     * @return true if both objects are equal.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LocalCourse)) {
            return false;
        }

        LocalCourse otherLocalCourse = (LocalCourse) other;
        return localCode.equals(otherLocalCourse.localCode)
                && localName.equals(otherLocalCourse.localName)
                && localUnit.equals(otherLocalCourse.localUnit);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(localCode, localName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("localCode", localCode)
                .add("localName", localName)
                .add("localUnit", localUnit)
                .toString();
    }
}
