package com.academy.mdq.mobile.tests;

import com.academy.mdq.mobile.calculator.application.Calculator;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest extends BaseTestSuite {


    @Test
    public void myTest() throws InterruptedException {
        Calculator calculator = new Calculator();
        int number = 10000;
        int numberTwo = 5000;


        calculator.clickOnNumber(number);
        calculator.clickOnSum();
        calculator.clickOnNumber(numberTwo);
        calculator.clickOnEquals();
        Assert.assertTrue("Result not Equal!!",calculator.isResultOk());
    }
}
