package StepDefinition;

import PageDefinition.LoginPage;
import PageDefinition.PayGradesPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import java.time.Duration;

public class NewPayGradeSteps {
    WebDriver driver;
    LoginPage loginPage;
    PayGradesPage payGradesPage;

    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver");
        driver = new ChromeDriver();
        //Затримка для повного завантаження сторінки
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    @When("enters the username and password")
    public void userEntersUsernameAndPassword() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @And("clicks Login button")
    public void userClicksLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("user is navigated to the homepage")
    public void userInNavigatedToHomepage() {
        //На головній сторінці міститься розділ Dashboard. Якщо він присутній, вхід можна сприйняти вдалим
        //"Dashboard" exists -> Ok
        Assert.assertFalse(driver.findElements(By.xpath("//div//h1[text()=\"Dashboard\"]")).isEmpty());
    }

    @Given("user is on Pay Grades page")
    public void userIsOnPayGradesPage() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewPayGrades");
        payGradesPage = new PayGradesPage(driver);
    }

    @When("clicks Add button")
    public void userClicksAddRecordButton() {
        payGradesPage.clickOnAddRecordButton();
    }

    @And("enters <payGradeName>")
    public void userEntersPayGradeName() {
        payGradesPage.enterPayGradeName("RandomName");
    }

    @And("clicks Save button to save Pay Grade name")
    public void userClicksSavePayGradeNameButton() {
        payGradesPage.clickOnSavePayGradeNameButton();
    }

    @And("clicks Add button in Assigned Currencies")
    public void userClicksAddCurrencyButton() {
        payGradesPage.clickOnAddCurrencyButton();
    }

    @And("enters  <currencyName>, <minimumSalary>, <maximumSalary>")
    public void userEntersCurrencyFields() {
        payGradesPage.enterCurrencyName("UAH - Ukraine Hryvnia");
        payGradesPage.enterMinimumSalary("1200");
        payGradesPage.enterMaximumSalary("14000");
    }

    @And("clicks Save button to save currency")
    public void userClicksSaveCurrencyButton() {
        payGradesPage.clickOnSaveCurrencyButton();
    }

    @And("user goes to Pay Grades page")
    public void userGoesToPayGradesPage() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewPayGrades");
    }

    @Then("user is observing his entered record with Pay Grade equal to <payGradeName>")
    public void isRecordExists() {
        //Element exists -> Ok
        Assert.assertTrue(payGradesPage.checkIfExists("RandomName"));
    }

    @When("user clicks in checkbox on the left of <payGradeName>")
    public void userClicksRecordCheckbox() {
        payGradesPage.clickOnCheckbox("RandomName");
    }

    @And("clicks Delete button")
    public void userClicksDeleteRecordButton() {
        payGradesPage.clickOnDeleteRecord();
    }

    @And("click Ok button in dialog box")
    public void userClicksOkInDialogBox() {
        payGradesPage.clickOnOkInDialogBox();
    }

    @Then("user is observing Pay Grade table without his record")
    public void isRecordDoesntExists() {
        //Element doesn't exists -> Ok
        Assert.assertFalse(payGradesPage.checkIfExists("RandomName"));
    }
}
