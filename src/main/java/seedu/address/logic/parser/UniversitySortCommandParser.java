package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PARAMETER_UNIVERSITYATTRIBUTE;
import static seedu.address.logic.parser.ParserUtil.areValuesEnclosedAndNonEmpty;

import java.util.Comparator;

import seedu.address.logic.commands.university.UniversitySortCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.university.University;
import seedu.address.model.university.UniversityAttribute;
import seedu.address.model.university.comparator.UniversityComparatorByUniversityName;

/**
 * Parses input arguments and creates a new UniversitySortCommand object.
 */
public class UniversitySortCommandParser implements Parser<UniversitySortCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UniversitySortCommand
     * and returns a UniversitySortCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public UniversitySortCommand parse(String args) throws ParseException {
        if (!areValuesEnclosedAndNonEmpty(args)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UniversitySortCommand.UNIVERSITY_SORT_MESSAGE_USAGE));
        }

        SeplendidArgumentMap parameterToArgMap =
                SeplendidArgumentTokenizer.tokenize(args, PARAMETER_UNIVERSITYATTRIBUTE);

        if (!ParserUtil.areArgumentsPresent(parameterToArgMap, PARAMETER_UNIVERSITYATTRIBUTE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    UniversitySortCommand.UNIVERSITY_SORT_MESSAGE_USAGE));
        }

        Comparator<University> universityComparator =
                parseUniversityComparator(parameterToArgMap.getValue(PARAMETER_UNIVERSITYATTRIBUTE).get());

        return new UniversitySortCommand(universityComparator);
    }

    private Comparator<University> parseUniversityComparator(String args) throws ParseException {
        UniversityAttribute universityAttribute = ParserUtil.parseUniversityAttribute(args);
        switch(universityAttribute) {
        case UNIVERSITYNAME:
            return new UniversityComparatorByUniversityName();
        default:
            throw new ParseException(UniversityAttribute.MESSAGE_CONSTRAINTS);
        }
    }
}
