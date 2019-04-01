package com.academy.mdq.webFinal.pages.components;

import com.academy.mdq.page.web.WebComponent;
import com.academy.mdq.waits.Waits;
import com.academy.mdq.webFinal.pages.amazon.AmazonHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends WebComponent {

    public SearchBar(WebElement container) {
        super(container);
    }

    @FindBy (className = "nav-left")
        private WebElement categorySelector;

    @FindBy (id = "twotabsearchtextbox")
        private WebElement textContainer;

    @FindBy (className = "nav-input")
        private WebElement goButton;


    @FindBy (xpath = "//*[@id=\"searchDropdownBox\"]/option[6]")
        private WebElement bookOption;




    public AmazonHomePage clickOnCategorySelector(){
        click(categorySelector);
        return new AmazonHomePage();
    }

    public void clickOnBookCategory(){
        Waits.isClickable(bookOption);
        click(bookOption);
    }

    public AmazonHomePage clickOnGoButton(){
        click(goButton);
        return new AmazonHomePage();
    }

    public void typeBookText(String bookName){
        type(textContainer,bookName);
    }


}



