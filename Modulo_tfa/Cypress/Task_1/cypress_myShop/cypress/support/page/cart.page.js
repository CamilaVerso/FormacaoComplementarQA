import { cartSelector } from "../../utils/selectors/cartSelectors";
const { selectors, messages } = cartSelector;

Cypress.Commands.add("verifyCartEmptyLoggedOut", () =>{
    cy.get(selectors.btnCart).click();
    cy.get(selectors.textCarEmpty).should("have.text", messages.cartEmpty);
})

Cypress.Commands.add("addItemCartSuccessfully", () => {
    cy.get(selectors.categoryDresses).click();
    cy.get(selectors.selectedDress).click();
    cy.get(selectors.selectDressSize).select("L");
    cy.get(selectors.selectDressSize).select("M");
    cy.get(selectors.btnAddCart).should('be.visible').click();
    cy.get(selectors.textConfirmCart).should("have.text", messages.itemAdded);
   
})

Cypress.Commands.add("CheckoutProcess", () => {
    cy.get(selectors.btnProceedToCheckout).click();
    cy.get('.cart_navigation > .button > span').click();
    cy.get(selectors.textAddresses).should("have.text", messages.confirmAddressPage);
    cy.get(selectors.btnProceedCheckoutInAddress).click();
    cy.get(selectors.textShipping).should("have.text", messages.confirmShippingPage);
    cy.get(selectors.checkBoxAcceptTerms).click();
    cy.get(selectors.btnProceedToCheckoutInShipping).click();
    cy.get(selectors.textPayment).should("have.text", messages.confirmPaymentPage);
    cy.get(selectors.btnPayment).click();
    cy.get(selectors.textBankWirePayment).should("have.text", messages.confirmOrderPage);
    cy.get(selectors.btnConfirmOrder).click();
    cy.get(selectors.textConfirmPurchase).should("have.text", messages.confirmPurchase);
})