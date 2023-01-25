package org.example.intro;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {

    @Test
    public void cssTest() {
        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement click = driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[11]"));
        click.click();

        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']"));
        for (WebElement e : allBrands) {
            System.out.println(e.getText());

            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("//*[@id=\"p_89/SAMSUNG\"]/span/a/div/label/i")).click();
            }

        }

    }
}
