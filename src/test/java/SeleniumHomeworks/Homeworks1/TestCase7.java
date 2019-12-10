package SeleniumHomeworks.Homeworks1;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed:
“email address is not a valid Email format is not correct”
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase7 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//a [@href='/registration_form']")).click();
        driver.findElement(By.xpath("//input [@name=\"email\"]")).sendKeys("testers@email");
        BrowserUtils.wait(2);
        String expectedMessage1="email address is not a valid";
        String expectedMessage2="Email format is not correct";
        if (driver.findElement(By.xpath("//small[starts-with(text(), 'email address is n')]")).getText().equals(expectedMessage1)) {
            if (driver.findElement(By.xpath("//small[starts-with(text(), 'Email format')]")).getText().equals(expectedMessage2)) {
                System.out.println("Test passed");
                System.out.println("Message is: "+driver.findElement(By.xpath("//small[starts-with(text(), 'email address is n')]")).getText());
                System.out.println("Message is: "+driver.findElement(By.xpath("//small[starts-with(text(), 'Email format')]")).getText());
            } else {
                System.out.println("Test failed");
            }
            driver.quit();
        }

    }
}
