/// <reference types="cypress" />

describe("Register Address", () => {
  beforeEach(() => {
    cy.visit("/");
  });

  it("register new address", () => {
    cy.createAccountAndStayLoggedIn();
    cy.insertAddressWithValidData();
  });

  it("register new address with invalid data", () => {
    cy.createAccountAndStayLoggedIn();
    cy.insertAddressWithInvalidData();
  })

});
