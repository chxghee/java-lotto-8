package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.model.strategy.NumbersGenerator;
import lotto.parser.InputParser;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final NumbersGenerator numbersGenerator;

    public LottoController(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public void run() {
        LottoAmount lottoAmount = getLottoAmount();
        Output.printPurchaseAmountMessage(lottoAmount.getAmount());

        Lottos lottos = Lottos.of(lottoAmount.getAmount(), numbersGenerator);
        Output.printLottos(lottos);


    }

    private static LottoAmount getLottoAmount() {
        Output.printPurchaseInputMessage();
        try {
            int purchasePrice = InputParser.parsePurchasePriceToInteger(Input.read());
            return LottoAmount.from(purchasePrice);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getLottoAmount();
        }
    }

}
