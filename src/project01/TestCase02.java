package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.ValidationUtilities;

import java.util.List;

public class TestCase02 {
    public static void main(String[] args) {
        /*
        Test Case 2: Validate ComfyElite Contact Us page "Connect With Us"
section
Given user navigates to “https://comfyelite.com/”
When user clicks on “CONTACT US” link in the header
Then user should be navigated to “CONTACT US” page
And user should be able to see heading1 as "Connect With Us"
And user should be able to see “Facebook” icon and hyperlink reference for it should be
“https://www.facebook.com/103179127717601”
And user should be able to see “Instagram” icon and hyperlink reference for it should be
“https://www.instagram.com/comfyelite”

         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");
        driver.findElement(By.xpath("(//a[@data-ux='NavLink'])[2]")).click();
        ValidationUtilities.validateURL(driver, "https://comfyelite.com/contact-us"); // we are on the contact-us page
        if (driver.findElement(By.xpath("//div[@id='f5a174cf-e723-46a4-ae9e-b0e81ae77913']//span")).getText().equals("Connect With Us"))
            System.out.println("Sub Heading is validated");
        else System.out.println("Sub Heading is failed");


        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@data-aid,'SOCIAL_')]"));
        String[] expectedLinks = {"https://www.facebook.com/103179127717601", "https://www.instagram.com/comfyelite"};

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).isDisplayed() ? "Social media logos are DISPLAYED" : "Its failed");
            System.out.println(elements.get(i).getAttribute("href").equals(expectedLinks[i]) ? "Social media links are are as expected" : "Its failed");
        }

        driver.quit();


    }
}
