export const cartSelector = {
    selectors:{
        homePageInfo: "#home-page-tabs > li.active > a",
        homePageSignUpBtn: "#header > div.nav > div > div > nav > div.header_user_info > a",     
        btnCart: "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a",
        textYourShoppingCart: "#columns > div.breadcrumb.clearfix",
        textCarEmpty: "#center_column > p",
        categoryDresses: "#block_top_menu > ul > li:nth-child(2) > a",
        selectedDress: "#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img",
        selectDressSize: "#group_1",
        btnAddCart: ".exclusive > span",//"#add_to_cart > button"
        btnProceedToCheckout: "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a",
        textConfirmCart: ".layer_cart_product > h2",
        btnProceedToCheckoutInShopCart: "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium",
        textAddresses: "#columns > div.breadcrumb.clearfix",
        btnProceedCheckoutInAddress: "#center_column > form > p > button > span",
        textShipping: "#columns > div.breadcrumb.clearfix",
        checkBoxAcceptTerms: "#cgv",
        btnProceedToCheckoutInShipping: "#form > p > button > span",
        btnPayment: "#HOOK_PAYMENT > div:nth-child(1) > div > p > a",
        textBankWirePayment: "#center_column > h1",
        textPayment: "#center_column > h1",
        btnConfirmOrder: "#cart_navigation > button",
        textConfirmPurchase: ".alert",
  
    },

    messages: {
        cartEmpty:  "Your shopping cart is empty.",
        itemAdded: "\n\t\t\t\t\tProduct successfully added to your shopping cart\n\t\t\t\t",
        confirmAddressPage: "\n\t\n\t\t\t>\n\t\t\t\t\tAddresses\n\t\t\t",
        confirmShippingPage: "\n\t\n\t\t\t>\n\t\t\t\t\tShipping:\n\t\t\t",
        confirmPaymentPage: "Please choose your payment method\n\t\t\t\t\tYour shopping cart contains:\n\t\t\t\t1 product\n\t\t\t\n\t\t\t",
        confirmOrderPage: "\n    Order summary\n",
        confirmPurchase: "Your order on My Shop is complete.",
    }

}