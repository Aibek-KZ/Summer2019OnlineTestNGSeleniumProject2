package SeleniumHomeworks.Homeworks1;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class MyHomework1 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        BrowserUtils.wait(3);
        String titleGoogle=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        BrowserUtils.wait(3);
        String titleEtsy=driver.getTitle();
        driver.navigate().back();
        BrowserUtils.wait(3);
        if (titleGoogle.equals(driver.getTitle())){
            System.out.println("Google page test passed");
        } else {
            System.out.println("Google page test failed");
        }
        driver.navigate().forward();
        BrowserUtils.wait(3);
        if (driver.getTitle().equals(titleEtsy)) {
            System.out.println("Eatsy page test passed");
        } else {
            System.out.println("Eatsy page test failed");
        }
        driver.close();


    }
}
