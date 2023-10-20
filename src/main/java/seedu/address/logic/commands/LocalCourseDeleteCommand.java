package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.SeplendidModel;
import seedu.address.model.localcourse.LocalCode;
import seedu.address.model.localcourse.LocalCourse;

/**
 * Deletes a local course identified using its local code from the address book.
 */
public class LocalCourseDeleteCommand extends LocalCourseCommand {

    public static final String LOCAL_COURSE_DELETE_MESSAGE_USAGE = COMMAND_WORD
            + " delete [localcode]: Deletes a local course.";
    public static final String ACTION_WORD = "delete";

    public static final String MESSAGE_SUCCESS = "Deleted Local Course: %1$s";
    public static final String MESSAGE_NONEXISTENT_LOCAL_COURSE = "This local course does not exist in SEPlendid.";

    private final LocalCode localCodeToDelete;

    /**
     * Creates a LocalCourseDeleteCommand to delete  the specified {@code LocalCode}
     *
     * @param localCode The localCode that identifies the localCourse to be deleted.
     */
    public LocalCourseDeleteCommand(LocalCode localCode) {
        requireNonNull(localCode);
        this.localCodeToDelete = localCode;
    }

    /**
     * TBD: This stub is to be removed after morphing is complete.
     *
     * @param model {@code Model} which the command should operate on.
     * @return Nothing.
     * @throws CommandException Always.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException("TBD: this is a stub and should be removed after morph.");
    }

    @Override
    public CommandResult execute(SeplendidModel seplendidModel) throws CommandException {
        requireNonNull(seplendidModel);

        // There should be no duplicates
        Optional<LocalCourse> localCourseToDelete = seplendidModel.getLocalCourseIfExists(localCodeToDelete);
        if (localCourseToDelete.isEmpty()) {
            throw new CommandException(MESSAGE_NONEXISTENT_LOCAL_COURSE);
        }
        localCourseToDelete.ifPresent(seplendidModel::deleteLocalCourse);
        // At this point we can already assume localCourseToDelete is not empty.
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(localCourseToDelete.get())));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LocalCourseDeleteCommand)) {
            return false;
        }

        LocalCourseDeleteCommand otherLocalCourseDeleteCommand = (LocalCourseDeleteCommand) other;
        return localCodeToDelete.equals(otherLocalCourseDeleteCommand.localCodeToDelete);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("localCourseToDelete", localCodeToDelete)
                .toString();
    }
}
