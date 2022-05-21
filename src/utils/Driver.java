package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //private constructor ,to create object only in this class
    private Driver(){

    }
    //private driver
    private static WebDriver driver;


    //if my driver fully fresh untouched
    //get driver and quit driver method
    public static WebDriver getDriver(){
        if(driver == null) {
            //Telling your system where your chrome driver is located
            System.setProperty("webdriver.chrome.driver", "chromedriver_win32\\chromedriver.exe");
            //create the object of the web browser that you are automating
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //waiting only that web element to be existed
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void quitDriver() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null; //this line is SUPER IMPORTANT
        }
    }

}
