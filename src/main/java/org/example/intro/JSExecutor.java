package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor extends BaseTest{

    @Test
    public void test1(){
        browserHelper.openUrl("https://www.etsy.com/");
        WebElement careerLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        Helper.jsClick(driver,careerLink);
        Helper.pause(10000);
        Helper.jsScrollDown(driver,"300");
        Helper.pause(5000);
        Helper.jsScrollDown(driver,"500");


    }
    @Test
    public void test2(){
        browserHelper.openUrl("https://demoqa.com/dynamic-properties");
        WebElement clickBtn = driver.findElement(By.id("enableAfter"));
        clickBtn.click();
        Helper.elementToBeClickable(driver,clickBtn);
        Helper.pause(5000);

//        WebElement inputFieldUser = driver.findElement(By.className(""));
//        inputFieldUser.sendKeys("nur123@gmail.com");
    }
}
