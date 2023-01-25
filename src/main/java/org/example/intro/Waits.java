package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest{

    @Test
    public void testExplicitWait(){
        driver.navigate().to("https://demoqa.com/dynamic-properties");
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();

        // have a special class Expected conditions,where are

//        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class","text-danger"));
//        WebElement colorChange = driver.findElement(By.id("colorChange"));
//        colorChange.click();

        WebElement visibleAfter = driver.findElement(By.id("visibleAfter"));
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(visibleAfter)).click();

        wait.until(ExpectedConditions.attributeContains(By.id("visibleAfter"),"class","mt-4 btn btn-primary"));
        WebElement visibleAfter1 = driver.findElement(By.id("visibleAfter"));
        visibleAfter1.click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter"))).click();

    }

    @Test
    public void testEtsy(){
        driver.navigate().to("https://www.etsy.com/");
        WebElement signIn = driver.findElement(By.xpath(".//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();

        //email
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("join_neu_email_field"))).sendKeys("Nur.gmail.com");
        //password
        wait.until(ExpectedConditions.elementToBeClickable(By.id("join_neu_password_field"))).sendKeys("230099");
        //click sing In
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@class='wt-btn wt-btn--primary wt-width-full']"))).click();

    }

    // FluentWait
}
