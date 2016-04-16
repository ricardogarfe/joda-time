package org.joda.time;

class MyPool {

    public MyPool() {
        Pool pool = Pool.getInstance();
        pool.add(0, Days.ZERO);
        pool.add(1, Days.ONE);
        pool.add(2, Days.TWO);
        pool.add(3, Days.THREE);
        pool.add(4, Days.FOUR);
        pool.add(5, Days.FIVE);
        pool.add(6, Days.SIX);
        pool.add(7, Days.SEVEN);
        pool.add(Integer.MAX_VALUE, Days.MAX_VALUE);
        pool.add(Integer.MIN_VALUE, Days.MIN_VALUE);
    }

    public static Days retrieve(int days) {

        Pool pool = Pool.getInstance();
        Object result = pool.getInstance(days);

        if (result == null) {
            return new Days(days);
        }

        return (Days) result;
    }
}
