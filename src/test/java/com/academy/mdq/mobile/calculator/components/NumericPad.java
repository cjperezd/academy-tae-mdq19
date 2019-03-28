package com.academy.mdq.mobile.calculator.components;

import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NumericPad extends MobileComponent {


    @AndroidFindBy (id = "digit_0")
        private MobileElement digitZeroButton;
    @AndroidFindBy (id = "digit_1")
        private MobileElement digitOneButton;
    @AndroidFindBy (id = "digit_2")
        private MobileElement digitTwoButton;
    @AndroidFindBy (id = "digit_3")
        private MobileElement digitThreeButton;
    @AndroidFindBy (id = "digit_4")
        private MobileElement digitFourButton;
    @AndroidFindBy (id = "digit_5")
        private MobileElement digitFiveButton;
    @AndroidFindBy (id = "digit_6")
        private MobileElement digitSixButton;
    @AndroidFindBy (id = "digit_7")
        private MobileElement digitSevenButton;
    @AndroidFindBy (id = "digit_8")
        private MobileElement digitEightButton;
    @AndroidFindBy (id = "digit_9")
        private MobileElement digitNineButton;
    @AndroidFindBy (id = "dec_point")
        private MobileElement digitDotButton;
    @AndroidFindBy (id = "eq")
        private MobileElement digitEqualsButton;

    public NumericPad(MobileElement container) {
        super(container);
    }


    public NumericPad clickOnDigitZero(){
        click(digitZeroButton);
        return this;
    }

    public NumericPad clickOnDigitOne(){
        click(digitOneButton);
        return this;
    }

    public NumericPad clickOnDigitTwo(){
        click(digitTwoButton);
        return this;
    }

    public NumericPad clickOnDigitThree(){
        click(digitThreeButton);
        return this;
    }

    public NumericPad clickOnDigitFour(){
        click(digitFourButton);
        return this;
    }

    public NumericPad clickOnDigitFive(){
        click(digitFiveButton);
        return this;
    }

    public NumericPad clickOnDigitSix(){
        click(digitSixButton);
        return this;
    }

    public NumericPad clickOnDigitSeven(){
        click(digitSevenButton);
        return this;
    }

    public NumericPad clickOnDigitEight(){
        click(digitEightButton);
        return this;
    }

    public NumericPad clickOnDigitNine(){
        click(digitNineButton);
        return this;
    }

    public NumericPad clickOnDigitDot(){
        click(digitDotButton);
        return this;
    }

    public NumericPad clickOnDigitEquals(){
        click(digitEqualsButton);
        return this;
    }

}
