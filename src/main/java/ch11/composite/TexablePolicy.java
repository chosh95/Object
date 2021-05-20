package ch11.composite;

import common.Money;

public class TexablePolicy extends AdditionalPolicy {
    private double taxRatio;

    public TexablePolicy(double taxRatio, RatePolicy next) {
        super(next);
        this.taxRatio = taxRatio;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
