package lotto.parser;

import lotto.exception.ApplicationException;
import lotto.exception.InputException;

public class InputParser {

    public static int parsePurchasePriceToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ApplicationException(InputException.INVALID_PURCHASE_PRICE_FORMAT);
        }
    }
}
