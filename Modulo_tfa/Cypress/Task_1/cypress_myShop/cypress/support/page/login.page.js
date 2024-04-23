import { loginSelector } from "../../utils/selectors/loginSelectors";
const { selectors } = loginSelector;

Cypress.Commands.add("fazerLoginValido", () => {
    cy.get(selectors.homePageSignUpBtn).click();
    cy.get(selectors.emailField).type("camila@camila5.com");
    cy.get(selectors.passwordField).type("12345678");
    cy.get(selectors.signInBtn).click();
    cy.get(selectors.loginInfoText).should("have.text", "Welcome to your account. Here you can manage all of your personal information and orders.");
})

Cypress.Commands.add("deslogar", () => {
    cy.get(selectors.signOutBtn).click();
    
})