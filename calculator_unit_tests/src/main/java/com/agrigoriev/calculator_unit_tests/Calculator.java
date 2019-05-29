package com.agrigoriev.calculator_unit_tests;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        if (b != 0){
            return a / b;
        } else {
            System.out.println("dibision by zero");
            return -1;
        }
    }
}
