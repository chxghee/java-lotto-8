package lotto.exception;

public enum LottoAmountException implements ExceptionCode {

    INVALID_PURCHASE_AMOUNT("로또는 최소 %d원어치 이상 구매해야 합니다."),
    INVALID_PURCHASE_PRICE("로또 구매 금액은 %d원 단위로만 구매 가능합니다.");

    private final String errorMessage;

    LottoAmountException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return EXCEPTION_MESSAGE_PREFIX + errorMessage;
    }
}
