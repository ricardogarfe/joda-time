package org.joda.time;

import java.io.Serializable;

public class Limits implements Serializable {

    private final DateTimeFieldType lower;
    private final DateTimeFieldType upper;

    public Limits(DateTimeFieldType lowerLimit, DateTimeFieldType upperLimit) {
        lower = lowerLimit;
        upper = upperLimit;
    }

    public DateTimeFieldType lower() {
        return lower;
    }

    public DateTimeFieldType upper() {
        return upper;
    }

    public long apply(Chronology chrono, long millis) {
        millis = useLower(chrono, millis);
        millis = userUpper(chrono, millis);
        return millis;
    }

    public boolean noLimits() {
        return lower == null && upper == null;
    }

    public boolean limitedByDate() {
        return lower == DateTimeFieldType.dayOfYear() && upper == null;
    }

    private long userUpper(Chronology chrono, long millis) {
        if (upper == null) return millis;

        return upper.getField(chrono).remainder(millis);
    }

    private long useLower(Chronology chrono, long millis) {
        if (lower == null) return millis;

        return lower.getField(chrono).roundFloor(millis);
    }

}
