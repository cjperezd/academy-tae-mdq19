package com.academy.mdq.mobile.pages.calculator;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class CalculatorApp extends MobilePage {

    @AndroidFindBy (id = "digit_0")
    private MobileElement button0;

    @AndroidFindBy (id = "digit_1")
    private MobileElement button1;

    @AndroidFindBy (id = "digit_2")
    private MobileElement button2;

    @AndroidFindBy (id = "digit_3")
    private MobileElement button3;

    @AndroidFindBy (id = "digit_4")
    private MobileElement button4;

    @AndroidFindBy (id = "digit_5")
    private MobileElement button5;

    @AndroidFindBy (id = "digit_6")
    private MobileElement button6;

    @AndroidFindBy (id = "digit_7")
    private MobileElement button7;

    @AndroidFindBy (id = "digit_8")
    private MobileElement button8;

    @AndroidFindBy (id = "digit_9")
    private MobileElement button9;

    @AndroidFindBy (id = "op_add")
    private MobileElement buttonAdd;

    @AndroidFindBy (id = "op_sub")
    private MobileElement buttonSub;

    @AndroidFindBy (id = "digit_div")
    private MobileElement buttonDiv;

    @AndroidFindBy (id = "op_mul")
    private MobileElement buttonMul;

    @AndroidFindBy (id = "eq")
    private MobileElement buttonEqual;

    @AndroidFindBy (id = "del")
    private MobileElement buttonDel;

    @AndroidFindBy (id = "dec_point")
    private MobileElement buttonPoint;

    @AndroidFindBy (id = "result")
    private MobileElement result;

    @AndroidFindBy (id = "formula")
    private MobileElement formula;

    @AndroidFindBy (id = "lparen")
    private MobileElement parentLeftButton;

    @AndroidFindBy (id = "rparen")
    private MobileElement parentRightButton;



    private MobileElement getButton (char buttonSymbol) throws Exception
    {
        switch (buttonSymbol){
            case '1':
                return button1;

            case '2':
                return button2;

            case '3':
                return button3;

            case '4':
                return button4;

            case '5':
                return button5;

            case '6':
                return button6;

            case '7':
                return button7;

            case '8':
                return button8;

            case '9':
                return button9;

            case '0':
                return button0;

            case '=':
                return buttonEqual;

            case '+':
                return buttonAdd;

            case '-':
                return buttonSub;

            case '*':
                return buttonMul;

            case '/':
                return buttonDiv;

            case 'd':
                return buttonDel;

            case '.':
                return buttonPoint;


        }
        throw new Exception("Error: Non-existing number/operation");
    }

    public CalculatorApp enterCalculation (String calculation)
    {
        char[] symbols = calculation.toCharArray();
        for(char symbol : symbols)
            try {
                click(getButton(symbol));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return this;
    }

    public String getResult ()
    {
        return result.getText();
    }

    private CalculatorApp putResultInFormula ()
    {
        formula.sendKeys(result.getText());
        return this;
    }

}
