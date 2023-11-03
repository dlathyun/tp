package seedu.address.logic.parser.note;


import static seedu.address.logic.parser.CliSyntax.PARAMETER_INDEX;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_TAGS;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import seedu.address.logic.commands.UsageMessage;
import seedu.address.logic.commands.note.NoteTagCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.SeplendidArgumentMap;
import seedu.address.logic.parser.SeplendidArgumentTokenizer;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

/**
 * Parses the given {@code String} of arguments in the context of the TagCommand
 * and returns a TagCommand object for execution.
 * @throws ParseException if the user input does not conform the expected format
 */
public class NoteTagCommandParser implements Parser<NoteTagCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the NoteTagCommand
     * and returns a NoteTagCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteTagCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(UsageMessage.NOTE_TAG.getValue());
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_INDEX, PARAMETER_TAGS);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_INDEX, PARAMETER_TAGS)) {
            throw new ParseException(UsageMessage.NOTE_TAG.getValue());
        }

        // All arguments should be a non-empty {@code Optional}

        try {
            int noteIndex = Integer.parseInt(parameterToArgMap.getValue(PARAMETER_INDEX).get());
            Tag newTag = new Tag(parameterToArgMap.getValue(PARAMETER_TAGS).get());
            return new NoteTagCommand(noteIndex, newTag);
        } catch (NumberFormatException e) {
            throw new ParseException(UsageMessage.NOTE_TAG.getValue());
        }
    }
}
