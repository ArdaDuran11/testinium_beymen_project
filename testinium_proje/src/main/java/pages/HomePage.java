package pages;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class HomePage {
    private WebDriver driver;
    private By searchBox = By.className("o-header__search--wrapper");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void clickButtonById(String buttonId) {
        WebElement button = driver.findElement(By.id(buttonId));
        button.click();
    }

    public void inputfieldClick(String inputClassName) {
        WebElement inputField = driver.findElement(By.className(inputClassName));
        inputField.click();

    }
    public void searchForProduct(String keyword) {
        WebElement searchBox = driver.findElement(By.id("o-searchSuggestion__input"));
        searchBox.sendKeys(keyword);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        searchBox.clear();

    }
    public void clickEnterForProduct(String keyword){
        WebElement inputField = driver.findElement(By.id("o-searchSuggestion__input"));
        inputField.sendKeys(keyword);
        inputField.sendKeys(Keys.ENTER);
    }


}






