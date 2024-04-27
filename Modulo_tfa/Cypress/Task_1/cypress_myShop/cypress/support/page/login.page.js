import { loginSelector } from "../../utils/selectors/loginSelectors";
const { selectors, messages } = loginSelector;

Cypress.Commands.add("makeLoginValid", () => {
    cy.get(selectors.homePageSignUpBtn).click();
    cy.get(selectors.emailField).type("camila@camila5.com");
    cy.get(selectors.passwordField).type("12345678");
    cy.get(selectors.signInBtn).click();
    cy.get(selectors.loginInfoText).should("have.text", messages.confirmPageLogin);
})

Cypress.Commands.add("logout", () => {
    cy.get(selectors.signOutBtn).click();
    
})