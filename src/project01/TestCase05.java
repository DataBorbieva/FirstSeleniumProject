package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.ValidationUtilities;

public class TestCase05 {
    public static void main(String[] args) throws InterruptedException {
        /*
            Test Case 5: Validate ComfyElite Contact Us page
            "Sign up for our email list for updates, promotions, and more."
             CheckboxGiven user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And validate the "Sign up for our email list for updates, promotions, and more." checkbox
    Note: Checkbox validation includes checkbox being selected and deselected by
    user
         */
        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");
        driver.findElement(By.xpath("(//a[@data-ux='NavLink'])[2]")).click();
        ValidationUtilities.validateURL(driver, "https://comfyelite.com/contact-us");

        WebElement signUpBox = driver.findElement(By.xpath("//label[@data-aid='CONTACT_FORM_EMAIL_OPT_IN']"));
        signUpBox.click();
        Thread.sleep(3000);
        System.out.println("Checked box validation "+(signUpBox.isSelected()?"PASSED":"FAILED")); //Checked box validation FAILED
        driver.quit();
    }
}
