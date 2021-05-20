package ch11.composite;

import common.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
