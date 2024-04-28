/// <reference types="cypress" />

describe("Cart", () => {
  beforeEach(() => {
    cy.visit("/");

  });

  it("cart empty", () => {
    cy.verifyCartEmptyLoggedOut();

  });

  it("add item to cart", () => {
    cy.addItemCartSuccessfully();

  });

  it.only("completeCheckoutProcess", () => {
    cy.makeLoginValid();
    cy.addItemCartSuccessfully();
    cy.CheckoutProcess();

  });

});
