package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo extends BaseTest{



    @Test
    public void test1(){
        browserHelper.openUrl("https://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        Helper.pause(5000);
        browserHelper.switchToWindow(1);
        Helper.pause(2000);
        browserHelper.switchToParent();
        Helper.pause(2000);

    }
}
