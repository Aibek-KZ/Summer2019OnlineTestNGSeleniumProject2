package tests.day14;

public class note {
    /*
    Today is 11/26/2019
    Agenda:
        Properties file
        Driver class
        Test Base class
###########################
We use configuration.properties file for project configuration.
In this file, we usually store URL's
 dev environment ->  qa environment | another environment -> preproduction environment -> production environment
dev.vytrack.com  , qa.vytrack.com , qa2.vytrack.com , preprod.vytrack.com, vytrack.com
Every environment has a different link. And to manage these links better, we store them in the config file.
Also we store credentials, data base configuration info, some wait time (for explicit wait)
If key name is wrong, you will get -> null.
############configuration.properties file example
#BROWSER TYPE | it's a comment
#key=value, it's like a Map in java
browser=chrome
#URL OF OUR WEB APPLICATION
url=https://qa1.vytrack.com/
#CREDENTIALS
user_name=storemanager85
password=UserUser123
############ ConfigurationReader class that loads configuration.properties and returns values based on key name
//ConfigurationReader.configFile.getProperty("browser") direct access
//ConfigurationReader.getProperty("browser")
public class ConfigurationReader {
    //this class will be responsible for loading properties file and will provide access
    //to values based on key names
    //we use Properties class to load custom .properties files
    private static Properties configFile;
    static {
        try {
            //provides access to file
            //try/catch block stands for handling exceptions
            //if exception occurs, code inside a catch block will be executed
            //any class that is related to InputOutput produce checked exceptions
            //without handling checked exception, you cannot run a code
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //initialize properties object
            configFile = new Properties();
            //load configuration.properties file
            configFile.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }
}
#######################
I believe it's not very cool to create new driver in every class. So what if we will have one central place, that will create driver. In this way, every test will use same driver. We will make process of drive switch match easier.
In OOP we have Design Patterns.
It's a proven solution for specific task.
One of the most popular design pattern for webdriver in selenium is Singleton.
Singleton - means single object of something for entire project.
What's the point? this object will be static and we can ensure that all tests use same driver object. So we can create test suits.
Also, whenever we need to use driver, we will just call it from Driver class. And it's gonna be same driver for everyone.
Otherwise, new webdriver object = new browser.
With this design, driver will be sharable and easy to access.
What are the conventions of singleton pattern?
    - private static instance
    - private constructor (to prevent class instantiation)
    - public getter that returns private static instance
class Driver(){
    //only one private static instance
    private static Webdriver driver;
    //to prevent class instantiation
    private Driver(){
    }
    public static WebDriver get(){
    //if object was not created yet - create it
        if(driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}

     */
}
