package SeleniumHomeworks.VyTruck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class vyTruck2 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user168");
        driver.findElement(By.id("prependedInput2")).sendKeys("password");
        driver.findElement(By.id("_submit")).click();
        BrowserUtils.wait(2);

        String expectedMessage="Invalid user name or password.";
        String actualMessage=driver.findElement(By.xpath("//div [@class='alert alert-error']")).getText();
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test passed");
            System.out.println(actualMessage);
        } else {
            System.out.println("Test failed");
            System.out.println(actualMessage);
        }
        driver.close();

    }
}
