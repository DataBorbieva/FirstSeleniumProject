package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.ValidationUtilities;

public class TestCase03 {
    public static void main(String[] args) {
        /*
        Test Case 3: Validate ComfyElite Contact Us page "Contact Us"
         "SEND
        US A MESSAGE" form headingsGiven user navigates to “https://comfyelite.com/”
        When user clicks on “CONTACT US” link in the header
        Then user should be navigated to “CONTACT US” page
        And user should be able to see heading2 as "Contact Us"
        And user should be able to see heading4 as "SEND US A MESSAGE"
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");
        driver.findElement(By.xpath("(//a[@data-ux='NavLink'])[2]")).click();
        ValidationUtilities.validateURL(driver, "https://comfyelite.com/contact-us");

        WebElement sendUsMessage = driver.findElement(By.xpath("//h4[@data-aid='CONTACT_FORM_TITLE_REND']"));
        WebElement contactUs = driver.findElement(By.xpath("//h2[@data-aid='CONTACT_SECTION_TITLE_REND']//span[1]"));

        System.out.println(contactUs.isDisplayed() ? "Heading2 is displayed" : "Heading2 is NOT displayed");
        System.out.println(sendUsMessage.isDisplayed() ? "Heading4 is displayed" : "Heading4 is NOT displayed");

        System.out.println(contactUs.getText().equals("Contact Us") ? "Heading2 text is validated" : "Heading2 is NOT validated");
        System.out.println(sendUsMessage.getText().equals("SEND US A MESSAGE") ? "Heading4 is validated" : "Heading4 is NOT validated");

        driver.quit();

    }}






