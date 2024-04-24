package com.vemser.automationpractice.factory.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends SeleniumService {
    public static WebElement element(By by) {
        return driver.findElement(by);
    }

    public static void waitElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void performInteraction(By by, String interactionType) {
        WebElement element = element(by);
        
        switch (interactionType) {
            case "hover":
                Actions actions = new Actions(driver);
                actions.moveToElement(element).perform();
                break;
            default:
                System.out.println("Invalid interaction type");
                break;
        }
    }
}
