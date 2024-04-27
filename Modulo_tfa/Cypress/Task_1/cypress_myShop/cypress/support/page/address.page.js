import { addressSelector } from "../../utils/selectors/addressSelectors";
const { selectors, messages } = addressSelector;
import { addressData } from "../../fixtures/addressData";

Cypress.Commands.add("insertAddressWithValidData", () => {

    cy.get(selectors.addMyFirstAddressBtn).click();
    cy.get(selectors.textYourAddress).should("have.text", messages.confirmPageNewAddress); 
    cy.get(selectors.companyField).type("Inc "+ addressData.company);
    cy.get(selectors.addressField).type(addressData.address);
    cy.get(selectors.addressSecondaryField).type(addressData.addressSecondary);
    cy.get(selectors.cityField).type(addressData.city);
    cy.get(selectors.stateField).select(addressData.state);
    cy.get(selectors.zipPostalCodeField).type(addressData.zipCode);
    cy.get(selectors.homePhoneField).type(addressData.phoneNumber);
    cy.get(selectors.mobilePhoneField).type(addressData.phoneNumber);
    cy.get(selectors.additionalInformationField).type(addressData.addInformation);
    cy.get(selectors.nameAddressField).type(addressData.addInformation);
    cy.get(selectors.btnSave).click();
    cy.get(selectors.textPageMyAddresses).should("have.text", messages.confirmAddressPage);
    cy.get(selectors.btnDelete).click();
    cy.get(selectors.textAddressDeleted).should("have.text", messages.confirmDelete);
       
})

Cypress.Commands.add("insertAddressWithInvalidData", () => {
    cy.get(selectors.addMyFirstAddressBtn).click();
    cy.get(selectors.textYourAddress).should("have.text", messages.confirmPageNewAddress); 
    cy.get(selectors.companyField).type("Inc "+ addressData.company);
    cy.get(selectors.addressField).type(addressData.address);
    cy.get(selectors.addressSecondaryField).type(addressData.addressSecondary);
    cy.get(selectors.cityField).type(addressData.city);
    cy.get(selectors.stateField).select(addressData.state);
    cy.get(selectors.zipPostalCodeField).type(addressData.invalidData);
    cy.get(selectors.homePhoneField).type(addressData.phoneNumber);
    cy.get(selectors.mobilePhoneField).type(addressData.phoneNumber);
    cy.get(selectors.additionalInformationField).type(addressData.addInformation);
    cy.get(selectors.nameAddressField).type(addressData.addInformation);
    cy.get(selectors.btnSave).click();
    cy.get(selectors.textErrorAddressCreate).should("have.text", messages.errorAddressCreate);
    
})