package lotto.model;

import lotto.exception.ApplicationException;
import lotto.exception.LottoAmountException;

import static lotto.model.LottoConstants.*;

public class LottoAmount {

    private final int amount;

    private LottoAmount(int amount) {
        this.amount = amount;
    }

    public static LottoAmount from(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        int purchaseAmount = validatePurchaseAmount(purchasePrice);
        return new LottoAmount(purchaseAmount);
    }

    private static int validatePurchaseAmount(int purchasePrice) {
        int purchaseAmount = purchasePrice / LOTTO_PRICE;
        if (purchaseAmount <= 0) {
            throw new ApplicationException(LottoAmountException.INVALID_PURCHASE_AMOUNT, LOTTO_PRICE);
        }
        return purchaseAmount;
    }

    private static void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new ApplicationException(LottoAmountException.INVALID_PURCHASE_PRICE, LOTTO_PRICE);
        }
    }

    public int getAmount() {
        return amount;
    }
}
