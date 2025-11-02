package lotto.model;

import lotto.exception.ApplicationException;
import lotto.exception.LottoNumberException;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumberBound(number);
        this.number = number;
    }

    private static void validateLottoNumberBound(int number) {
        if (number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER) {
            throw new ApplicationException(LottoNumberException.INVALID_LOTTO_NUMBER_RANGE, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.number == lottoNumber.number;
    }
}
