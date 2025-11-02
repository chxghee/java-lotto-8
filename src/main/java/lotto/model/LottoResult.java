package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int LOTTO_PRICE = 1000;
    private final Map<Rank, Integer> results;

    private LottoResult(Map<Rank, Integer> results) {
        this.results = results;
    }

    public static LottoResult of(Lottos lottos, Lotto winningNumbers, LottoNumber bonusBall) {
        final Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        initializeResults(results);
        countResults(lottos, winningNumbers, bonusBall, results);
        return new LottoResult(results);
    }

    private static void countResults(Lottos lottos, Lotto winningNumbers, LottoNumber bonusBall, Map<Rank, Integer> results) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = lotto.calculateRanking(winningNumbers, bonusBall);
            results.put(rank, results.get(rank) + 1);
        }
    }

    private static void initializeResults(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public double calculateProfit(int lottoAmount) {
        double profitPercent = (double) getTotalPrize() / (lottoAmount * LOTTO_PRICE) * 100;
        return roundToTwoDecimal(profitPercent);
    }

    private static double roundToTwoDecimal(double profitPercent) {
        return Math.round(profitPercent * 100.0) / 100.0;
    }

    private long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
