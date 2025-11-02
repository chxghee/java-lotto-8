package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void 로또숫자가_1미만이면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또숫자가_45초과이면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_음수이면_예외가_발생해야_한다() {
        int bonusNumber = -1;
        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> LottoNumber.bonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_추첨_번호와_중복되는_값을_가지면_예외가_발생해야_한다() {
        int bonusNumber = 1;
        Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> LottoNumber.bonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
