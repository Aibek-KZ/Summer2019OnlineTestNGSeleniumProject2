package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateACampaignPage extends BasePage {

    @FindBy(css = "[id^='oro_campaign_form_name']")
    public WebElement nameElement;

    @FindBy(css = "[id^='oro_campaign_form_code']")
    public WebElement codeElement;

    @FindBy(css = "[id^='oro_campaign_form_budget']")
    public WebElement budgetElement;

    @FindBy(xpath = "//button[normalize-space()='Save and Close']")
    public WebElement saveAndCloseButtonElement;


}
