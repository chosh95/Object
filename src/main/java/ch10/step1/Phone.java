package ch10.step1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import common.Call;
import common.Money;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds, List<Call> calls) {
        this.amount = amount;
        this.seconds = seconds;
        this.calls = calls;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }
}
