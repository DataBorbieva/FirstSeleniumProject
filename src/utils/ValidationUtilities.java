package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidationUtilities {
    public static void validateTitle(WebDriver driver, String expectedTitle) {
        if (driver.getTitle().equals(expectedTitle)) System.out.println("Title is VALID!");
        else throw new RuntimeException("Title is NOT VALID!!!" +
                "\nExpected title: " + expectedTitle + " | " + "Actual title: " + driver.getTitle());
    }

    public static void validateURL(WebDriver driver, String expectedURL) {
        if (driver.getCurrentUrl().equals(expectedURL)) System.out.println("URL is VALID!");
        else throw new RuntimeException("URL is NOT VALID!!!" +
                "\nExpected URL: " + expectedURL + " | " + "Actual URL: " + driver.getCurrentUrl());

    }
    public static void validateIsDisplayedByClassName(WebDriver driver, String className){
        if(driver.findElement(By.className(className)).isDisplayed()) System.out.println("PASSED ");
        else throw  new RuntimeException("FAILED web element is not displayed");
    }
    public static void validateIsDisplayedById(WebDriver driver, String id){
        if(driver.findElement(By.id(id)).isDisplayed()) System.out.println("PASSED ");
        else throw new RuntimeException("Failed web element is not displayed");
    }
    public static void validateIsDisplayedByName(WebDriver driver, String name){
        if(driver.findElement(By.name(name)).isDisplayed()) System.out.println("PASSED ");
        else throw new RuntimeException("Failed web element is not displayed");
    }

}

