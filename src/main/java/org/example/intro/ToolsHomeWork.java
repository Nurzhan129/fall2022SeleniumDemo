package org.example.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class ToolsHomeWork extends BaseTest {
    @Test
    public void test1() {
        driver.navigate().to("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        Faker faker = new Faker();
        String firstName = faker.name().name();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String age = String.valueOf(faker.number().randomDigit());
        String salary = String.valueOf(faker.number().randomDigit());
        String department = faker.job().field();


        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement salaryInput = driver.findElement(By.id("salary"));
        WebElement departmentInput = driver.findElement(By.id("department"));

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        ageInput.sendKeys(age);
        salaryInput.sendKeys(salary);
        departmentInput.sendKeys(department);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.id("submit")).click();
        Helper.pause(2000);

        List<WebElement> saveInfo = driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));

        for(WebElement j: saveInfo) {
            System.out.println(j.getText());
            System.out.println("----------------");
            break;
        }
    }
}



//        List<WebElement> allInfo = driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
//        for(WebElement j: allInfo) {
//            System.out.println(j.getText());
//                Helper.pause(3000);
//                System.out.println("----------------");
//                break;
//
//            }







