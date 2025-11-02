package lotto.controller;

import lotto.model.*;
import lotto.model.strategy.NumbersGenerator;
import lotto.parser.InputParser;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

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

        Lotto winningLotto = getWinningNumbers();
        LottoNumber bonusNumber = getBonusNumber(winningLotto);
        calculateResults(lottos, winningLotto, bonusNumber);
    }

    private static void calculateResults(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        LottoResult lottoResult = LottoResult.of(lottos, winningLotto, bonusNumber);
        Output.printLottoResults(lottoResult);
        Output.printProfit(lottoResult.calculateProfit(lottos.size()));
    }

    private static LottoAmount getLottoAmount() {
        Output.printPurchaseInputMessage();
        try {
            int purchasePrice = InputParser.parsePurchasePrice(Input.read());
            return LottoAmount.from(purchasePrice);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getLottoAmount();
        }
    }

    private static Lotto getWinningNumbers() {
        Output.printWinningNumbersInputMessage();
        try {
            List<Integer> winningNumbers = InputParser.parseWinningNumbers(Input.read());
            return Lotto.from(winningNumbers);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private static LottoNumber getBonusNumber(Lotto winningLotto) {
        Output.printBonusNumberInputMessage();
        try {
            int bonusNumber = InputParser.parseBonusNumber(Input.read());
            return LottoNumber.bonusNumber(bonusNumber, winningLotto);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getBonusNumber(winningLotto);
        }
    }
}
