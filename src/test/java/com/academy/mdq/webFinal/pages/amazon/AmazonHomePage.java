package com.academy.mdq.webFinal.pages.amazon;

import com.academy.mdq.page.web.WebPage;
import com.academy.mdq.waits.Waits;
import com.academy.mdq.webFinal.pages.components.SearchBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends WebPage {


    @FindBy (id = "nav-search")
    private WebElement searchBarContainer;

    SearchBar searchBar = new SearchBar(searchBarContainer);

    /*public SearchBar getSearchBar(){
        return new SearchBar(searchBarContainer);
    }*/

    public AmazonHomePage clickCategotySelector(){
        searchBar.clickOnCategorySelector();
        return this;
    }

    public void clickOnBooks(){
        searchBar.clickOnBookCategory();
    }

    public AmazonResultPage clickOnGo(){
       searchBar.clickOnGoButton();
        return new AmazonResultPage();
    }

    public void typeText(String bookName){
        searchBar.typeBookText(bookName);
    }
}
