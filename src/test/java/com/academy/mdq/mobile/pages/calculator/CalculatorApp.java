package com.academy.mdq.mobile.pages.calculator;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalculatorApp extends MobilePage {

  @AndroidFindBy(id = "digit_0")
  private MobileElement button0;

  @AndroidFindBy(id = "digit_1")
  private MobileElement button1;

  @AndroidFindBy(id = "digit_2")
  private MobileElement button2;

  @AndroidFindBy(id = "digit_3")
  private MobileElement button3;

  @AndroidFindBy(id = "digit_4")
  private MobileElement button4;

  @AndroidFindBy(id = "digit_5")
  private MobileElement button5;

  @AndroidFindBy(id = "digit_6")
  private MobileElement button6;

  @AndroidFindBy(id = "digit_7")
  private MobileElement button7;

  @AndroidFindBy(id = "digit_8")
  private MobileElement button8;

  @AndroidFindBy(id = "digit_9")
  private MobileElement button9;

  @AndroidFindBy(id = "op_add")
  private MobileElement buttonAdd;

  @AndroidFindBy(id = "op_sub")
  private MobileElement buttonSub;

  @AndroidFindBy(id = "digit_div")
  private MobileElement buttonDiv;

  @AndroidFindBy(id = "op_mul")
  private MobileElement buttonMul;

  @AndroidFindBy(id = "eq")
  private MobileElement buttonEqual;

  @AndroidFindBy(id = "del")
  private MobileElement buttonDel;

  @AndroidFindBy(id = "dec_point")
  private MobileElement buttonPoint;

  @AndroidFindBy(id = "result")
  private MobileElement result;

  @AndroidFindBy(id = "formula")
  private MobileElement formula;

  @AndroidFindBy(id = "lparen")
  private MobileElement parentLeftButton;

  @AndroidFindBy(id = "rparen")
  private MobileElement parentRightButton;

  private void clickButton(char number) {
    switch (number) {
      case '1':
        click(button1);
        break;
      case '2':
        click(button2);
        break;
      case '3':
        click(button3);
        break;
      case '4':
        click(button4);
        break;
      case '5':
        click(button5);
        break;
      case '6':
        click(button6);
        break;
      case '7':
        click(button7);
        break;
      case '8':
        click(button8);
        break;
      case '9':
        click(button9);
        break;
      case '0':
        click(button0);
        break;
      case '.':
        click(buttonPoint);
        break;
    }
  }

  public CalculatorApp typeNumber(String number) {
    char[] numbers = number.toCharArray();
    for (char num : numbers) {
      clickButton(num);
    }
    return this;
  }

  public CalculatorApp plus() {
    click(buttonAdd);
    return this;
  }

  public CalculatorApp equal() {
    click(buttonEqual);
    return this;
  }

  public String getResult() {
    return result.getText().replace(",", "");
  }

}
