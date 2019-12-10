package tests.vytrack;

import org.testng.annotations.Test;
import pages.CreateOpportunitiesPage;
import pages.LoginPage;
import pages.OpportunitiesPage;
import tests.TestBase;
import utils.BrowserUtils;

public class CreateOpportunityTest extends TestBase {

    @Test
    public void test(){
        LoginPage loginPage = new LoginPage();
        OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
        CreateOpportunitiesPage createOpportunitiesPage = new CreateOpportunitiesPage();

        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(2);
        loginPage.navigateTo("Sales","Opportunities");
        loginPage.waitUntilLoaderMaskDisappear();
        opportunitiesPage.clickToCreateOportunity();
        loginPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(3);
        createOpportunitiesPage.NameElement.sendKeys("Aibek");
        createOpportunitiesPage.AccountElement.sendKeys("123456789");
        createOpportunitiesPage.ContactElement.sendKeys("Demo Omed");
        BrowserUtils.wait(3);
        createOpportunitiesPage.BudgetAmountElement.sendKeys("500000");
        createOpportunitiesPage.StatusElement.click();
        createOpportunitiesPage.StatusElementOption.click();
        createOpportunitiesPage.SaveOptionButtonElement.click();
        createOpportunitiesPage.SaveAndCloseClickElement.click();
        BrowserUtils.wait(2);

        BrowserUtils.wait(4);

    }

}
