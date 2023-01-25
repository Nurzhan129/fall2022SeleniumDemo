package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsDemo extends BaseTest{

    @Test
    public void testRadioButton(){
        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadio = driver.findElement(By.xpath(".//label[@class='custom-control-label']"));
        yesRadio.click();
        Assert.assertTrue(yesRadio.isEnabled());
        // isSelected work with checkbox

//        WebElement home = driver.findElement(By.xpath(".//button[@title='Toggle']"));
//        home.click();
        driver.findElement(By.xpath("(.//button[@title='Toggle'])[2]")).click();
        WebElement checkBox = driver.findElement(By.xpath(""));
        checkBox.click();
        Assert.assertTrue(checkBox.isEnabled());

    }

    @Test
    public void testRightClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(rightClickButton).perform();
        Helper.pause(3000);
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),"You have done a double click");

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        Helper.pause(3000);
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).getText().contains("You have done a right click"));

        WebElement clickMeBtn =driver.findElement(By.xpath(".//button[text()='Click Me']"));
        actions.click(clickMeBtn).perform();
        Helper.pause(3000);
        WebElement clickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(clickMessage.getText(),"You have done a dynamic click");


    }

    @Test
    public void testMoveToElementAndSelect(){
        driver.get("https://www.imoving.com/full-inventory/#!/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        Helper.pause(3000);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);
//        select.selectByIndex(3);
    }


}
