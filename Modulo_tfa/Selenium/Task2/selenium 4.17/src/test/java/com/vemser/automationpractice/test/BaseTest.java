package com.vemser.automationpractice.test;

import com.vemser.automationpractice.factory.service.SeleniumService;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;

public class BaseTest extends SeleniumService{
    SeleniumService seleniumService = new SeleniumService();

    @Before
    public void abrirNavegador() {
        initBrowser();
    }

//    @After
//    public void fecharNavegador() {
//        tearDown();
//    }

    public void closeAdsByGoogle(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

}