package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.localcourse.LocalCourse;
import seedu.address.model.notes.Note;
import seedu.address.model.partnercourse.PartnerCourse;
import seedu.address.model.university.University;

/**
 * The API of the SeplendidModel component.
 * Add appropriate methods for respective sub-models.
 */
public interface SeplendidModel {

    //=========== UserPrefs ==================================================================================
    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' LocalCourseCatalogue file path.
     */
    Path getLocalCourseCatalogueFilePath();

    /**
     * Sets the user prefs' LocalCourseCatalogue file path.
     */
    void setLocalCourseCatalogueFilePath(Path localCourseCatalogueFilePath);

    //=========== LocalCourseCatalogue ================================================================================

    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<LocalCourse> PREDICATE_SHOW_ALL_LOCAL_COURSES = unused -> true;

    /**
     * Replaces localcourse list data with the data in {@code localCourseCatalogue}.
     */
    void setLocalCourseCatalogue(ReadOnlyLocalCourseCatalogue localCourseCatalogue);

    /**
     * Returns the LocalCourse list.
     */
    ReadOnlyLocalCourseCatalogue getLocalCourseCatalogue();

    /**
     * Returns true if a local course with the same identity as {@code localCourse} exists in the LocalCourseCatalogue.
     */
    boolean hasLocalCourse(LocalCourse localCourse);

    /**
     * Deletes the given local course.
     * The local course must exist in the LocalCourseCatalogue.
     */
    void deleteLocalCourse(LocalCourse localCourse);

    /**
     * Adds the given LocalCourse.
     * {@code localCourse} must not already exist in the LocalCourseCatalogue.
     */
    void addLocalCourse(LocalCourse localCourse);

    /**
     * Replaces the given localCourse {@code target} with {@code editedLocalCourse}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedLocalCourse} must not be the same as another
     * existing localCourse in the LocalCourseCatalogue.
     */
    void setLocalCourse(LocalCourse localCourse, LocalCourse editedLocalCourse);

    //=========== FilteredLocalCourseList Accessors =============================================================

    /**
     * Returns an unmodifiable view of the filtered local course list
     */
    ObservableList<LocalCourse> getFilteredLocalCourseList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredLocalCourseList(Predicate<LocalCourse> predicate);

    //=========== PartnerCourseCatalouge ============================================================================

    Predicate<PartnerCourse> PREDICATE_SHOW_ALL_PARTNER_COURSES = unused -> true;
    ReadOnlyPartnerCourseCatalogue getPartnerCourseCatalogue();
    /**
     * Returns true if a partner course with the same identity as {@code partnerCourse} exists in the
     * PartnerCourseCatalogue.
     */
    boolean hasPartnerCourse(PartnerCourse partnerCourse);

    /**
     * Adds the given PartnerCourse.
     * {@code partnerCourse} must not already exist in the PartnerCourseCatalogue.
     */
    void addPartnerCourse(PartnerCourse partnerCourse);

    /**
     * Returns an unmodifiable view of the filtered partner course list
     */
    ObservableList<PartnerCourse> getFilteredPartnerCourseList();

    void updateFilteredPartnerCourseList(Predicate<PartnerCourse> predicate);

    //=========== UniversityCatalouge ================================================================================
    Predicate<University> PREDICATE_SHOW_ALL_UNIVERSITIES = unused -> true;

    void updateUniversityList(Predicate<University> predicate);

    //=========== NoteCatalouge ================================================================================
    /**
     * Adds the given Note.
     */
    void addNote(Note note);
}
