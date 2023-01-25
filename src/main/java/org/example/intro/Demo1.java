package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {

    @Test
    public void testDemo1(){


        WebDriverManager.chromedriver().setup(); // Configure ChromeDriver to connect browser

        WebDriver driver = new ChromeDriver(); // Creating instance ChromeDriver
        driver.manage().window().maximize(); // using manage methods maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Driver will wait 20 seconds
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys("Nurzhan");  // method sendKeys for writing something

        WebElement emailInputField = driver.findElement(By.id("userEmail"));
        emailInputField.sendKeys("Kadyrbekova@gmail.com");

        WebElement currentAddressInputFields = driver.findElement(By.id("currentAddress"));
        currentAddressInputFields.sendKeys("Lermontova 12A");

        WebElement permanentAddressInputFields = driver.findElement(By.id("permanentAddress"));
        permanentAddressInputFields.sendKeys("Djal 23/81");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        String exp = "Nurzhan";

        currentAddressInputFields.getText();







        // id should be unique




    }
}
