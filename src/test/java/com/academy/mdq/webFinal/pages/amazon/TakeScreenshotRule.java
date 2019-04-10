package com.academy.mdq.webFinal.pages.amazon;


import com.academy.mdq.driver.Drivers;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


public class TakeScreenshotRule extends TestWatcher {
    private String name;

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);

        String imageName = this.name;
        String nameTest = description.getDisplayName();

        String name = "C:/Users/juan.poli/Desktop/Screenshots/" + imageName + nameTest + ".png";

        File screenshot = ((TakesScreenshot) Drivers.getDriver().getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(name));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void finished(Description description) {
        super.finished(description);
        Drivers.dispose();
    }


    public void setName (String name){
        this.name = name;
    }


}