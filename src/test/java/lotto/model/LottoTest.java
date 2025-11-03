package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Nested
    class 로또_당첨결과_테스트 {

        private final Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        private final LottoNumber bonusBall = LottoNumber.bonusNumber(7, winningNumbers.getNumbers());

        @Test
        void 로또번호가_우승번호와_모두_일치하면_FIRST를_반환해야_한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            assertThat(rank).isEqualTo(Rank.FIRST);
        }

        @Test
        void 로또번호가_우승번호와_5개_일치하고_보너스볼이_일치하면_SECOND를_반환해야_한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            assertThat(rank).isEqualTo(Rank.SECOND);
        }

        @Test
        void 로또번호가_우승번호와_5개_일치하면_THIRD를_반환해야_한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 10));
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            assertThat(rank).isEqualTo(Rank.THIRD);
        }

        @Test
        void 로또번호가_우승번호와_4개_일치하면_FIRST를_반환해야_한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 8, 9));
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            assertThat(rank).isEqualTo(Rank.FOURTH);
        }

        @Test
        void 로또번호가_우승번호와_3개_일치하면_FIFTH를_반환해야_한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 9, 10, 11));
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            assertThat(rank).isEqualTo(Rank.FIFTH);
        }

        @Test
        void 로또번호가_우승번호와_2개_이하로_일치하면_MISS를_반환해야_한다() {
            Lotto lotto = Lotto.from(List.of(10, 20, 30, 40, 5, 6));
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            assertThat(rank).isEqualTo(Rank.MISS);
        }
    }

    @Nested
    class Contains_메서드_테스트 {

        @Test
        void 로또가_특정_번호를_포함하고_있으면_true를_반환한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber lottoNumber = LottoNumber.from(1);
            assertThat(lotto.contains(lottoNumber)).isTrue();
        }

        @Test
        void 로또가_특정_번호를_포함하지_않으면_false를_반환한다() {
            Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber lottoNumber = LottoNumber.from(7);
            assertThat(lotto.contains(lottoNumber)).isFalse();
        }
    }

    @Test
    void 로또_번호는_오름차순으로_정렬_되어야_한다() {
        Lotto lotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));

        List<LottoNumber> expected = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );

        assertThat(lotto.getNumbers()).containsExactlyElementsOf(expected);
    }

}
