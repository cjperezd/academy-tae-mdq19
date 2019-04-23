package com.academy.mdq.okweb.pages.okpage.components.commons;

import com.academy.mdq.okweb.pages.okpage.okpages.PromoCardPage;
import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PromotionCard extends WebComponent {

    @FindBy(className = "title")
    private WebElement cardTitle;

    @FindBy(className = "description")
    private WebElement description;

    @FindBy(className = "cta-container")
    private WebElement ctaContainer;

    @FindBy(className = "button")
    private WebElement ctaButton;

    @FindBy(className = "image")
    private WebElement image;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/promocion-amazon-prime\"]")
    private WebElement urlAmazonPrimeElement;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/promo-casa-del-libro\"]")
    private WebElement urlCasaLibro;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/gana-100-euros-gestion-discrecional\"]")
    private WebElement urlInversions;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/descuentos-estaciones-servicio-galp-cataluna\"]")
    private WebElement urlGalp;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/sorteo-samsung-galaxy-watch\"]")
    private WebElement urlSamsung;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/aplazar-compras-pagos-5\"]")
    private WebElement urlTrip;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/ahorrar-dinero-consigue-premios\"]")
    private WebElement urlDeposit;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/invertir-bolsa\"]")
    private WebElement urlOperationInvest;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/sorteo-tarjetas-500-euros-carburante\"]")
    private WebElement urlDraw;

    @FindBy(css = "a[href=\"https://www.openbank.es/ofertas-bancarias/promocion-nomina-cumplenomina\"]")
    private WebElement urlOnePercent;


    private List<WebElement> urlsElements = new ArrayList<WebElement>() {
        {
            add(urlAmazonPrimeElement);
            add(urlCasaLibro);
            add(urlInversions);
            add(urlGalp);
            add(urlSamsung);
            add(urlTrip);
            add(urlDeposit);
            add(urlOperationInvest);
            add(urlDraw);
            add(urlOnePercent);

        }
    };

    private List<String> urls = new ArrayList<String>() {
        {
            add("https://www.openbank.es/ofertas-bancarias/promocion-amazon-prime");
            add("https://www.openbank.es/ofertas-bancarias/promo-casa-del-libro");
            add("https://www.openbank.es/ofertas-bancarias/gana-100-euros-gestion-discrecional");
            add("https://www.openbank.es/ofertas-bancarias/descuentos-estaciones-servicio-galp-cataluna");
            add("https://www.openbank.es/ofertas-bancarias/sorteo-samsung-galaxy-watch");
            add("https://www.openbank.es/ofertas-bancarias/aplazar-compras-pagos-5");
            add("https://www.openbank.es/ofertas-bancarias/ahorrar-dinero-consigue-premios");
            add("https://www.openbank.es/ofertas-bancarias/invertir-bolsa");
            add("https://www.openbank.es/ofertas-bancarias/sorteo-tarjetas-500-euros-carburante");
            add("https://www.openbank.es/ofertas-bancarias/promocion-nomina-cumplenomina");
        }

    };


    public PromotionCard(WebElement container) {
        super(container);
    }


    public boolean areElementsDisplayed() {
        return cardTitle.isDisplayed() && description.isDisplayed() && ctaContainer.isDisplayed() && image.isDisplayed();
    }


    public boolean areLinkOk(int idx) {
        return urls.get(idx).equals(urlsElements.get(idx).getAttribute("href"));
    }

    public PromoCardPage clickOnCtaButton() {
        click(ctaButton);
        return new PromoCardPage();
    }

}
