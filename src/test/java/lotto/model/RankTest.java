package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 일치하는_당첨볼의_개수가_6개이면_로또_1등_당첨이다() {
        int matchingCount = 6;
        boolean hasMatchedBonusBall = false;
        Rank rank = Rank.getRanking(matchingCount, hasMatchedBonusBall);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 일치하는_당첨볼의_개수가_5개이고_보너스볼이_일치하면_로또_2등_당첨이다() {
        int matchingCount = 5;
        boolean hasMatchedBonusBall = true;
        Rank rank = Rank.getRanking(matchingCount, hasMatchedBonusBall);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 일치하는_당첨볼의_개수가_5개이고_보너스볼이_일치하지_않으면_로또_3등_당첨이다() {
        int matchingCount = 5;
        boolean hasMatchedBonusBall = false;
        Rank rank = Rank.getRanking(matchingCount, hasMatchedBonusBall);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 일치하는_당첨볼의_개수가_4개이면_로또_4등_당첨이다() {
        int matchingCount = 4;
        boolean hasMatchedBonusBall = false;
        Rank rank = Rank.getRanking(matchingCount, hasMatchedBonusBall);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 일치하는_당첨볼의_개수가_3개이면_로또_5등_당첨이다() {
        int matchingCount = 3;
        boolean hasMatchedBonusBall = false;
        Rank rank = Rank.getRanking(matchingCount, hasMatchedBonusBall);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 일치하는_당첨볼의_개수가_2개_이하면_낙첨이다() {
        int matchingCount = 1;
        boolean hasMatchedBonusBall = false;
        Rank rank = Rank.getRanking(matchingCount, hasMatchedBonusBall);
        assertThat(rank).isEqualTo(Rank.MISS);
    }

}
