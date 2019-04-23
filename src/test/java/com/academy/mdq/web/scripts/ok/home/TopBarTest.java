package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.contactus.components.PhoneOption;
import com.academy.mdq.web.pages.urgenthelp.UrgentHelp;
import com.academy.mdq.web.pages.commons.ToolBarComponents.TopBar;
import com.academy.mdq.web.pages.home.Home;
import com.academy.mdq.web.pages.urgenthelp.components.ContactOption;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class TopBarTest extends BaseTestSuite {

  @Test
  public void urgentHelpTest(){
    TopBar topBar = new Home().getTopBar();
    checkThat("The urgent help icon is visible", topBar.isHelpIconVisible(),is(true));
    checkThat("The urgent help button is visible", topBar.isHelpButtonVisible(),is(true));

    UrgentHelp urgentHelp = topBar.clickUrgentHelp();

    checkThat("The title of the urgent help page is visible", urgentHelp.isVisiblePageTitle(),is(true));
    checkThat("The title of the contact options is visible", urgentHelp.isVisibleContactTitle(),is(true));
    checkThat("The title of the page refers to 'Ayuda Urgente'", urgentHelp.getPageTitle(),containsString("ayuda urgente"));

    for(ContactOption card : urgentHelp.getContactOptions()){
      checkThat("The icon in the contactCard is visible",card.isVisibleIcon(),is(true));
      checkThat("The name in the contactCard is visible",card.isVisibleName(),is(true));
      checkThat("The phone number in the contactCard is visible",card.isVisibleNumber(),is(true));
    }
  }

  @Test
  public void contactUsTest(){
    TopBar topBar = new Home().getTopBar();
    checkThat("The contact us icon is visible", topBar.isContactUsIconVisible(),is(true));
    checkThat("The contact us button is visible", topBar.isContactUsButtonVisible(),is(true));

    for(PhoneOption option : topBar.clickContactUs().getPhoneOptions()){
      checkThat("The icon in the contact option is visible",option.isIconVisible(),is(true));
    }
  }
}
