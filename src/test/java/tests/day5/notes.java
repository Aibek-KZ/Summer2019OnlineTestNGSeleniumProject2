package tests.day5;

public class notes {
    /*
Today 10/28/2019
    Agenda: locators, web elements, findElement(), findElements()
How to we start automating?
First, we need to open the page in the browser (chrome)
Then, right click and inspect the page
Click on the selector to select specific element or text on the page.
We can click with a inspector on the specific element.
Them, we can see what HTML code is behind this element.
Based on the properties/attributes, tags and text we can choose locator strategy.
If it's possible, use id.
in code, it will look like: <input type="text" id="first_name">
WebElement first_name = driver.findElement(By.id("first_name"));
id must be unique! it's like SSN.
Usually, we try to ask developers to add id's if it's possible.
The only case when we cannot use id, is when id is dynamic. It's basically when id is different for every refresh or once in while.

 How to understand if it's a dynamic id?
 You fond id, then you've used it for finding element. First run, script passed. Second time - NoSuchElemntException.
If you see that element is not there, based on this id, that means it changed id value.
NoSuchElemntException - means that based on your locator, selenium couldn't find any elements. There are 2 cases: element is there but we need to wait for element. Another case - element is not there indeed.
please comeback at 4:15
<a href="/autocomplete">Autocomplete</a>
a - tag name
href - attribute
/autocomplete - value of href attribute
Autocomplete - text
<a href="/autocomplete"> - opening tag
</a> - closing tag
In general, <a> stands for hyperlink. It's a Clickable text. Once you click on this text, it will bring you to the different page.
We can find element, if it's a link, based on link text.
   //remember!
        //for Mac users: you don't need to use WebDriverManager for Safari
        //safari has embedded webdriver support.
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //if you want to do in one line, without creating webelemnt reference variable
        //enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        //enter email
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        //click sign up
        driver.findElement(By.name("wooden_spoon")).click();
        //pause for 3 seconds
        BrowserUtils.wait(3);
        driver.quit();
//      <a href="/autocomplete">Autocomplete</a>
//        Autocomplete - it's the text that you see in the link
//        place where it will navigate you specified in href
//        it works only if tag name is <a>
//        if you want to use linkText or partialLinkText locator strategy
//        element must start with <a>
//        this is how we specify linkd in HTML
        driver.findElement(By.linkText("Autocomplete")).click();
     */
}
