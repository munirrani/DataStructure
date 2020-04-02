package com.company.Tutorial3;

public class Tutorial3 {

    public Tutorial3() {
        Q1();
    }

    private void Q1() {
        //1b
        int[] a = { 1,2,3,4,5 };
        System.out.println(sum(a, a.length));
    }

    public int sum(int a[], int n) {
        if (n == 0) {
            return a[0];
        } else {
            return a[n-1] + sum(a, n-1); // a[n-1] sebab index = 2
        }
    }
}
