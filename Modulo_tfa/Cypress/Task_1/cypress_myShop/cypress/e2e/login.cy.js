/// <reference types="cypress" />

describe("Login", () => {
    beforeEach(()=>{
        cy.visit("/")
    })

    it("Fazer login com dados válidos", () => {
        cy.fazerLoginValido();
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