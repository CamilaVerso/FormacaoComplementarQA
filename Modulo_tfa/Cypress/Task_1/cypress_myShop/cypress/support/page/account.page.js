import { accountSelectors } from "../../utils/selectors/accountSelectors";
const { selectors, messages } = accountSelectors;
import { accountData } from "../../fixtures/accountData";



Cypress.Commands.add("criarContaComSucesso", () => {

    cy.get(selectors.homePageSignUpBtn).click();
        cy.get(selectors.emailField).type(accountData.validEmail);
        cy.get(selectors.createAnAccountBtn).click();
        cy.get(selectors.pronounMr).click();
        cy.get(selectors.firstNameField).type(accountData.firstName);
        cy.get(selectors.lastNameField).type(accountData.lastName);
        cy.get(selectors.passwordField).type(accountData.validPassword);
        cy.get(selectors.selectDay).select(accountData.day);
        cy.get(selectors.selectMonth).select(accountData.month);
        cy.get(selectors.selectYear).type(accountData.year);
        cy.get(selectors.acceptationTerms).click();
        cy.get(selectors.registerBtn).click();
        cy.get(selectors.textConfirmationCreate).should("have.text", messages.accountCreated);
        cy.get(selectors.logoutBtn).click();
        cy.get(selectors.textConfirmLogout).should("have.text", messages.confirmLogout)
        
})

Cypress.Commands.add("criarContaComEmailInvalido", () => {
    cy.get(selectors.homePageSignUpBtn).click();
    cy.get(selectors.emailField).type(accountData.validEmail);
    cy.get(selectors.createAnAccountBtn).click();
    cy.get(selectors.textInvalidEmail).should("have.text", messages.msgInvalidEmail);

})