package PageDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayGradesPage {
    WebDriver driver;

    public PayGradesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=\"btnAdd\"]")
    WebElement buttonAddPayGrade;

    @FindBy(xpath = "//input[@id=\"payGrade_name\"]")
    WebElement inputPayGradeName;

    @FindBy(xpath = "//input[@id=\"btnSave\"]")
    WebElement buttonSavePayGradeName;

    @FindBy(xpath = "//input[@id=\"btnAddCurrency\"]")
    WebElement buttonAddCurrency;

    @FindBy(xpath = "//input[@id=\"payGradeCurrency_currencyName\"]")
    WebElement inputCurrencyName;

    @FindBy(xpath = "//input[@id=\"payGradeCurrency_minSalary\"]")
    WebElement inputMinSalary;

    @FindBy(xpath = "//input[@id=\"payGradeCurrency_maxSalary\"]")
    WebElement inputMaxSalary;

    @FindBy(xpath = "//input[@id=\"btnSaveCurrency\"]")
    WebElement buttonSaveCurrency;

    @FindBy(xpath = "//input[@id=\"btnDelete\"]")
    WebElement buttonDeleteRecord;

    @FindBy(xpath = "//input[@id=\"dialogDeleteBtn\"]")
    WebElement buttonOk;

    public void clickOnAddRecordButton(){
        this.buttonAddPayGrade.click();
    }
    public void enterPayGradeName(String payGradeName){
        this.inputPayGradeName.sendKeys(payGradeName);
    }
    public void clickOnSavePayGradeNameButton(){
        this.buttonSavePayGradeName.click();
    }
    public void clickOnAddCurrencyButton() { this.buttonAddCurrency.click(); }
    public void enterCurrencyName(String currencyName) { this.inputCurrencyName.sendKeys(currencyName); }
    public void enterMinimumSalary(String minimumSalary) { this.inputMinSalary.sendKeys(minimumSalary); }
    public void enterMaximumSalary(String maximumSalary) { this.inputMaxSalary.sendKeys(maximumSalary); }
    public void clickOnSaveCurrencyButton() { this.buttonSaveCurrency.click(); }
    public boolean checkIfExists(String payGradeName) { return !driver.findElements(By.xpath("//tr//td//a[text()='" + payGradeName + "']")).isEmpty(); }
    public void clickOnCheckbox(String payGradeName) { driver.findElement(By.xpath("//tr//td//a[text()='" + payGradeName + "']//..//..//td//input")).click(); }
    public void clickOnDeleteRecord() { this.buttonDeleteRecord.click(); }
    public void clickOnOkInDialogBox() { this.buttonOk.click(); }
}
