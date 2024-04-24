
/// <reference types="cypress" />


describe("Fazer logout", () => {
    beforeEach(()=>{
        cy.visit("/")
    })
    
    it("Deslogar", () => {
        cy.fazerLoginValido();
        cy.deslogar();
        cy.title().should("eq", "Login - My Shop");
    })
})