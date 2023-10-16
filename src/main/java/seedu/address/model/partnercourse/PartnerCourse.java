package seedu.address.model.partnercourse;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
public class PartnerCourse {
    private final PartnerUniversity partnerUniversity;
    private final PartnerCode partnerCode;
    private final PartnerName partnerName;

    public PartnerCourse(PartnerUniversity pu, PartnerCode pc, PartnerName pn) {
        requireAllNonNull(pu, pc, pn);
        partnerUniversity = pu;
        partnerCode = pc;
        partnerName = pn;
    }
    public PartnerUniversity getPartnerUniversity() {
        return partnerUniversity;
    }

    public PartnerCode getPartnerCode() {
        return partnerCode;
    }

    public PartnerName getPartnerName() {
        return partnerName;
    }

    public boolean isSamePartnerCourse(PartnerCourse otherPartnerCourse) {
        if (otherPartnerCourse == this) {
            return true;
        }

        if (otherPartnerCourse == null) {
            return false;
        }

        return otherPartnerCourse.getPartnerCode().equals(getPartnerCode());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PartnerCourse)) {
            return false;
        }

        PartnerCourse otherPartnerCourse = (PartnerCourse) other;
        return partnerUniversity.equals(otherPartnerCourse.partnerUniversity)
                && partnerCode.equals(otherPartnerCourse.partnerCode)
                && partnerName.equals(otherPartnerCourse.partnerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerUniversity, partnerCode, partnerName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("partnerUniversity", partnerUniversity)
                .add("partnerCode", partnerCode)
                .add("partnerName", partnerName)
                .toString();
    }
}
