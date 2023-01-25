package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomeWorkMoving extends BaseTest{
    @Test
    public void test1(){
        driver.navigate().to("https://www.imoving.com/");
        WebElement houseMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(2000);

        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(moveSizeMenu);
        select2.selectByVisibleText("Just a few Items");
        Helper.pause(2000);

        WebElement clickQuotes = driver.findElement(By.xpath("//button[@class='btn btn-white quickQuoteLink']"));
        clickQuotes.click();
        Helper.pause(2000);

        WebElement continuesBox = driver.findElement(By.xpath("//span[@class='col-sm-9 col-xs-12']"));
        continuesBox.click();
        Helper.pause(3000);

        driver.findElement(By.xpath("//div[@class='modal-buttons']/a")).click();
        Helper.pause(2000);
        driver.findElement(By.id("closeTutorial")).click();

        // create action class for action methods
        Actions action = new Actions(driver);
        WebElement boxDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        action.moveToElement(boxDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(2000);
        WebElement plusBoxDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));

        action.doubleClick(plusBoxDresser).perform();
        Helper.pause(2000);

        WebElement bedImageContainer = driver.findElement(By.xpath("//div[@class='13']//figure"));
        action.moveToElement(bedImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='13']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(2000);
        WebElement plusBoxBed = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        action.doubleClick(plusBoxBed).perform();

        WebElement tvImageContainer = driver.findElement(By.xpath("//div[@class='12']//figure"));
        action.moveToElement(tvImageContainer).build().perform();
        driver.findElement(By.cssSelector("div[class='12'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']")).click();
        Helper.pause(2000);
//        WebElement sofaImageContainer = driver.findElement(By.xpath("//div[@class='10']//figure"));
//        action.moveToElement(sofaImageContainer).build().perform();
        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        WebElement boxItem = driver.findElement(By.xpath("(//div[@class='arrowOpenRightNavigation leftArrowNavi'])[2]"));
        boxItem.click();


        driver.findElement(By.xpath("(//span[@class='roomPanelIcon quantity-plus1'])[1]")).click();
        driver.findElement(By.xpath("(.//h3[@class='action-header'])[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        // click box
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]")).click();
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]")).click();
        driver.findElement(By.xpath("(//button[@class='quantity-plus'])[2]")).click();

        // click add and continue
        driver.findElement(By.xpath("//a[text()='Add and Continue']")).click();

        // click restrictions
//        driver.findElement(By.xpath("(.//input[@ng-focus='vmInputAutoComplete.geolocate()'])[1]")).click();

        // enter placeHolder
        WebElement enterZipCode = driver.findElement(By.xpath("(.//input[@ng-focus='vmInputAutoComplete.geolocate()'])[1]"));
        enterZipCode.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("60007");
        alert.accept();


    }
}
