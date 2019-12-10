package SeleniumHomeworks.VyTruck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;

/*
Go to the login page
Enter valid credential(can be any role)
Click login button
Verify that the user login successfully
 */
public class vyTruck {
    public static void main(String[] args) {
        String[] user = {"user165", "user166", "user167", "storemanager98", "storemanager99", "storemanager199",
                "salesmanager261", "salesmanager262"};
        ArrayList<String> users = new ArrayList<String>(Arrays.asList(user));
        String password = "UserUser123";

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        BrowserUtils.wait(2);
        for (int i=0; i<users.size(); i++) {
            WebElement inputUser = driver.findElement(By.name("_username"));
            inputUser.sendKeys(users.get(i));
            WebElement inputPassword = driver.findElement(By.name("_password"));
            inputPassword.sendKeys(password);
            BrowserUtils.wait(2);
            WebElement button = driver.findElement(By.id("_submit"));
            button.click();
            BrowserUtils.wait(2);
            String expectedPage = "Dashboard";
            if (driver.getTitle().equalsIgnoreCase(expectedPage)) {
                System.out.println(users.get(i)+" Test passed");
                System.out.println(users.get(i)+"User login  successfully!");
            } else {
                System.out.println(users.get(i)+" Test failed");
            }

            if (i<3) {
                driver.findElement(By.id("user-menu")).click();
                driver.findElement(By.xpath("//a [@href=\"/user/logout\" and text()=\"Logout\"]")).click();
                BrowserUtils.wait(3);
            } else {
                driver.findElement(By.xpath("//a [@href=\"javascript: void(0);\"]")).click();
                driver.findElement(By.xpath("//a [@href=\"/user/logout\" and text()=\"Logout\"]")).click();
                BrowserUtils.wait(3);
            }
            String logoutPage = "https://qa2.vytrack.com/user/login";
            if (driver.getCurrentUrl().equals(logoutPage)) {
                System.out.println(users.get(i)+"Logout successfully!");
            } else {
                System.out.println(users.get(i)+"Logout failed");
            }
            BrowserUtils.wait(2);
        }

        driver.close();




    }
}
