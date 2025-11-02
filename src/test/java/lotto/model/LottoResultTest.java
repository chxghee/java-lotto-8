package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private final int lottoAmount = 10;
    private final Lottos lottos = Lottos.of(lottoAmount, new OneToSixNumbersGenerator());

    @Test
    void 구매한_로또가_전부_당첨되면_수익률은_200_000_000퍼센트이다() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.bonusNumber(7, winningLotto);
        LottoResult lottoResult = LottoResult.of(lottos, winningLotto, bonusNumber);
        System.out.println(lottoResult.calculateProfit(lottoAmount));
        assertThat(lottoResult.calculateProfit(lottoAmount)).isEqualTo(200_000_000);
    }

    @Test
    void 구매한_로또가_전부_낙첨되면_수익률은_1보다_작다() {
        Lotto winningLotto = Lotto.from(List.of(11, 12, 13, 14, 15, 16));
        LottoNumber bonusNumber = LottoNumber.bonusNumber(7, winningLotto);
        LottoResult lottoResult = LottoResult.of(lottos, winningLotto, bonusNumber);
        assertThat(lottoResult.calculateProfit(lottoAmount)).isLessThan(1);
    }

}
