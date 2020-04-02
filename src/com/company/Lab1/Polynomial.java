package com.company.Lab1;

public class Polynomial {

    private int degree;
    private double[] coefficients;
    private double value = 0;
    private double x;

    public Polynomial (int degree, double x, double... coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
        this.x = x;

        calculate();
        System.out.println("The polynomial is " + getEquation());
        System.out.printf("when x = %.1f", x);
        System.out.printf("\n%s = %s\n", getEquation(), String.valueOf(value));
    }

    private void calculate() {
        for (int i = degree; i >= 0; i--) {
            value += coefficients[i] * Math.pow(x, (degree - i));
        }
    }

    private String getEquation() {
        String equation = "";
        for (int i = 0; i <= degree; i++) {
            if (i != 0 & coefficients[i] > 0) equation = equation.concat("+");
            equation = equation.concat(String.valueOf(coefficients[i]));
            if ((degree - i) > 0) equation = equation.concat("x");
            if ((degree - i) > 1) equation = equation.concat("^" + (degree - i));
            if (i != degree) equation = equation.concat(" ");
        }
        return equation;
    }
}
