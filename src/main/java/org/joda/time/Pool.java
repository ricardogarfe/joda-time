package org.joda.time;

import java.util.HashMap;

public class Pool {

    private static Pool myInstance;

    private HashMap<Integer, Object> instances;

    private Pool() {
        this.instances = new HashMap<Integer, Object>();
    }

    public static Pool getInstance() {
        if (myInstance == null) {
            myInstance = new Pool();
        }
        return myInstance;
    }

    public void add(int numeral, Object day) {
        instances.put(new Integer(numeral), day);
    }

    public Object getInstance(int numeral) {

        Object instance = instances.get(new Integer(numeral));

        if (instance == null) {
            return null;
        }

        return instance;
    }

    public static Days getDays(int numeral) {
        Pool pool = Pool.getInstance();

        Object result = pool.getInstance(numeral);

        if (result == null) {
            result = new Days(numeral);
            pool.add(numeral, result);
        }

        return (Days) result;
    }
}
