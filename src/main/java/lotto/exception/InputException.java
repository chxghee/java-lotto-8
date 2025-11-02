package lotto.exception;

public enum InputException implements ExceptionCode {

    INVALID_PURCHASE_PRICE_FORMAT("로또 구매 금액 입력은 정수여야 합니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호는 입력은 정수여야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("당첨 로또 번호 입력은 쉼표(,)로 구분되고, 양의 정수여야 합니다."),
    ;

    private final String errorMessage;

    InputException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return EXCEPTION_MESSAGE_PREFIX + errorMessage;
    }
}
