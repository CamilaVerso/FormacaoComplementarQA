/// <reference types="cypress" />

describe("Login", () => {
    beforeEach(()=>{
        cy.visit("/")
    })

    it("Fazer login com dados válidos", () => {
        cy.fazerLoginValido();
    })
    
    it("Deslogar", () => {
        cy.fazerLoginValido();
        cy.deslogar();
        cy.title().should("eq", "Login - My Shop");
    })

})

// describe("Login", ()=>{
//     beforeEach(()=>{
//         cy.visit("/")
//     })
    
//     it.only("Verificar se está na home", () => {
//         cy.title().should("eq", "My Shop")
//     })
// })