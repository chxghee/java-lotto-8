package lotto.parser;

import lotto.exception.ApplicationException;
import lotto.exception.ExceptionCode;
import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String WINNING_NUMBERS_PATTERN = "^\\d+(,\\s*\\d+)*$";
    private static final String DELIMITER = ",";

    public static int parsePurchasePrice(String input) {
        return parseStringToInt(input, InputException.INVALID_PURCHASE_PRICE_FORMAT);
    }

    public static int parseBonusNumber(String input) {
        return parseStringToInt(input, InputException.INVALID_BONUS_NUMBER_FORMAT);
    }

    private static int parseStringToInt(String input, ExceptionCode exceptionCode) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ApplicationException(exceptionCode);
        }
    }

    public static List<Integer> parseWinningNumbers(String input) {
        validateWinningNumbersPattern(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateWinningNumbersPattern(String input) {
        if (!input.matches(WINNING_NUMBERS_PATTERN)) {
            throw new ApplicationException(InputException.INVALID_WINNING_NUMBERS_FORMAT);
        }
    }
}
