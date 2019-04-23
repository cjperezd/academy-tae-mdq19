package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.Footer;
import com.academy.mdq.web.pages.footer.components.News;
import com.academy.mdq.web.pages.home.Home;
import org.junit.Test;

import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;

public class FooterTest extends BaseTestSuite {

  @Test
  public void pressTest(){
    Footer footer = new Home().getFooter();
    List<News> newsList = footer.clickPress().getNews();

    for(News news : newsList){
      checkThat(format("The title '%s' is visible",news.getTitle()),news.isVisibleTitle(),is(true));
      checkThat("The image is visible",news.isVisibleImage(),is(true));
      checkThat("The date is visible",news.isVisibleDate(),is(true));
      checkThat("The description is visible",news.isVisibleDescrpition(),is(true));

    }
  }

}
