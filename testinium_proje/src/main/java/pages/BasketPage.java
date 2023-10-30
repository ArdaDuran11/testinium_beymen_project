package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQuantityButton(String quantityButtonId) {
        WebElement selectElement = driver.findElement(By.id("quantitySelect0-key-0"));
        Select select = new Select(selectElement);
        select.selectByValue("2");
    }

    public void deleteBasketButton(String deleteButton){
        WebElement deleteElement = driver.findElement(By.id(deleteButton));
        deleteElement.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(deleteButton)));

    }

    public void checkBasketIsEmpty(){

        WebElement pageContentElement = driver.findElement(By.tagName("body"));
        String pageContent = pageContentElement.getText();
        if (pageContent.contains("Sepetinizde Ürün Bulunmamaktadır")) {
            System.out.println("Sepet boş.");
        } else {
            System.out.println("Sepet dolu.");
        }
    }
}
