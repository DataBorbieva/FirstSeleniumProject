package project01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.ValidationUtilities;

import java.util.ArrayList;
import java.util.List;

public class TestCase04 {
    public static void main(String[] args) {
/*
Test Case 4: Validate ComfyElite Contact Us page "SEND US A
MESSAGE" form
Given user navigates to “https://comfyelite.com/”
When user clicks on “CONTACT US” link in the header
Then user should be navigated to “CONTACT US” page
And validate "First Name" input box
And validate "Last Name" input box
And validate "Email" input box
And validate "Message" input box
NOTE: Input validation includes input being displayed and user being able to send
keys to input box. It also requires validating the given labels and placeholders
 */

        WebDriver driver = Driver.getDriver();
        driver.get("https://comfyelite.com/");
        driver.findElement(By.xpath("(//a[@data-ux='NavLink'])[2]")).click();
        ValidationUtilities.validateURL(driver, "https://comfyelite.com/contact-us");

        WebElement firstName = driver.findElement(By.xpath("//input[@data-aid='First Name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@data-aid='Last Name']"));
        WebElement emailBox = driver.findElement(By.xpath("//input[@data-aid='CONTACT_FORM_EMAIL']"));
        WebElement messageBox = driver.findElement(By.xpath("//textarea[@data-aid='CONTACT_FORM_MESSAGE']"));
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(firstName);
        elementList.add(lastName);
        elementList.add(emailBox);



        //check if those input boxes are displayed and we can send keys to input boxes

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
       emailBox.sendKeys("abc@gmail.com");
       messageBox.sendKeys("message");
        for (WebElement element : elementList) {
            if(element.isDisplayed() && element.isEnabled()) System.out.println("Input box validation PASSED");
            else System.out.println("Input box validation Failed");

        }
        // we need to validate the given placeholders
    //    driver.navigate().back();
//        firstName.sendKeys("John");
//        lastName.sendKeys("Doe");                        STALE ELEMENT EXCEPTION :(
//        emailBox.sendKeys("abc@gmail.com");
//        messageBox.sendKeys("message");
//        System.out.println(firstName.getText().equals("John") ? "First name placeholder PASSED" : "First name placeholder FAILED");
//        System.out.println(lastName.getText().equals("Doe") ? "Last name placeholder PASSED" : "Last name placeholder FAILED");
//                System.out.println(emailBox.getText().equals("abc@gmail.com") ? "Email input box placeholder PASSED" :
//                                "Email input box placeholder FAILED");
//        System.out.println(messageBox.getText().equals("message") ? "Message box placeholder PASSED" : "Message Box placeholder FAILED");


        System.out.println(firstName.getAttribute("value").equals("John") ?  "First name placeholder PASSED" : "First name placeholder FAILED");
        System.out.println(lastName.getAttribute("value").equals("Doe") ? "Last name placeholder PASSED" : "Last name placeholder FAILED");
        System.out.println(emailBox.getAttribute("value").equals("abc@gmail.com") ? "Email input box placeholder PASSED" : "Email input box placeholder FAILED");
        System.out.println(messageBox.getText().equals("message") ? "Message box placeholder PASSED" : "Message Box placeholder FAILED");
        driver.quit();



    }
}
