package lotto.exception;

public enum LottoNumberException implements ExceptionCode {

    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 %d이상 %d이하의 정수여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    ;

    private final String errorMessage;

    LottoNumberException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return EXCEPTION_MESSAGE_PREFIX + errorMessage;
    }
}
