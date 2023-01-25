package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkActions extends BaseTest {
    @Test
    public void testMoveToElement() {
        driver.get("https://www.imoving.com/full-inventory/#!/");
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
        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        WebElement boxItem = driver.findElement(By.xpath("(//div[@class='arrowOpenRightNavigation leftArrowNavi'])[2]"));
        boxItem.click();
        driver.findElement(By.xpath("(//span[@class='roomPanelIcon quantity-plus1'])[1]")).click();



        WebElement expectedItems = driver.findElement(By.xpath("//span[@class='room-counter']"));
        Assert.assertEquals(expectedItems.getText(),"9 items");

        WebElement dresser = driver.findElement(By.xpath(".//h3[text()='Dresser']"));
        Assert.assertEquals(dresser.getText(),"Dresser");

        WebElement bed = driver.findElement(By.xpath(".//h3[text()='Bed (All parts included)']"));
        Assert.assertEquals(bed.getText(),"Bed (All parts included)");

        WebElement tv = driver.findElement(By.xpath(""));
        Assert.assertEquals(tv.getText(),"");





    }
}