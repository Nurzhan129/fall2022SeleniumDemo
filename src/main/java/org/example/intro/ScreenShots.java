package org.example.intro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenShots extends BaseTest{

    @Test
    public void screenShotTest() throws Exception {
        browserHelper.openUrl("https://www.amazon.com/");
        takeSnapShot(driver, "/Users/zina/IdeaProjects/UI_framework_Practice/src/main/resources//amazonHomePage.png") ;

    }
    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot Преобразовать объект веб-драйвера для создания скриншота
        TakesScreenshot scrShot =((TakesScreenshot)webdriver); //interface for the screenShot
//Call getScreenshotAs method to create image file Вызовите метод getScreenshotAs для создания файла изображения
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination Переместить файл изображения в новое место назначения
        File DestFile=new File(fileWithPath);
//Copy file at destination Скопируйте файл в пункт назначения
        FileUtils.copyFile(SrcFile, DestFile);
    }
}

