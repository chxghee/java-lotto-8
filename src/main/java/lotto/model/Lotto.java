package lotto.model;

import lotto.exception.ApplicationException;
import lotto.exception.LottoException;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final TreeSet<LottoNumber> numbers;

    private Lotto(TreeSet<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
        validateLottoSize(lottoNumbers);
        TreeSet<LottoNumber> uniqueLottoNumbers = validateDuplicateLottoNumber(lottoNumbers);
        return new Lotto(uniqueLottoNumbers);
    }

    public static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private static void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new ApplicationException(LottoException.INVALID_LOTTO_LENGTH, LOTTO_NUMBER_COUNT);
        }
    }

    private static TreeSet<LottoNumber> validateDuplicateLottoNumber(List<LottoNumber> lottoNumbers) {
        TreeSet<LottoNumber> uniqueLottoNumbers = new TreeSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new ApplicationException(LottoException.INVALID_LOTTO_LENGTH, lottoNumbers.size());
        }
        return uniqueLottoNumbers;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public Rank calculateRanking(Lotto winningNumbers, LottoNumber bonusBall) {
        int matchingCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasMatchedBonusBall = numbers.contains(bonusBall);
        return Rank.getRanking(matchingCount, hasMatchedBonusBall);
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
