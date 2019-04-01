package com.academy.mdq.mobile.pages;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.academy.mdq.waits.Waits.isVisible;

public class CalculatorPage extends MobilePage {

  @AndroidFindBy(id = "digit_0")
  private WebElement zeroButton;

  @AndroidFindBy(id = "digit_1")
  private WebElement oneButton;

  @AndroidFindBy(id = "digit_2")
  private WebElement twoButton;

  @AndroidFindBy(id = "digit_3")
  private WebElement threeButton;

  @AndroidFindBy(id = "digit_4")
  private WebElement fourButton;

  @AndroidFindBy(id = "digit_5")
  private WebElement fiveButton;

  @AndroidFindBy(id = "digit_6")
  private WebElement sixButton;

  @AndroidFindBy(id = "digit_7")
  private WebElement sevenButton;

  @AndroidFindBy(id = "digit_8")
  private WebElement eightButton;

  @AndroidFindBy(id = "digit_9")
  private WebElement nineButton;

  @AndroidFindBy(id = "dec_point")
  private WebElement pointButton;

  @AndroidFindBy(id = "op_div")
  private WebElement divButton;

  @AndroidFindBy(id = "op_mul")
  private WebElement mulButton;

  @AndroidFindBy(id = "op_sub")
  private WebElement subButton;

  @AndroidFindBy(id = "op_add")
  private WebElement addButton;

  @AndroidFindBy(id = "eq")
  private WebElement eqButton;

  @AndroidFindBy(id = "result")
  private MobileElement result;

  public CalculatorPage typeNumber(String number) {
    char[] charNumber = number.toCharArray();
    for (char c : charNumber) {
      tapNumber(c);
    }
    return this;
  }

  public CalculatorPage add() {
    click(addButton);
    return this;
  }

  public CalculatorPage subtract () {
    click(subButton);
    return this;
  }

  public CalculatorPage divide() {
    click(divButton);
    return this;
  }

  public CalculatorPage multiply() {
    click(mulButton);
    return this;
  }

  public String equals() {
    click(eqButton);
    return isVisible(result).getText();
  }

  private void tapNumber(char number){
    switch (number){
      case '0': click(zeroButton); break;
      case '1': click(oneButton); break;
      case '2': click(twoButton); break;
      case '3': click(threeButton); break;
      case '4': click(fourButton); break;
      case '5': click(fiveButton); break;
      case '6': click(sixButton); break;
      case '7': click(sevenButton); break;
      case '8': click(eightButton); break;
      case '9': click(nineButton); break;
      case '.': click(pointButton); break;
    }
  }

}
