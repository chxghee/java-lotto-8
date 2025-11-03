package lotto.model;

import lotto.exception.ApplicationException;
import lotto.exception.LottoNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static lotto.model.LottoConstants.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        LottoNumber lottoNumber = CACHE.get(number);
        if (lottoNumber == null) {
            throw new ApplicationException(LottoNumberException.INVALID_LOTTO_NUMBER_RANGE, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
        }
        return lottoNumber;
    }

    public static LottoNumber bonusNumber(int bonusNumber, Set<LottoNumber> lottoNumbers) {
        LottoNumber bonus = LottoNumber.from(bonusNumber);
        if (lottoNumbers.contains(bonus)) {
            throw new ApplicationException(LottoNumberException.DUPLICATE_BONUS_NUMBER);
        }
        return bonus;
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
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
