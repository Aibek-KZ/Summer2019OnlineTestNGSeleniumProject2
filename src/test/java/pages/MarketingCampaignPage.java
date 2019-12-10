package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class MarketingCampaignPage extends BasePage {

    @FindBy(css = "[title='Create Campaign']")
    public WebElement CreateCampaign;

    public void clickToCreateCampaign(){
        BrowserUtils.waitForVisibility(CreateCampaign,15);
        BrowserUtils.waitForClickablility(CreateCampaign,15);
        CreateCampaign.click();
    }

}
