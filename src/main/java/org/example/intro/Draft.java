package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Draft extends BaseTest {

    @Test
    public void testMoveToElement1(){
        driver.get("https://www.imoving.com/full-inventory/#!/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);
        WebElement moveSize = driver.findElement(By.id("hp-nav-select-house"));
        Select select1 = new Select(moveSize);
        select1.selectByVisibleText("Just a few Items");
        Helper.pause(3000);
        driver.findElement(By.xpath(".//button[@class='btn btn-white quickQuoteLink']")).click();
        driver.findElement(By.xpath(".//span[@class='col-sm-9 col-xs-12']")).click();
        driver.findElement(By.xpath("//div[@class='modal-buttons']/a")).click();
        Helper.pause(3000);
        driver.findElement(By.id("closeTutorial")).click();

        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement clickDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(clickDresser).perform();


        WebElement pictureBed = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/div[1]/section/div[2]/div/div[2]/div/div/figure"));
        actions.moveToElement(pictureBed).perform();
        WebElement clickBed = driver.findElement(By.xpath("(.//a[@ng-show='!item.InShoppingCart && !item.itemIsEdit'])[4]"));
        actions.doubleClick(clickBed).perform();











    }
}
