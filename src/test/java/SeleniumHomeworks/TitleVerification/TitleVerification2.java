package SeleniumHomeworks.TitleVerification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        List<String> urls = Arrays.asList("https://luluandgeorgia.com", "https://wayfair.com", "https://walmart.com", "https://westelm.com");

        for (int i=0; i<urls.size(); i++) {
            driver.get(urls.get(i));
            BrowserUtils.wait(3);
            String currentUrl = driver.getCurrentUrl().replace(" ", "").trim().toLowerCase();
            String title = driver.getTitle().replace(" ", "").trim().toLowerCase();
            if (currentUrl.contains(title)) {
                System.out.println(urls.get(i)+" Test passed");
            } else {
                System.out.println(urls.get(i)+" Test failed");
            }

        }
         driver.close();
    }
}
