/// <reference types="cypress" />

describe("Create account", () => {
    beforeEach(()=>{
        cy.visit("/")
    })

    it("create account with valid data and logout", () => {
        cy.createAccountSuccessfully();
    })

    it("Create account with invalid email", () => {
        cy.createAccountWithInvalidEmail();
    })    
   

})
