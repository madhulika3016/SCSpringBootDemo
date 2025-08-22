package com;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();
    //@Test
    @Disabled
    void add() {
       // Calculator calc = new Calculator();
        assertEquals(14, calc.add(5, 7));
    }

    @Test
    void sub() {
        assertEquals(13, calc.sub(-22, 9));
    }

    //@Test
    @RepeatedTest(3)
    void mul() {
        assertEquals(15, calc.mul(5, 3));
    }
}