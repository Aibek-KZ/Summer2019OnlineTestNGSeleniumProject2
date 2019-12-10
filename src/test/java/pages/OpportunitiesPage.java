package pages;

import org.openqa.selenium.By;
import utils.Driver;

public class OpportunitiesPage extends BasePage {

     public void clickToCreateOportunity(){
        Driver.get().findElement(By.cssSelector("[title='Create Opportunity']")).click();
    }
}
