package seedu.address.messages;

/**
 * Enum for model constraint messages.
 */
public enum ConstraintMessage {
    // LocalCourse messages
    LOCALCOURSE_CODE(
        "LocalCode:\n"
        + "Must be non-empty\n"
        + "Must only contain alphanumeric characters\n"
        + "Be no more than 10 characters long\n"),

    LOCALCOURSE_NAME(
       "LocalName:\n"
        + "Must be non-empty\n"
        + "Must be between 1-76 characters long\n"),

    LOCALCOURSE_UNIT(
        "LocalUnit:\n"
        + "Must be non-empty\n"
        + "Must be a numeric value between 0 and 10000\n"),

    LOCALCOURSE_DESCRIPTION("LocalDescription must:\n"
                            + "Must be non-empty\n"),

    LOCALCOURSE_ATTRIBUTE_SEARCH(
        "There are only 3 attributes available for localcourse search:\n"
        + "localcode\n"
        + "localname\n"
        + "localdescription\n"),

    LOCALCOURSE_ATTRIBUTE_SORT(
        "There are only 2 attributes available for localcourse sort:\n"
        + "localcode\n"
        + "localname\n"),

    LOCALCOURSE_ATTRIBUTE_UPDATE(
        "There are only 4 attributes available for localcourse update:\n"
        + "localcode\n"
        + "localname\n"
        + "localunit\n"
        + "localdescription\n"),

    // PartnerCourse messages
    PARTNERCOURSE_CODE(
        "PartnerCode:\n"
        + "Must be non-empty\n"
        + "Must only contain alphanumeric characters\n"
        + "Be no more than 10 characters long\n"),

    PARTNERCOURSE_NAME(
        "PartnerName:\n"
        + "Must not be blank\n"),

    PARTNERCOURSE_UNIT(
        "PartnerUnit:\n"
        + "Must be non-empty\n"
        + "Must be a non-negative numeric value\n"),

    PARTNERCOURSE_DESCRIPTION(
        "PartnerDescription must:\n"
        + "Must be non-empty\n"),

    PARTNERCOURSE_ATTRIBUTE_SEARCH(
        "There are only 4 attributes available for partnercourse search:\n"
        + "partnercode\n"
        + "partnername\n"
        + "description\n"
        + "university\n"),

    PARTNERCOURSE_ATTRIBUTE_SORT(
        "There are only 3 attributes available for partnercourse sort:\n"
        + "partnercode\n"
        + "partnername\n"
        + "university\n"),

    PARTNERCOURSE_ATTRIBUTE_UPDATE(
        "There are only 4 attributes available for partnercourse update:\n"
        + "partnercode\n"
        + "partnername\n"
        + "partnerunit\n"
        + "description\n"),

    // Mapping messages
    MAPPING_ATTRIBUTE_SEARCH(
        "There are only 6 available for mapping search:\n"
        + "localcode\n"
        + "localname\n"
        + "partnercode\n"
        + "partnername\n"
        + "university\n"
        + "information\n"),

    MAPPING_ATTRIBUTE_SORT(
        "There are only 6 available for mapping sort:\n"
        + "localcode\n"
        + "localname\n"
        + "partnercode\n"
        + "partnername\n"
        + "university\n"
        + "information\n"),

    // University messages
    UNIVERSITY_NAME(
        "UniversityName:\n"
        + "Must be non-empty"),

    UNIVERSITY_ATTRIBUTE_SEARCH(
        "There is only 1 available for university search:\n"
        + "university\n"),

    UNIVERSITY_ATTRIBUTE_SORT(
        "There is only 1 available for university sort:\n"
        + "university\n"),

    // Note messages
    NOTE_CONTENT(
        "Content:\n"
        + "Must only contain alphanumeric characters or spaces\n"
        + "Must be non-empty"),

    // Tag messages
    TAG_NAME(
        "Tag:\n"
        + "Must only contain alphanumeric characters\n"
        + "Must not contain whitespaces");

    private final String value;

    /**
     * Constructs a ConstraintMessage with the specified value.
     *
     * @param description The usage message value.
     */
    ConstraintMessage(String description) {
        this.value = description;
    }

    /**
     * Gets the value of the constraint message.
     *
     * @return The usage message value.
     */
    @Override
    public String toString() {
        return value;
    }
}
