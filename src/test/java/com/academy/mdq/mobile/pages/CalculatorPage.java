package com.academy.mdq.mobile.pages;

import com.academy.mdq.page.mobile.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CalculatorPage extends MobilePage {

  @AndroidFindBy(className = "android.widget.Button")
  private List<MobileElement> allButtons;

  @AndroidFindBy(id = "result")
  private MobileElement formulaView;

  public String addition(float[] n) {
    for (int i = 0; i < n.length; i++) {
      char[] numberToString = String.valueOf(n[i]).toCharArray();
      for (char c : numberToString) {
        allButtons.stream().filter(button -> button.getAttribute("text").equals(String.valueOf(c))).findFirst().ifPresent(MobileElement::click);
      }
      if (i < (n.length - 1))
        allButtons.stream().filter(button -> button.getAttribute("text").equals("+")).findFirst().ifPresent(MobileElement::click);

    }
    allButtons.stream().filter(button -> button.getAttribute("text").equals("=")).findFirst().ifPresent(MobileElement::click);
    return formulaView.getText();
  }

}
