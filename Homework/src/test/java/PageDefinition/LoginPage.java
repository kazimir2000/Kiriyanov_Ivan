package PageDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    WebElement inputUsername;

    @FindBy(xpath = "//input[@id=\"txtPassword\"]")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id=\"btnLogin\"]")
    WebElement buttonLogin;

    public void enterUsername(String username){
        this.inputUsername.sendKeys(username);
    }
    public void enterPassword(String password){
        this.inputPassword.sendKeys(password);
    }
    public void clickOnLogin(){
        this.buttonLogin.click();
    }
}
