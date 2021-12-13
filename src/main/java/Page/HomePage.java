package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final String HOMEPAGE_URL = "https://nominex.io/ru";

    @FindBy(css = ".space-x-16 > sl-button:nth-child(1)")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {super(driver);}

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public LoginPage openLoginWindow() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
