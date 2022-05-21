package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.ValidationUtilities;

public class TestCase06 {
    public static void main(String[] args) {
/*
Test Case 6: Validate ComfyElite Contact Us page "SEND" buttonGiven user navigates to “https://comfyelite.com/”
When user clicks on “CONTACT US” link in the header
Then user should be navigated to “CONTACT US” page
And validate "SEND" button is displayed and clickable
And validate button text is displayed as “SEND”
 */
        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");
        driver.findElement(By.xpath("(//a[@data-ux='NavLink'])[2]")).click();
        ValidationUtilities.validateURL(driver, "https://comfyelite.com/contact-us");

        WebElement sendButton = driver.findElement(By.xpath("//button[@data-aid='CONTACT_SUBMIT_BUTTON_REND']"));
        System.out.println(sendButton.isDisplayed() || sendButton.isSelected() ? "Passed" : "Failed");
        driver.quit();









    }
}
