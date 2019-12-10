package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.TestBase;

public class CreateOpportunitiesPage extends TestBase {

    @FindBy(css = "[id^='oro_sales_opportunity_form_name']")
    public WebElement NameElement;

    @FindBy(xpath = "//span[starts-with(text(),'Choose an account')]")
    public WebElement AccountElement;

    @FindBy(xpath = "//span[text()='Choose a contact...']")
    public WebElement ContactElement;

    @FindBy(xpath = "//span[text()='Open']")
    public WebElement StatusElement;
    @FindBy(xpath = "//span[text()='Needs Analysis']")
    public WebElement StatusElementOption;

    @FindBy(css = "[id^='oro_sales_opportunity_form_budgetAmount_value']")
    public WebElement BudgetAmountElement;

    @FindBy(css = "//span[@class='caret']")
    public WebElement SaveOptionButtonElement;
    @FindBy(xpath = "//button[contains(text(),'Save and Close')]")
    public WebElement SaveAndCloseClickElement;





}
