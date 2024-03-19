package com.java.project.exceptions.exo1;

public class DivisionByZero {

    public static void main(String[] args) {

        double result = 0;
        try {
            result = division(100, 0);
        } catch (DivByZeroException e) {
            e.printStackTrace();
        } finally {
            System.out.println(result);
        }
    }

    private static double division(double a, double b) {
        if (b == 0) {
            throw new DivByZeroException(String.valueOf(a));
        }
        return a / b;
    }

    private static class DivByZeroException extends RuntimeException {
        public DivByZeroException(String value) {
            super(value + " cannot be divide by 0");
        }
    }

}
