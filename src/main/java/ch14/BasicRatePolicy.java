package ch14;

import java.util.ArrayList;
import java.util.List;

import common.Money;

public class BasicRatePolicy implements RatePolicy {
    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicRatePolicy(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
            .stream()
            .map(call -> calculate(call))
            .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }

    private Money calculate(Call call) {
        return feeRules
            .stream()
            .map(rule -> rule.calculateFee(call))
            .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }
}
