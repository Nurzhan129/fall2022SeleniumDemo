package org.example.intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{

    @Test
    public void testSelect(){
        driver.navigate().to("https://demoqa.com/select-menu21");
//        driver.findElement(By.xpath(".//input[@id='react-select-2-input']")).sendKeys("Group 2,option 2")

    }
}
