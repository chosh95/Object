package ch2.step1;

public class NoneDiscountPolicy extends DiscountPolicy{
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
