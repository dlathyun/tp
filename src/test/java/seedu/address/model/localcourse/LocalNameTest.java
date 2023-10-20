package seedu.address.model.localcourse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalObjects.EDGE_CASE_VALID_LOCAL_COURSE_NAME;
import static seedu.address.testutil.TypicalObjects.TYPICAL_LOCAL_COURSE_NAME;

import org.junit.jupiter.api.Test;

public class LocalNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PartnerName(null));
    }

    @Test
    public void constructor_invalidLocalName_throwsIllegalArgumentException() {
        String invalidLocalName = "";
        assertThrows(IllegalArgumentException.class, () -> new PartnerName(invalidLocalName));
    }

    @Test
    public void isValidLocalName() {
        // null localName
        assertThrows(NullPointerException.class, () -> PartnerName.isValidLocalName(null));

        // invalid localName
        assertFalse(PartnerName.isValidLocalName("")); // empty string
        assertFalse(PartnerName.isValidLocalName(" ")); // spaces only
        assertFalse(PartnerName.isValidLocalName(" How to Cook Potatoes")); // first character space

        // valid localName`
        assertTrue(PartnerName.isValidLocalName("How to Eat Potatoes")); // alphabets only
        assertTrue(PartnerName.isValidLocalName("Decoding with Alyssa :D")); // alphanumeric, with symbols
        assertTrue(PartnerName.isValidLocalName(TYPICAL_LOCAL_COURSE_NAME)); // alphanumeric characters
    }

    @Test
    public void equals() {
        PartnerName localName = new PartnerName(TYPICAL_LOCAL_COURSE_NAME);

        // same values -> returns true
        assertTrue(localName.equals(new PartnerName(TYPICAL_LOCAL_COURSE_NAME)));

        // same object -> returns true
        assertTrue(localName.equals(localName));

        // null -> returns false
        assertFalse(localName.equals(null));

        // different types -> returns false
        assertFalse(localName.equals(5.0f));

        // different values -> returns false
        assertFalse(localName.equals(new PartnerName(EDGE_CASE_VALID_LOCAL_COURSE_NAME)));
    }
}
