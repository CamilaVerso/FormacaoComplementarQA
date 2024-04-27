/// <reference types="cypress" />

describe("Login", () => {
    beforeEach(()=>{
        cy.visit("/")
    })

    it("Login with valid data", () => {
        cy.makeLoginValid();
    })     

})
