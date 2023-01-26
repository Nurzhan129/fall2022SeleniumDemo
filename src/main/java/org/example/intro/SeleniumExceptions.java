package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void NoSuchElementException(){
        // NoSuchElementException: нет такого элемента: не удается найти элемент:

        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello World");
    }
    @Test
    public void noSuchWindowException(){
        // NoSuchWindowException
        // no such window когда не находит нужное окошко

        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.switchTo().window("id");
    }
    @Test
    public void noSuchFrameException(){
        // noSuchFrameException
        // no such frame
        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }
    @Test
    public void noSuchAlertException(){
        // noSuchAlertException
        browserHelper.openUrl("https://demoqa.com/text-box");
        alertHelper.acceptAlert();
    }
    @Test
    public void invalidSelectorException(){
        // InvalidSelectorException когда допускаем синтаксическую ошибка, invalid css or XPath selector
        // Исключение недопустимого селектора: недопустимый селектор: недопустимый или незаконный
        browserHelper.openUrl("https://demoqa.com/text-box");
        SessionId s = ((RemoteWebDriver) driver).getSessionId();// this is for get id session
        System.out.println("Session id is " + s);

//        driver.findElement(By.cssSelector("//button[@type='button'][2]"));
    }
    @Test
    public void noSuchSessionException(){
        // Исключение NoSuchSessionException: идентификатор сеанса равен нулю. Использование WebDriver после вызова quit()?
        // после закрытия сессии, мы пытаемся открыть сайт,но после закрытия выдает ошибку NoSuchSessionException
        // every session have id, for exp: Session id is 96116f3d467beb1c1e45683f5869516a
        driver.quit();
        browserHelper.openUrl("https://demoqa.com/text-box");
    }
    @Test
    public void staleElementReferenceExceptionTest(){
        // Исключение StaleElementReferenceException
        // Это исключение возникает, когда веб-элемент больше не является частью веб-страницы.
        // Элемент, возможно, был частью исходного кода, но он больше не является частью окна. Для этого исключения может быть несколько причин. Это может произойти либо при переключении на другую страницу,
        // элемент больше не является частью DOM, либо из-за переключения фрейма / окна

        // Исключение StaleElementReferenceException: устаревшая ссылка на элемент: элемент не прикреплен к документу страницы
        browserHelper.openUrl("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
//                break;
            }
        }
    }
    @Test
    public void timeOutException(){
        // Исключение TimeoutException: не выполнено ожидаемое условие: ожидание элемента, который можно выбрать: By.id : включить после (пробовал в течение 2 секунд с интервалом 500 миллисекунд)
        // Если команды не выполняются даже по истечении времени ожидания, создается исключение TimeOut.
        browserHelper.openUrl("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
    }
    @Test
    public void test123(){
        browserHelper.openUrl("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).click();
    }

    @Test
    public void ElementNotInteractableException() {
        // element not intractable
        browserHelper.openUrl("https://demoqa.com/radio-button");
//        driver.findElement(By.id("noRadio")).click();
        driver.findElement(By.id("noRadio")).sendKeys("saas");
    }
    @Test
    public void elementClickInterceptedExceptionTest(){
        browserHelper.openUrl("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }
    @Test
    public void NoSuchAttributeException(){
        browserHelper.openUrl("https://demoqa.com/text-box");
        WebElement element = driver.findElement(By.id("userNAme"));
        String name = element.getAttribute("Name");
    }
}
