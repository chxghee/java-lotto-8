package lotto.exception;

public class ApplicationException extends IllegalArgumentException {

    private final ExceptionCode exceptionCode;

    public ApplicationException(ExceptionCode exceptionCode) {
        super(exceptionCode.getErrorMessage());
        this.exceptionCode = exceptionCode;
    }

    public ApplicationException(ExceptionCode exceptionCode, Object... args) {
        super(String.format(exceptionCode.getErrorMessage(), args));
        this.exceptionCode = exceptionCode;
    }
}
