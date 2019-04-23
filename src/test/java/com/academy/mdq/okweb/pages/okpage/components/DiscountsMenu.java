package com.academy.mdq.okweb.pages.okpage.components;

import com.academy.mdq.page.web.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiscountsMenu extends WebComponent {

    @FindBy (className = "category")
    private List<WebElement> categories;

    public DiscountsMenu (WebElement container){
        super(container);
    }


    public boolean areCategoriesVisible(int idx){
        return categories.get(idx).isDisplayed();
    }

    public int categoriesSize(){
        return categories.size();
    }

    public DiscountsMenu clickCategory(int idx){
        click(categories.get(idx));
        return this;
    }

    public String getCategoryText(int idx){
        return categories.get(idx).getText();
    }
}
