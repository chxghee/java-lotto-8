package lotto.model;

import lotto.model.strategy.NumbersGenerator;

import java.util.List;

public class OneToSixNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> generateNumbers() {
        return List.of(1,2,3,4,5,6);
    }
}
