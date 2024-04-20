package com.vemser.automationpractice.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vemser.automationpractice.factory.service.Elements;

public class BasePage extends Elements {
    protected static void fillInput(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    protected static void clickWithWait(By by) {
        waitElementToBeClickable(by);
        element(by).click();
    }

    protected static void confirmInputCheckbox(By by) {
        waitElement(by);
        WebElement element = element(by);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected static String readText(By by) {
        waitElement(by);
        return element(by).getText();
    }

    protected static void tab(By by) {
        waitElement(by);
        element(by).sendKeys("\t");
    }

    protected static void selectOptionByValue(By by, String value) {
        waitElement(by);
        WebElement element = element(by);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected static void clearInput(By by) {
        waitElement(by);
        element(by).clear();
    }

    protected static void hover(By by) {
        waitElement(by);
        performInteraction(by, "hover");        
    }

    protected static void selectOptionSelect(By by, String option) {
        waitElement(by);
        WebElement element = element(by);
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    protected static void verifyElement(By by){
        waitElement(by);
        element(by).isDisplayed();
    }
}