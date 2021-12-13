package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(css = "ul.flex > li:nth-child(2)")
    private WebElement toMarketsMenu;

    public MainPage(WebDriver driver) {super(driver);}

    public MarketsPage movingToTheMarkets() throws InterruptedException {
        Thread.sleep(2000);
        waitForElementToBeClickable(driver, toMarketsMenu);
        toMarketsMenu.click();
        return new MarketsPage(driver);
    }
}
