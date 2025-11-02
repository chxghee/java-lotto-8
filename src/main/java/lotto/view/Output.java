package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.Rank;

public class Output {

    public static void printPurchaseInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseAmountMessage(int amount) {
        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResults(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            printRankResult(lottoResult, rank);
        }
    }

    private static void printRankResult(LottoResult lottoResult, Rank rank) {
        if (rank != Rank.MISS) {
            System.out.println(getRankResultMessage(lottoResult, rank));
        }
    }

    private static String getRankResultMessage(LottoResult lottoResult, Rank rank) {
        return rank.getResultMessage() + lottoResult.getResults().get(rank) + "개";
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
