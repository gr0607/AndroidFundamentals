package com.agrigoriev.calculator_unit_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        System.out.println("\r\nsetUp");
        mCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void add() {
        System.out.println("add");
        assertEquals(9, mCalculator.add(3, 6));
    }

    @Test
    public void subtract() {
        System.out.println("subtract");
        assertEquals(4, mCalculator.subtract(10, 6));
    }

    @Test
    public void multiply() {
        System.out.println("multiply");
        assertEquals(15, mCalculator.multiply(3, 5));
    }

    @Test
    public void division() {
        System.out.println("division");
        assertEquals(7, mCalculator.division(21, 3));
    }
}