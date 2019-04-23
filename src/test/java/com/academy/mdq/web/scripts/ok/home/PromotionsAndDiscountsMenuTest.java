package com.academy.mdq.web.scripts.ok.home;

import com.academy.mdq.testsuite.BaseTestSuite;
import com.academy.mdq.web.pages.commons.Banner;
import com.academy.mdq.web.pages.commons.ToolBarComponents.NavBar;
import com.academy.mdq.web.pages.home.Home;
import com.academy.mdq.web.pages.promotionsanddiscounts.Discounts;
import com.academy.mdq.web.pages.promotionsanddiscounts.PromotionPage;
import com.academy.mdq.web.pages.promotionsanddiscounts.Promotions;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.CategoriesMenu;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.DiscountCard;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.DiscountsByCategory;
import com.academy.mdq.web.pages.promotionsanddiscounts.components.PreviewPromotionCard;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.academy.mdq.web.pages.promotionsanddiscounts.components.CategoriesMenu.Category.*;
import static org.hamcrest.CoreMatchers.*;

public class PromotionsAndDiscountsMenuTest extends BaseTestSuite {

  private final List<String> promotionsLinks = Arrays.asList("promocion-amazon-prime", "promo-casa-del-libro",
      "gana-100-euros-gestion-discrecional", "descuentos-estaciones-servicio-galp-cataluna", "sorteo-samsung-galaxy-watch",
      "aplazar-compras-pagos-5", "/ahorrar-dinero-consigue-premios", "invertir-bolsa", "sorteo-tarjetas-500-euros-carburante",
      "promocion-nomina-cumplenomina");

  @Test
  public void promotionsSubPageTest() {
    NavBar navBar = new Home().getNavBar();
    Promotions promotions = navBar.clickPromotionsAndDiscounts().clickPromotions();
    List<PreviewPromotionCard> promotionCards = promotions.getPromotionCards();

    for (int i = 0; i < promotionCards.size(); i++) {
      checkThat("The link is the same AS " + promotionsLinks.get(i), promotionCards.get(i).getHref(), containsString(promotionsLinks.get(i)));
      checkThat("The background image is visible", promotionCards.get(i).isVisibleImage(), is(true));
      checkThat("The title is visible", promotionCards.get(i).isVisibleTitle(), is(true));
      checkThat("The description is visible", promotionCards.get(i).isVisibleDescription(), is(true));
      checkThat("The button is visible", promotionCards.get(i).isVisibleButton(), is(true));

      PromotionPage promPage = promotionCards.get(i).clickCard();
      Banner banner = promPage.getBanner();

      checkThat("The banner text is visible", banner.isBannerTextVisible(), is(true));
      checkThat("The banner image is visible", banner.isBannerImgVisible(), is(true));
      checkThat("The miniBanner is visible", banner.isBoxImgVisible(), is(true));
      checkThat("The miniBanner Text is visible", banner.isBoxTextVisible(), is(true));
      checkThat("The miniBanner button is visible", banner.isBoxButtonVisible(), is(true));
      checkThat("The miniBanner button is enabled", banner.isBoxButtonEnabled(), is(true));

      promotions = promPage.getBack();
      promotionCards = promotions.getPromotionCards();
    }
  }

  @Test
  public void discountsSubPageTest() {
    NavBar navBar = new Home().getNavBar();
    Discounts discounts = navBar.clickPromotionsAndDiscounts().clickDiscounts();

    checkThat("The page corresponds to the Discounts page", discounts.getPageTitle(),equalTo("Descuentos Open"));

    CategoriesMenu categoriesMenu = discounts.getCategoriesMenu();

    checkThat("The category 'Restaurants' is visible", categoriesMenu.isVisible(RESTAURANTES), is(true));
    checkThat("The category 'Fashion' is visible", categoriesMenu.isVisible(MODA), is(true));
    checkThat("The category 'Hotels' is visible", categoriesMenu.isVisible(HOTELES), is(true));
    checkThat("The category 'Leisure' is visible", categoriesMenu.isVisible(OCIO), is(true));
    checkThat("The category 'Transportation' is visible", categoriesMenu.isVisible(TRANSPORTE), is(true));
    checkThat("The category 'Beauty' is visible", categoriesMenu.isVisible(BELLEZA), is(true));

    DiscountsByCategory discountsByCategory = discounts.clickDiscountByCategory(RESTAURANTES);
    checkThat("The discounts By Category section corresponds to the Category Restaurants", discountsByCategory.getTitle().toLowerCase(), containsString(RESTAURANTES.toString().toLowerCase()));
    checkThat("The category title Restaurants is visible in the section", discountsByCategory.isVisibleTitle(), is(true));

    for (DiscountCard card : discountsByCategory.getDiscountCards()) {
      checkThat("The card's title is visible", card.isVisibleTitle(), is(true));
      checkThat("The card's description is visible", card.isVisibleDescription(), is(true));
      checkThat("The card's button is visible", card.isVisibleButton(), is(true));
    }

    discountsByCategory = discounts.clickDiscountByCategory(MODA);
    checkThat("The category title Fashion is visible in the section", discountsByCategory.isVisibleTitle(), is(true));
    checkThat("The discounts By Category section corresponds to the Category Fashion", discountsByCategory.getTitle().toLowerCase(), containsString(MODA.toString().toLowerCase()));

    for (DiscountCard card : discountsByCategory.getDiscountCards()) {
      checkThat("The card's title is visible", card.isVisibleTitle(), is(true));
      checkThat("The card's description is visible", card.isVisibleDescription(), is(true));
      checkThat("The card's button is visible", card.isVisibleButton(), is(true));
    }

    discountsByCategory = discounts.clickDiscountByCategory(HOTELES);
    checkThat("The category title Hotels is visible in the section", discountsByCategory.isVisibleTitle(), is(true));
    checkThat("The discounts By Category section corresponds to the Category Hotels", discountsByCategory.getTitle().toLowerCase(), containsString(HOTELES.toString().toLowerCase()));

    for (DiscountCard card : discountsByCategory.getDiscountCards()) {
      checkThat("The card's title is visible", card.isVisibleTitle(), is(true));
      checkThat("The card's description is visible", card.isVisibleDescription(), is(true));
      checkThat("The card's button is visible", card.isVisibleButton(), is(true));
    }

    discountsByCategory = discounts.clickDiscountByCategory(OCIO);
    checkThat("The category title Leisure is visible in the section", discountsByCategory.isVisibleTitle(), is(true));
    checkThat("The discounts By Category section corresponds to the Category Leisure", discountsByCategory.getTitle().toLowerCase(), containsString(OCIO.toString().toLowerCase()));

    for (DiscountCard card : discountsByCategory.getDiscountCards()) {
      checkThat("The card's title is visible", card.isVisibleTitle(), is(true));
      checkThat("The card's description is visible", card.isVisibleDescription(), is(true));
      checkThat("The card's button is visible", card.isVisibleButton(), is(true));
    }

    discountsByCategory = discounts.clickDiscountByCategory(TRANSPORTE);
    checkThat("The category title Transportation is visible in the section", discountsByCategory.isVisibleTitle(), is(true));
    checkThat("The discounts By Category section corresponds to the Category Transportation", discountsByCategory.getTitle().toLowerCase(), containsString(TRANSPORTE.toString().toLowerCase()));

    for (DiscountCard card : discountsByCategory.getDiscountCards()) {
      checkThat("The card's title is visible", card.isVisibleTitle(), is(true));
      checkThat("The card's description is visible", card.isVisibleDescription(), is(true));
      checkThat("The card's button is visible", card.isVisibleButton(), is(true));
    }

    discountsByCategory = discounts.clickDiscountByCategory(BELLEZA);
    checkThat("The category title Beauty is visible in the section", discountsByCategory.isVisibleTitle(), is(true));
    checkThat("The discounts By Category section corresponds to the Category Beauty", discountsByCategory.getTitle().toLowerCase(), containsString(BELLEZA.toString().toLowerCase()));

    for (DiscountCard card : discountsByCategory.getDiscountCards()) {
      checkThat("The card's title is visible", card.isVisibleTitle(), is(true));
      checkThat("The card's description is visible", card.isVisibleDescription(), is(true));
      checkThat("The card's button is visible", card.isVisibleButton(), is(true));
    }
  }

}
