package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoQATest {
    WebDriver driver;
    Faker faker = new Faker();

    String fakeName;
    String fakeEmail;
    String fakeAddress;
    String fakePerAddress;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

    }
    @Test
    public void assertName() {

        String name = faker.name().fullName(); // Yrysbek
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys(name);

//        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");

        WebElement actualNameElement = driver.findElement(By.id("name"));

        String actualNameText = actualNameElement.getText(); // Name:Yrysbek

        Assert.assertEquals(actualNameText, "Name:" + name); //Name:Yrysbek - Name:Yrysbek
        Assert.assertTrue(actualNameText.contains(name));

    }
    @AfterClass
    public void close() {
        driver.close();
        driver.quit();
    }

}