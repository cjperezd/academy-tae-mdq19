package com.academy.mdq.mobile.calculator.components;

import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PadOperator extends MobileComponent {

    public PadOperator(MobileElement container) {
        super(container);
    }

    @AndroidFindBy (id = "op_add")
        private MobileElement plusButton;
    @AndroidFindBy (id = "op_sub")
        private MobileElement minusButton;
    @AndroidFindBy (id = "op_mul")
        private MobileElement multiplyButton;
    @AndroidFindBy (id = "op_div")
        private MobileElement divideButton;
    @AndroidFindBy (id = "del")
        private MobileElement deleteButton;




    public PadOperator clickOnAdd(){
        click(plusButton);
        return this;
    }

    public PadOperator clickOnMinus(){
        click(minusButton);
        return this;
    }

    public PadOperator clickOnMultiply(){
        click(multiplyButton);
        return this;
    }

    public PadOperator clickOnDivide(){
        click(divideButton);
        return this;
    }



}
