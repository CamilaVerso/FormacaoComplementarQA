package com.vemser.automationpractice.test;

import com.vemser.automationpractice.page.CartPage;
import org.junit.Assert;
import org.junit.Test;

public class CartTest extends BaseTest{

    CartPage cartPage = new CartPage();

    @Test
    public void VerifyCartEmptyLoggedOut(){
        cartPage.clickCart();

        String msg = cartPage.VerifyCartEmpty();
        System.out.println(msg);
        Assert.assertEquals(msg, "Your shopping cart is empty." );
    }


    @Test
    public void addItemCartSuccessfully(){
        cartPage.addItemCart();
        String msg = cartPage.confirmItemCart();
        System.out.println(msg);
        Assert.assertEquals(msg, "Your shopping cart contains: 1 product");
    }

    @Test
    public void testCheckoutSuccess(){
        cartPage.doLogin("camila@camila5.com", "12345678");
        cartPage.processCheckout();
    }

}
