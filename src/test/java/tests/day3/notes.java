package tests.day3;

public class notes {
    /*
    Agenda: Basic Navigation
############################
Finally, something happens when I click run. This is how people describe selenium on the first class.
Our very first and very important method:
.get("URL") -- to open a website
at the end, we have to close browser.
for this --> .close() method
Also, we have a .quit() method.

######Interview question
#### What's the difference between quit and close methods?
close() -- will close only current tab,
quit() -- will close entire browser, regardless on number of tabs. Because,  we can have opened multiple tabs/windows in the same browser. Also, .quit() will make driver/sessionid null.
//class name in the intellij
DifferenceBetweenQuitAndClose
We will use this page:
http://practice.cybertekschool.com/open_new_tab
After 3 seconds, new tab will be opened.
Question: Do we need to write code to allow for pop up in the future?
-- No, by default, when we are running tests, this feature is disabled.

If you have issues with your project, clone my project:
https://github.com/CybertekSchool/Summer2019OnlineTestNGSeleniumProject.git
Click File --> New --> Project From Version Control --> Git
Then, insert URL with .git extension.
We can have as many as you want projects.
 public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);//will pause program execution for 4 seconds
    }
sleep method throws checked exception, that you need to take care of, before running a program.
Otherwise, you will get compilation error.
At this point, just add   throws InterruptedException  in the method signature.
When you see mills, it's not a value that you pass, it's a name of the parameter.  It's a placeholder.
Red dot it's for debug mode.
Let's create a new package with name utils
utilities/utils - it's a package where people store reusable methods/functions.
And then inside, create a class: BrowserFactory


BrowserUtils -- class that has reusable methods for writing scripts.
You cannot call driver after quit(), otherwise you will get an Exception:
Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

#########################
getTilte() - to get page title
getCurrentUrl() - to get URL of the current website
close() - to close current tab. it's it's a last tab - it will also shutdown a browser and session.
quit() - to close all tabs that were opened by webdriver.
navigate().to(URL) - to jump to other website. It will not open a new tab/browser.
navigate().back() - comeback to previous website
navigate().forward() - to move forward in the browser history. Usually, used after navigate().back().
navigate().refresh() - to refresh a website.
manage().window().maximize() - to maximize window
manage().window().fullscreen() - to run browser in the fullscreeen mode




     */
}
