package com.academy.mdq.web.tests.google;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.google.Home;
import com.academy.mdq.web.pages.google.commons.Footer;
import org.junit.Test;

public class GoogleTests extends BaseTestSuite {

  @Test
  public void aboutTest (){
    Footer footer = new Home().getFooter();


  }
}
