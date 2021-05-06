package ch4.step2;

import java.time.DayOfWeek;
import java.time.LocalTime;

import ch4.step1.DiscountConditionType;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType() {
        return type;
    }

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalStateException();
        }

        return this.dayOfWeek.equals(dayOfWeek)
            && this.startTime.compareTo(time) <= 0
            && this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalStateException();
        }

        return this.sequence == sequence;
    }
}
