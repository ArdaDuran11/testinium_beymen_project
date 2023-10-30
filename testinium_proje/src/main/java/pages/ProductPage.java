package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ProductPage {
    private WebDriver driver;
    private By productTitle = By.xpath("//h1[@class='product-title']");
    private By productPrice = By.xpath("//span[@class='product-price']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public void selectProducts() {
        List<WebElement> products = driver.findElements(By.id("productList"));
        int productCount = products.size();
        Random rand = new Random();
        int randomIndex = rand.nextInt(productCount);

        WebElement randomProduct = products.get(randomIndex);
        randomProduct.click();
    }

    public void productInfo() {
        String productName = driver.findElement(By.className("o-productDetail__description")).getText();
        String productPrice = driver.findElement(By.id("priceNew")).getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("selected_product.txt"))) {
            writer.write("Ürün Adı: " + productName);
            writer.newLine();
            writer.write("Ürün Fiyatı: " + productPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickSizeButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.cssSelector("span.m-variation__item"));
        js.executeScript("arguments[0].click();", element);

    }

    public void clickAddBasketButton(String buttonId) {
        //Bu metod içinde sepete ekle, sepete git ve fiyat karşılaştırmaları yapılmıştır.

        WebElement button = driver.findElement(By.id(buttonId));
        button.click();

        WebElement productPriceElement = driver.findElement(By.className("m-price__new"));
        String productPriceText = productPriceElement.getText();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement basket = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/a[3]/span"));
        basket.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement productBasketPriceElement = driver.findElement(By.className("m-productPrice__salePrice"));
        String productBasketPriceText = productBasketPriceElement.getText();

        double productPrice = Double.parseDouble(productPriceText.replace(",", "").replaceAll("[^0-9.]", ""));
        double productBasketPrice = Double.parseDouble(productBasketPriceText.replace(",", "").replaceAll("[^0-9.]", ""));
        if (productPrice == productBasketPrice) {
            System.out.println("Ürün Fiyatları Eşleşiyor");
        } else {
            System.out.println("Ürün Fiyatları Eşleşmedi");
        }

    }


}

