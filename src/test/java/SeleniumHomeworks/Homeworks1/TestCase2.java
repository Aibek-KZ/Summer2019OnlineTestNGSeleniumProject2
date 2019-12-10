package SeleniumHomeworks.Homeworks1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size() methods.
 */

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        int elements = driver.findElements(By.xpath("//li [@class='list-group-item']")).size();
        BrowserUtils.wait(5);
        if (elements==48) {
            System.out.println("Number of listed examples: "+elements);
            System.out.println("Test passed!");
        } else {
            System.out.println("Number of listed examples: "+elements);
            System.out.println("Test failed!");
        }

        driver.quit();


    }
}
