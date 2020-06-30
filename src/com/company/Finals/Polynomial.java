package com.company.Finals;

public class Polynomial {

    private int degree;
    private int[] coefficient;

    public Polynomial() {
        degree = 0;
    }

    public Polynomial(int... coefficients) {
        degree = coefficients.length - 1;
        coefficient = new int[coefficients.length];
        for (int i = 0; i <= degree; i++) {
            coefficient[i] = coefficients[i];
        }
    }

    public int getDegree() { return degree; }

    public int[] getCoefficient() { return coefficient; }

    public String toString() {
        String str = "";
        for (int i = 0; i <= degree; i++) {
            if(coefficient[i] != 0)  {
                str += coefficient[i];
                if (i != degree) str += "x";
                if (degree - i > 1) str += "^" + (degree - i);
            }
            if (i != degree && coefficient[i+1] > 0) str += "+";
        }
        return str;
    }

    public void add(Polynomial p1, Polynomial p2) {
        int maxDegree = Math.max(p1.getDegree(), p2.getDegree());
        int[] p1coeff = p1.getCoefficient();
        int[] p2coeff = p2.getCoefficient();
        coefficient = new int[maxDegree+1];
        degree = maxDegree;
        for (int i = 0; i <= maxDegree; i++) {
            coefficient[i] = 0;
        }
        for (int i = 0; i <= maxDegree; i++) {
            if (p1.getDegree() > p2.getDegree()) {
                int difference = p1.getDegree() - p2.getDegree();

                Integer first = p1coeff[i];
                if (first != null) {
                    coefficient[i] += first;
                }

                if (maxDegree >= i+difference) {
                    Integer second = p2coeff[i];
                    if (second != null) {
                        if (maxDegree >= i+difference) coefficient[i+difference] += second;
                    }
                }
            } else if (p2.degree > p1.degree) { // p2 > p1
                int difference = p2.getDegree() - p1.getDegree();

                if (maxDegree >= i+difference) {
                    Integer first = p2coeff[i];
                    if (first != null) {
                        if (maxDegree >= i+difference) coefficient[i+difference] += first;
                    }
                }

                Integer second = p1coeff[i];
                if (second != null) {
                    coefficient[i] += second;
                }
            } else { //p1 == p2
                Integer first = p1coeff[i];
                Integer second = p2coeff[i];
                if (first != null) {
                    coefficient[i] += first;
                }
                if (second != null) {
                    coefficient[i] += second;
                }
            }
        }
    }

    public int getValue(int x) {
        int value = 0;
        for (int i = coefficient.length - 1; i >=0; i--) {
            value += Math.pow(x, i) * coefficient[coefficient.length - 1 - i];
        }
        return value;
    }
}
