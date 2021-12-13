package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "sl-form.mt-20 > sl-input:nth-child(2)")
    private WebElement fieldForEmail;

    @FindBy(css = "#current-password")
    private WebElement fieldForPassword;

    @FindBy(css = "sl-button.w-full:nth-child(4)")
    private WebElement submitLogInButton;

    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email) {
        waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(password);
        return this;
    }

    public MainPage signIn() {
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new MainPage(driver);
    }
}
