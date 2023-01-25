package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {
    WebDriver driver;
    BrowserHelper browserHelper;
    AlertHelper alertHelper;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();// Creating instance ChromeDriver
        driver.manage().window().maximize(); // using manage methods maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Driver will wait 20 seconds
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);

    }

    @AfterClass
    public void close(){
//        driver.close();
//        driver.quit();
    }

}
