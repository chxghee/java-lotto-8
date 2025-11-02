package lotto.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final DecimalFormat PRIZE_FORMAT = new DecimalFormat("#,###");
    private final int matchingNumberCount;
    private final long prize;

    Rank(int matchingNumberCount, long prize) {
        this.matchingNumberCount = matchingNumberCount;
        this.prize = prize;
    }

    public static Rank getRanking(int matchingCount, boolean hasMatchedBonusBall) {
        if (matchingCount == 5 && hasMatchedBonusBall) {
            return SECOND;
        }
        if (matchingCount == 5) {
            return THIRD;
        }
        return getRankByMatchingCount(matchingCount);
    }

    private static Rank getRankByMatchingCount(int matchingCount) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchingNumberCount == matchingCount)
                .findFirst()
                .orElse(MISS);
    }

    public long getPrize() {
        return prize;
    }

    public String getResultMessage() {
        if (this == MISS) {
            return "낙첨";
        }
        if (this == SECOND) {
            return formatWinningMessage("%d개 일치, 보너스 볼 일치 (%s원) - ");
        }
        return formatWinningMessage("%d개 일치 (%s원) - ");
    }

    private String formatWinningMessage(String message) {
        return String.format(message, matchingNumberCount, PRIZE_FORMAT.format(prize));
    }
}
