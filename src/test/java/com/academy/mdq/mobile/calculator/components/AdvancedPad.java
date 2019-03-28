package com.academy.mdq.mobile.calculator.components;

import com.academy.mdq.page.mobile.MobileComponent;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedPad extends MobileComponent {

    public AdvancedPad(MobileElement container) {
        super(container);
    }

    @FindBy (id = "toggle_inv")
        private MobileElement inverseFuncButton;

        @FindBy (id = "toggle_mode")
    private MobileElement degreesSwitchButton;

        @FindBy (id = "op_pct")
    private MobileElement percentButton;

        @FindBy (id = "fun_sin")
    private MobileElement sineFuncButton;

        @FindBy (id = "fun_cos")
    private MobileElement cosineFuncButton;

        @FindBy (id = "fun_tan")
    private MobileElement tangentFuncButton;

        @FindBy (id = "fun_ln")
    private MobileElement logNatFuncButton;

        @FindBy (id = "fun_log")
    private MobileElement logFuncButton;

        @FindBy (id = "op_fact")
    private MobileElement factorialButton;

        @FindBy (id = "const_pi")
    private MobileElement piButton;

        @FindBy (id = "const_e")
    private MobileElement eNumberButton;

        @FindBy (id = "op_pow")
    private MobileElement powerOpButton;

        @FindBy (id = "lparen")
    private MobileElement lParentButton;

        @FindBy (id = "rparen")
    private MobileElement rParentFuncButton;

        @FindBy (id = "op_sqrt")
    private MobileElement squareRootButton;
}
