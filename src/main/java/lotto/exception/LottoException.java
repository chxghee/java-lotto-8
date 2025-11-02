package lotto.exception;

public enum LottoException implements ExceptionCode {

    INVALID_LOTTO_LENGTH("로또 번호는 %d개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호는 중복일 수 없습니다.");

    private final String errorMessage;

    LottoException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return EXCEPTION_MESSAGE_PREFIX + errorMessage;
    }
}
