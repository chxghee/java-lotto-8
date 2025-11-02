package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAmountTest {

    private static final int LOTTO_PRICE = 1000;

    @Test
    void 로또의_구매_양수이고_1000으로_나누어_떨어지면_해당_금액전부_로또를_구매해야_한다() {
        int purchasePrice = 10000;
        LottoAmount lottoAmount = LottoAmount.from(purchasePrice);
        assertThat(lottoAmount.getAmount()).isEqualTo(purchasePrice/LOTTO_PRICE);
    }

    @Test
    void 로또의_구매_금액이_음수이면_예외가_발생해야_한다() {
        int purchasePrice = -1000;
        assertThatThrownBy(() -> LottoAmount.from(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또의_구매_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생해야_한다() {
        int purchasePrice = 1200;
        assertThatThrownBy(() -> LottoAmount.from(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또의_구매_금액이_0원이면_예외가_발생해야_한다() {
        int purchasePrice = 1200;
        assertThatThrownBy(() -> LottoAmount.from(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
