package com.company.Tutorial2;

public class Tutorial2 {

    public Tutorial2() {
        Q3();
    }

    private void Q3() {
        System.out.println(maximum(5,3,4));
    }

    private static <T extends Comparable<T>> T maximum (T x, T y, T z) {
        if (x.compareTo(y) > 0 && x.compareTo(z) > 0) {
            return x;
        }
        if (y.compareTo(x) > 0 && y.compareTo(z) > 0) {
            return y;
        }
        if (z.compareTo(x) > 0 && z.compareTo(y) > 0) {
            return z;
        }
        return null;
    }
}
