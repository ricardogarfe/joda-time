package org.joda.time;

import java.util.HashMap;

public class Pool {

    private HashMap<Integer, Days> instances;

    public Pool() {
        this.instances = new HashMap<Integer, Days>();
    }

    public void add(int numeral, Days day) {
        instances.put(new Integer(numeral), day);
    }

    public Days getInstance(int numeral) {

        Object instance = instances.get(new Integer(numeral));

        if (instance == null) {
            return null;
        }

        return (Days) instance;
    }
}
