package com.academy.mdq.mobile.tests.calculator;


import com.academy.mdq.mobile.pages.calculator.CalculatorApp;
import com.academy.mdq.testsuite.BaseTestSuite;
import org.junit.Assert;
import org.junit.Test;

public class TestCalculator extends BaseTestSuite {

    @Test
    public void SumTest () {

        CalculatorApp calc = new CalculatorApp()
        .enterCalculation("(10000*5000");


        //Asserts

        Assert.assertEquals("15000",calc.getResult());




    }



}
