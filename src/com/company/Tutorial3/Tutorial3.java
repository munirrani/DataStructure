package com.company.Tutorial3;

public class Tutorial3 {

    public Tutorial3() {
        Q1();
        Q2();
        Q3();
        Q4();
    }

    private void Q1() {
        int[] a = { 1,2,3,4,5 };
        //1a
        System.out.println(smallestElement(a, a.length));
        //1b
        System.out.println(sum(a, a.length));
        //1c
        System.out.println(gcd(72, 6));
        //1d
        toBinary(445);
        System.out.println();
        //1e
        System.out.println(nCube(3));
    }

    private void Q2() {
        System.out.println(Acker(3, 4));
        System.out.println(Acker(2, 5));
    }

    private void Q3() {
        writeBlock('$',3, 2);
    }

    private void Q4() {
        String input = "Everything is fine";
        if (input.length() > 12) {
            try {
                throw new StringLengthExeception();
            } catch (StringLengthExeception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int smallestElement(int a[], int size) {
        int min;
        if (size == 0) {
            return a[size];
        } else {
            min = smallestElement(a, --size);
            if (min > a[size]) {
                return a[size];
            } else {
                return min;
            }
        }
    }

    public int sum(int a[], int n) {
        if (n == 0) {
            return a[0];
        } else {
            return a[n-1] + sum(a, n-1);
        }
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public void toBinary(int num) {
        if (num != 0) {
            toBinary(num / 2);
            System.out.print(num%2);
        }
    }

    public int nCube(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (int)Math.pow(n, 3) + nCube(n-1);
        }
    }

    private int Acker(int m, int n) {
        if (m == 0) {
            return n+1;
        } else if (n == 0) {
            return Acker(m-1, 1);
        } else {
            return Acker(m-1, Acker(m, n-1));
        }
    }

    private void writeLine(char c, int n) {
        if (n == 0) {
            System.out.println();
            return;
        }
        writeLine(c, n-1);
        System.out.print(c);
    }

    private void writeBlock(char c, int m, int n) {
        if (n == 0) return;
        writeLine(c, m);
        writeBlock(c, m-1, n-1);
    }

    public class StringLengthExeception extends Exception {
        public StringLengthExeception() {
            super("String Length Exception");
        }
    }
}
