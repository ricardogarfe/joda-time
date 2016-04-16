package org.joda.time;

import java.util.HashMap;

public class Pool {

    private static Pool myInstance;

    private HashMap<Integer, Days> days;
    private HashMap<Integer, Minutes> minutes;

    private Pool() {
        this.days = new HashMap<Integer, Days>();
        this.minutes = new HashMap<Integer, Minutes>();
    }

    public static Pool getDays() {
        if (myInstance == null) {
            myInstance = new Pool();
        }
        return myInstance;
    }

    private void addDays(int numeral, Days day) {
        days.put(new Integer(numeral), day);
    }
    private void addMinutes(int numeral, Minutes minute) {
        minutes.put(new Integer(numeral), minute);
    }

    public Object getDays(int numeral) {
        Object instance = days.get(new Integer(numeral));

        if (instance == null) {
            return null;
        }

        return instance;
    }

    public static Days retrieveDays(int numeral) {
        Pool pool = Pool.getDays();

        Object result = pool.getDays(numeral);

        if (result == null) {
            result = new Days(numeral);
            pool.addDays(numeral, (Days) result);
        }

        return (Days) result;
    }

    public static Minutes retrieveMinutes(int numeral) {
        Pool pool = Pool.getDays();

        Object result = pool.getMinutes(numeral);

        if (result == null) {
            result = new Minutes(numeral);
            pool.addMinutes(numeral, (Minutes) result);
        }

        return (Minutes) result;
    }

    public Object getMinutes(int numeral) {
        Object instance = minutes.get(new Integer(numeral));

        if (instance == null) {
            return null;
        }

        return instance;
    }

}
