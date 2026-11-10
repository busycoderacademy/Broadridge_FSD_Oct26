package com.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }
    @Test
    void add() {
        int sum=calc.add(1,2);
        assertEquals(3,sum);
    }

    @Test
    void multiply() {
        int mul=calc.multiply(2,2);
        assertEquals(4,mul);
    }

    @Test
    void divideWithNonZero() {
        int div=calc.divide(12,2);
        assertEquals(6,div);
    }
    @Test
    void divideWithZero() {
        assertThrows(ArithmeticException.class,()->calc.divide(12,0));
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }



}