package lotto.parser;

import lotto.exception.ApplicationException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputParserTest {

    @Nested
    class 로또_구매_금액_파싱_로직_테스트 {

        @Test
        void 정수_문자열의_구매_금액이_입력되면_정수로_변환되어야_한다() {
            int result = InputParser.parsePurchasePrice("8000");
            assertThat(result).isEqualTo(8000);
        }

        @Test
        void 구매_금액에_문자가_입력되면_예외가_발생해야_한다() {
            assertThatThrownBy(() -> InputParser.parsePurchasePrice("abcd"))
                    .isInstanceOf(ApplicationException.class);
        }
    }

    @Nested
    class 보너스_번호_파싱_로직_테스트 {

        @Test
        void 정수_문자열의_보너스_번호가_입력되면_정수로_변환되어야_한다() {
            int result = InputParser.parseBonusNumber("7");
            assertThat(result).isEqualTo(7);
        }

        @Test
        void 보너스_번호에_문자가_입력되면_예외가_발생해야_한다() {
            assertThatThrownBy(() -> InputParser.parseBonusNumber("a"))
                    .isInstanceOf(ApplicationException.class);
        }
    }

    @Nested
    class 당첨_번호_파싱_로직_테스트 {

        @Test
        void 숫자와_구분자_사이에_공백이_포함되면_공백을_제거하고_정수_리스트로_변환되어야_한다() {
            List<Integer> result = InputParser.parseWinningNumbers("1,2, 3, 4,5,6");
            assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
        }

        @Test
        void 구분자_사이에_숫자가_없다면_예외가_발생해야_한다() {
            assertThatThrownBy(() -> InputParser.parseWinningNumbers("1,2,,3"))
                    .isInstanceOf(ApplicationException.class);
        }

        @Test
        void 구분자가_쉼표가_아니면_예외가_발생해야_한다() {
            assertThatThrownBy(() -> InputParser.parseWinningNumbers("1,2,4&3"))
                    .isInstanceOf(ApplicationException.class);
        }

        @Test
        void 숫자가_아닌_문자가_주어지면_예외가_발생해야_한다() {
            assertThatThrownBy(() -> InputParser.parseWinningNumbers("1,2,a,4,5,6"))
                    .isInstanceOf(ApplicationException.class);
        }
    }
}
