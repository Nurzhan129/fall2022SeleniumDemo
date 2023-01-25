package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{

    @Test
    public void testAlert1(){
        driver.get("https://demoqa.com/alerts");

        WebElement alertBtn = driver.findElement(By.id("alertButton"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(2000);
    }

    @Test
    public void testExplicitWaitAndAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.id("timerAlertButton"));
        alertBtn.click();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));// create object wait
        wait.until(ExpectedConditions.alertIsPresent()); // wait until click ok
        Alert alert = driver.switchTo().alert(); // переключатель
        alert.accept();

    }

    @Test
    public void testThirdBtn(){
        driver.get("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement alertBtn = driver.findElement(By.id("confirmButton"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert(); // переключатель
        alert.dismiss();
        WebElement cancelText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(cancelText.getText(),"You selected Cancel");

    }
    @Test
    public void testEnterText(){
        driver.get("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement promtBtn = driver.findElement(By.id("promtButton"));
        promtBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Nurzhan");
        alert.accept();
        WebElement enterText = driver.findElement(By.id("promtResult"));
        Assert.assertEquals(enterText.getText(),"You entered Nurzhan");

    }

}
