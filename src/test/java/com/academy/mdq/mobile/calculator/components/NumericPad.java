package com.academy.mdq.mobile.calculator.components;

import com.academy.mdq.page.mobile.MobileComponent;
import com.academy.mdq.waits.Waits;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NumericPad extends MobileComponent {


    @AndroidFindBy(id = "digit_0")
    private MobileElement digitZeroButton;
    @AndroidFindBy(id = "digit_1")
    private MobileElement digitOneButton;
    @AndroidFindBy(id = "digit_2")
    private MobileElement digitTwoButton;
    @AndroidFindBy(id = "digit_3")
    private MobileElement digitThreeButton;
    @AndroidFindBy(id = "digit_4")
    private MobileElement digitFourButton;
    @AndroidFindBy(id = "digit_5")
    private MobileElement digitFiveButton;
    @AndroidFindBy(id = "digit_6")
    private MobileElement digitSixButton;
    @AndroidFindBy(id = "digit_7")
    private MobileElement digitSevenButton;
    @AndroidFindBy(id = "digit_8")
    private MobileElement digitEightButton;
    @AndroidFindBy(id = "digit_9")
    private MobileElement digitNineButton;
    @AndroidFindBy(id = "dec_point")
    private MobileElement digitDotButton;

    public NumericPad(MobileElement container) {
        super(container);
    }

    private int[] getNumber(int number) {
        int digitFive = number % 10;
        int digitFour = (number / 10) % 10;
        int digitThree = (number / 100) % 10;
        int digitTwo = (number / 1000) % 10;
        int digitOne = (number / 10000) % 10;
        int[] integersNum = new int[]{digitOne, digitTwo, digitThree, digitFour, digitFive};
        return integersNum;
    }


    public NumericPad clickOnNumber(int number) {
        for (int idx = 0 ; idx < getNumber(number).length ; idx++) {
            if (getNumber(number)[idx] == (Integer.parseInt(digitOneButton.getText()))) {
                click(digitOneButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitTwoButton.getText()))) {
                click(digitTwoButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitThreeButton.getText()))) {
                click(digitThreeButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitFourButton.getText()))) {
                click(digitFourButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitFiveButton.getText()))) {
                click(digitFiveButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitSixButton.getText()))) {
                click(digitSixButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitSevenButton.getText()))) {
                click(digitSevenButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitEightButton.getText()))) {
                click(digitEightButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitNineButton.getText()))) {
                click(digitNineButton);
            } else if (getNumber(number)[idx] == (Integer.parseInt(digitZeroButton.getText()))) {
                click(digitZeroButton);
            }
        }
        return this;
    }
}
