/// <reference types="cypress" />


describe("Make logout", () => {
    beforeEach(()=>{
        cy.visit("/")
    })
    
    it("Logout", () => {
        cy.makeLoginValid();
        cy.logout();
        cy.title().should("eq", "Login - My Shop");
    })
})