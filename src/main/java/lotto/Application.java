package lotto;

import lotto.controller.LottoController;
import lotto.model.strategy.LottoNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoNumbersGenerator());
        lottoController.run();
    }
}
