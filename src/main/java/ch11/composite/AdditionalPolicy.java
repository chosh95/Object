package ch11.composite;

import common.Money;

public abstract class AdditionalPolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionalPolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}
