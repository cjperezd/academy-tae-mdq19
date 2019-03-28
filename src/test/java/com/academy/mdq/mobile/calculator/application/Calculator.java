package com.academy.mdq.mobile.calculator.application;

import com.academy.mdq.mobile.calculator.components.NumericPad;
import com.academy.mdq.mobile.calculator.components.PadOperator;
import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class Calculator extends MobilePage {

    @AndroidFindBy(id = "pad_numeric")
        private MobileElement padCalculatorViewer;

    @AndroidFindBy(id = "pad_operator")
        private MobileElement padOperatorViewer;

    @AndroidFindBy (id = "pad_advanced")
        private MobileElement padAdvancedViewer;

    @AndroidFindBy (id = "formula")
        private WebElement formulaViewer;

    @AndroidFindBy (id = "result")
        private WebElement resultViewer;


    private NumericPad numericPad = new NumericPad(padCalculatorViewer);
    private PadOperator padOperator = new PadOperator(padOperatorViewer);


    public NumericPad getNumericPad(){
        return  numericPad;
    }


    public Calculator clickOnNumber(){
        numericPad.clickOnDigitOne();
        numericPad.clickOnDigitZero();
        numericPad.clickOnDigitZero();
        numericPad.clickOnDigitZero();
        numericPad.clickOnDigitZero();
        return new Calculator();
    }

    public void clickOnSum(){
        padOperator.clickOnAdd();
    }

    public void clickSecondNumber(){
        numericPad.clickOnDigitFive();
        numericPad.clickOnDigitZero();
        numericPad.clickOnDigitZero();
        numericPad.clickOnDigitZero();
    }

    public void clickOnEquals(){
        numericPad.clickOnDigitEquals();
    }

    public String result(){
        return resultViewer.getText();
    }

    public boolean isResultOk(){
        return result().contains("15000");
    }
}
