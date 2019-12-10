package tests.vytrack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateACampaignPage;
import pages.LoginPage;
import pages.MarketingCampaignPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;

public class MarketingCampaignTests extends TestBase {

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();
        MarketingCampaignPage marketingCampaignPage = new MarketingCampaignPage();
        CreateACampaignPage createACampaignPage = new CreateACampaignPage();

        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();
        loginPage.navigateTo("Marketing","Campaigns");
        loginPage.waitUntilLoaderMaskDisappear();

        marketingCampaignPage.clickToCreateCampaign();
        loginPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(2);

        createACampaignPage.nameElement.sendKeys("Aibek");
        createACampaignPage.codeElement.sendKeys("35785");
        createACampaignPage.budgetElement.sendKeys("1000000");
        BrowserUtils.wait(2);
        createACampaignPage.saveAndCloseButtonElement.click();
        loginPage.waitUntilLoaderMaskDisappear();
        String actualMessage= Driver.get().findElement(By.xpath("//div[text()='Campaign saved']")).getText();
        Assert.assertEquals(actualMessage,"Campaign saved");
    }


}
