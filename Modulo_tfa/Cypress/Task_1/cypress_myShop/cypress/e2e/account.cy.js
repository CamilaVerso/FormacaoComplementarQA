/// <reference types="cypress" />
import { accountData } from "../fixtures/accountData.js"

describe("Criar conta", () => {
    beforeEach(()=>{
        cy.visit("/")
    })

    it("Criar conta com dados válidos e deslogar", () => {
        cy.criarContaComSucesso();
    })

    it("Criar conta com email inválido", () => {
        cy.criarContaComEmailInvalido();
    })    
   

})
