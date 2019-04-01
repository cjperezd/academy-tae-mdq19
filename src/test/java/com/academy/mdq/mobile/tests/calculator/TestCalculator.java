package com.academy.mdq.mobile.tests.calculator;

import com.academy.mdq.mobile.pages.calculator.CalculatorApp;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator extends BaseTestSuite {

  @Test
  public void SumTest() {

    CalculatorApp calc = new CalculatorApp()
        .typeNumber("10000")
        .plus()
        .typeNumber("5000")
        .equal();

    assertEquals("The sum return the value expected", "15000", calc.getResult());
  }

}
