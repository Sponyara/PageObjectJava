package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradePage extends BasePage{

    @FindBy(css = "#tab-6")
    private WebElement viewingDeals;

    @FindBy(css = "sl-icon-button.mode-button:nth-child(3)")
    private WebElement viewPriceChanges;


    protected TradePage(WebDriver driver) {super(driver);}

    public TradePage ViewingDeals() {
        waitForElementToBeClickable(driver, viewingDeals);
        viewingDeals.click();
        waitForVisibilityOfElement(driver, viewingDeals);
        return this;
    }
    public TradePage ViewPriceChanges() {
        waitForElementToBeClickable(driver, viewPriceChanges);
        viewPriceChanges.click();
        return this;
    }

}
