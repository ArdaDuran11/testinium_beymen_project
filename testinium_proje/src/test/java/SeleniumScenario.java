
import pages.BasketPage;
import pages.HomePage;
import pages.ProductPage;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumScenario {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private BasketPage basketPage;
    private static Logger log = Logger.getLogger(SeleniumScenario.class);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSeleniumAutomation() {
        homePage.open("https://www.beymen.com/");
        log.info("Ana sayfa açıldı.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.clickButtonById("onetrust-reject-all-handler");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        homePage.clickButtonById("genderManButton");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.inputfieldClick("o-header__search--wrapper");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.searchForProduct("şort");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.clickEnterForProduct("Gömlek");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.selectProducts();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.productInfo();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.clickSizeButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.clickAddBasketButton("addBasket");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        basketPage.clickQuantityButton("quantitySelect2-key-0");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        basketPage.deleteBasketButton("removeCartItemBtn0-key-0");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        basketPage.checkBasketIsEmpty();
    }


}


