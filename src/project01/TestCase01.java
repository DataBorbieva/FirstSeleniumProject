package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.ValidationUtilities;

public class TestCase01 {
    public static void main(String[] args) {
        /*

        Test Case 1: Validate ComfyElite Contact Us Page heading section
        Given user navigates to “https://comfyelite.com/”
When user clicks on “CONTACT US” link in the header
Then user should be navigated to “CONTACT US” page
And user should be able to see ComfyElite logo
And user should be able to see heading2 as “High quality comfy pillows and accessories for
travel, office and home.”
         */

        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");
        //(//a[@data-ux='NavLink'])[2]
        driver.findElement(By.xpath("(//a[@data-ux='NavLink'])[2]")).click();
        ValidationUtilities.validateURL(driver, "https://comfyelite.com/contact-us");
        ValidationUtilities.validateIsDisplayedById(driver, "n-48560"); //validated ComfyElite logo

        if(driver.findElement(By.id("dynamic-tagline-48605")).getText().equals("High quality comfy pillows and accessories for travel, office and home."))
        System.out.println("Header tag is validated");
        else System.out.println("Header tag is failed");

        driver.quit();

    }
}