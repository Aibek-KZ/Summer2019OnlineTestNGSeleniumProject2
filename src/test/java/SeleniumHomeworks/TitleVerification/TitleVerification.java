package SeleniumHomeworks.TitleVerification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");
        driver.get(urls.get(0));
        BrowserUtils.wait(3);
        String title1=driver.getTitle();
        boolean starts1 = driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com");

        driver.navigate().to(urls.get(1));
        BrowserUtils.wait(3);
        String title2=driver.getTitle();
        boolean starts2 = driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com");

        driver.navigate().to(urls.get(2));
        BrowserUtils.wait(3);
        String title3=driver.getTitle();
        boolean starts3=driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com");

        if (title1.equals(title2) && title2.equals(title3)) {
            System.out.println("Test passed, All have the same title");
        } else {
            System.out.println("Test failes, The titles are different");
        }

        if (starts1==starts2 && starts2==starts3) {
            System.out.println("Url test passed");
        } else {
            System.out.println("Url Test failed");
        }
        driver.close();
    }
}
