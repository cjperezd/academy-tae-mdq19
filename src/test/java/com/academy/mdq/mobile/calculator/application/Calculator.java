package com.academy.mdq.mobile.calculator.application;

import com.academy.mdq.mobile.calculator.components.NumericPad;
import com.academy.mdq.mobile.calculator.components.PadOperator;
import com.academy.mdq.page.mobile.MobilePage;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public Calculator clickOnNumber(int number){
       numericPad.clickOnNumber(number);
        return new Calculator();
    }


    public void clickOnSum(){
        padOperator.clickOnAdd();
    }

    public void clickOnEquals(){
        padOperator.clickOnDigitEquals();
    }

    private String result(){
        return resultViewer.getText();
    }

    public boolean isResultOk(){
        return result().equals("15,000");
    }
}
