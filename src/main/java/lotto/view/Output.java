package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class Output {

    public static void printPurchaseInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseAmountMessage(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
