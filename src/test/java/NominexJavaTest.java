import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Page.HomePage;
import Page.LoginPage;
import Page.MarketsPage;
import Page.TradePage;
import Page.MainPage;

import java.util.Arrays;

public class NominexJavaTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MarketsPage marketsPage;
    private TradePage tradePage;
    private MainPage mainPage;

    private String email = "viteksilin@mail.ru";
    private String pass = "Qw321645";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("--no-sandbox","--ignore-certificate-errors","--homepage=about:blank","--no-first-run", "start-maximized", "--disable-notifications"));
        driver = new ChromeDriver(options);
        marketsPage = new HomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(email)
                .enterPassword(pass)
                .signIn()
                .movingToTheMarkets();
    }

    @Test(description = "Viewing deals ")
    public void viewDeals() throws InterruptedException {
        tradePage = marketsPage.SelectCurrency()
                .goToTradePage()
                .ViewingDeals();

        //Assert.assertTrue(currencyTradeTab.haveTokensBeenBought());
    }

    @Test(description = "Change of view ")
    public void choiseViewGraph() throws InterruptedException {
        tradePage = marketsPage.SelectCurrency()
                .goToTradePage()
                .ViewPriceChanges();

       // Assert.assertTrue(TradePage.haveTokensBeenBought());
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}