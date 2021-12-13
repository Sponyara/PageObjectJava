package Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketsPage extends BasePage{

    @FindBy(css = "div.overflow-hidden:nth-child(2) > div:nth-child(1) > sl-dropdown:nth-child(3) > sl-button:nth-child(1)")
    private WebElement selectionOfCurrencySection;

    @FindBy(css = "div.overflow-hidden:nth-child(2) > div:nth-child(1) > sl-dropdown:nth-child(3) > sl-menu:nth-child(2) > sl-menu-item:nth-child(1)")
    private WebElement currencySelection;

    @FindBy(css = "tr.ve-table-body-tr:nth-child(8) > td:nth-child(2)")
    private WebElement buttonToMoveToTheExchangePage;

    protected MarketsPage(WebDriver driver) {super(driver);}

    public MarketsPage SelectCurrency() throws InterruptedException {
        waitForElementToBeClickable(driver, selectionOfCurrencySection);
        selectionOfCurrencySection.click();
        waitForElementToBeClickable(driver, currencySelection);
        currencySelection.click();
        Thread.sleep(2000);
        return this;
    }

    public TradePage goToTradePage() {
        waitForElementToBeClickable(driver, buttonToMoveToTheExchangePage);
        buttonToMoveToTheExchangePage.click();
        return new TradePage(driver);
    }
}
