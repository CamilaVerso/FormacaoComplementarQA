package com.vemser.automationpractice.page;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CartPage extends  BasePage{

    private static final By homePageInfo = By.cssSelector("#home-page-tabs > li.active > a");
    private static final By btnSignUp = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");

    private static final By btnCart = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");

    private static final By textYourShoppinCart = By.cssSelector("#columns > div.breadcrumb.clearfix");
    private static final By textCarEmpty = By.cssSelector("#center_column > p");

    private static final By optionWomen = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    private static final By categoryDresses = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    private static final By selectedDress = By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img");
    private static final By selectDressSize = By.cssSelector("#group_1 > option:nth-child(3)");

    private static final By addItemBlouse = By.cssSelector(" #center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img");

    private static final By btnMore = By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.right-block > div.button-container > a > span");
   // private static final By btnColorWhite = By.cssSelector("#color_to_pick_list > li.selected > White"); //#color_to_pick_list > li.selected
   private static final By btnColorWhite = By.cssSelector("#color_24"); ; //#color_24 By.xpath("//*[@id=\"color_8\"]")
    private static final By selectSize = By.cssSelector("#group_1 > option:nth-child(2)"); //Seletor do tamanho M #group_1 > option:nth-child(2)

    private static final By btnAddCart = By.cssSelector("#add_to_cart > button");
    private static final By modalConfirmAddCart = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2");
    private static final By btnProceedToCheckout = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private static final By textConfirmCart = By.cssSelector("#cart_title > span");

    private static final By btnProceedToCheckoutInShopCart = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
    private static final By textAddresses =By.cssSelector("#columns > div.breadcrumb.clearfix");
    private static final By btnProceedCheckoutInAddress = By.cssSelector(" #center_column > form > p > button > span");
    private static final By textShipping = By.cssSelector(" #columns > div.breadcrumb.clearfix");
    private static final By checkBoxAcceptTerms = By.cssSelector("#cgv");
    private static final By btnProceedToCheckoutInShipping = By.cssSelector("#form > p > button > span");
    private static final By textYourPaymentMethod = By.cssSelector("#columns > div.breadcrumb.clearfix");

    private static final By btnPayment =By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
    private static final By textBankWirePayment = By.cssSelector("#center_column > h1");
    private static final By textPayment = By.cssSelector("#center_column > h1");
    private static final By btnConfirmOrder = By.cssSelector("#cart_navigation > button");
    private static final By textOrderConfirmation = By.cssSelector("#columns > div.breadcrumb.clearfix");
    private static final By textOrderFinished = By.cssSelector("#center_column > p.alert.alert-success");
    private static final By emailField = By.cssSelector("#email");
    private static final By passwordField = By.cssSelector("#passwd");
    private static final By signInBtn = By.cssSelector("#SubmitLogin");
    private static final By loginInfotext = By.cssSelector("#center_column > p");
    public void fillEmailField(String email) {
        fillInput(emailField, email);
    }

    public void fillPasswordField(String senha) {
        fillInput(passwordField, senha);
    }

    public void clickCart(){
        readText(homePageInfo);
        click(btnCart);
        readText(textYourShoppinCart);
    }

    public String VerifyCartEmpty(){
        return readText(textCarEmpty);
    }

    public String confirmItemCart(){
        return readText(textConfirmCart);
    }

    public String confirmAddressPage(){
        return readText(textAddresses);
    }

    public void btnCart(){
        click(btnProceedToCheckoutInShopCart);
    }

    public void btnCartAddress(){
        click(btnProceedCheckoutInAddress);
    }

    public void checkboxTermsShipping(){
        confirmInputCheckbox(checkBoxAcceptTerms);
    }

    public void btnCartShipping(){
        click(btnProceedToCheckoutInShipping);
    }

    public void selectMethodPayment(){
        clickWithWait(btnPayment);
    }

    public void btnConfirmOrder(){
        click(btnConfirmOrder);
    }




    public void addItemCart() {
        click(categoryDresses);
        clickWithWait(selectedDress);
        clickWithWait(selectDressSize);


        clickWithWait(btnAddCart);
        clickWithWait(btnProceedToCheckout);



    }

    public String doLogin(String email, String senha) {
        click(btnSignUp);
        fillEmailField(email);
        fillPasswordField(senha);
        click(signInBtn);
        return readText(loginInfotext);
    }

    public void processCheckout(){
        addItemCart();
        btnCart();
        String confirmAddressPage = readText(textAddresses);
        System.out.println(confirmAddressPage);
        Assert.assertEquals(confirmAddressPage, "> Addresses");
        btnCartAddress();

        String confirmShippingPage = readText(textShipping);
        System.out.println(confirmShippingPage);
        Assert.assertEquals(confirmShippingPage, "> Shipping:");
        checkboxTermsShipping();
        btnCartShipping();

        String confirmYourPaymentMethodPage = readText(textPayment);
        System.out.println(confirmYourPaymentMethodPage);
        Assert.assertEquals(confirmYourPaymentMethodPage, "PLEASE CHOOSE YOUR PAYMENT METHOD\n" +
                "Your shopping cart contains: 1 product");
        selectMethodPayment();

        String confirmCheckoutPage = readText(textBankWirePayment);
        System.out.println(confirmCheckoutPage);
        Assert.assertEquals(confirmCheckoutPage, "ORDER SUMMARY");
        btnConfirmOrder();

    }



}
