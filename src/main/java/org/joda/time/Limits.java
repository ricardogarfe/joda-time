package org.joda.time;

import java.io.Serializable;

public class Limits implements Serializable {

    private final DateTimeFieldType lower;
    private final DateTimeFieldType upper;

    public Limits(DateTimeFieldType lowerLimit, DateTimeFieldType upperLimit) {
        this.lower = lowerLimit;
        this.upper = upperLimit;
    }
}
