package lotto.model;

import lotto.exception.ApplicationException;
import lotto.exception.LottoNumberException;

import static lotto.model.LottoConstants.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumberBound(number);
        this.number = number;
    }

    public static LottoNumber bonusNumber(int number, Lotto winningLotto) {
        LottoNumber bonusNumber = new LottoNumber(number);
        if (winningLotto.contains(bonusNumber)) {
            throw new ApplicationException(LottoNumberException.DUPLICATE_BONUS_NUMBER);
        }
        return bonusNumber;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
