package com.github.glo2003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void whenEmptyString_thenReturnsZero() {
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    void whenNonNumericValues_thenThrowInvalidInput() {
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("4,a"));
    }

    @Test
    void whenOneNumericValues_thenReturnsTheSameNumber() {
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    void whenTwoNumericValues_thenReturnsTheSumOfTwoNumbers() {
        int result = calculator.add("1, 2");
        assertEquals(3, result);
    }

    @Test
    void whenOneNumericValueAndVoid_thenReturnsOnlyTheNumber() {
        int result = calculator.add("1, ");
        assertEquals(1, result);
    }

    @Test
    void whenVoidBetweenTwoNumbers_thenReturnsOnlyTheSameOfNumbers() {
        int result = calculator.add("1,,3");
        assertEquals(4, result);
    }


}