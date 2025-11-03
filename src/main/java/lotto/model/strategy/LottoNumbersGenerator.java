package lotto.model.strategy;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.model.LottoConstants.*;

public class LottoNumbersGenerator implements NumbersGenerator{

    @Override
    public List<Integer> generateNumbers() {
        return pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
