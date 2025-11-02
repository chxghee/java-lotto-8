package lotto.exception;

public enum InputException implements ExceptionCode {

    INVALID_PURCHASE_PRICE_FORMAT("로또 구매 금액은 정수여야 합니다.");

    private final String errorMessage;

    InputException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return EXCEPTION_MESSAGE_PREFIX + errorMessage;
    }
}
