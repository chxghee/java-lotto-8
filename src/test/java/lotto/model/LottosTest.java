package lotto.model;

import lotto.model.strategy.LottoNumbersGenerator;
import lotto.model.strategy.NumbersGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    private final NumbersGenerator numbersGenerator = new LottoNumbersGenerator();

    @Test
    void 구매한_로또의_개수_만큼_로또가_발급되어야_한다() {
        int amount = 100;
        Lottos lottos = Lottos.of(amount, numbersGenerator);
        assertThat(lottos.size()).isEqualTo(amount);
    }

}
