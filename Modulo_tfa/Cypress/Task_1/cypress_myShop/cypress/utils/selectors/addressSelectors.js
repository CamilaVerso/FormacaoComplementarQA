export const addressSelector = {
    selectors:{
        companyField: "#company",
        addressField: "#address1",
        addressSecondaryField: "#address2",
        cityField: "#city",
        stateField: "#id_state",
        zipPostalCodeField: "#postcode",
        countryField: "#id_country",
        homePhoneField: "#phone",
        mobilePhoneField: "#phone_mobile",
        additionalInformationField: "#other",
        nameAddressField: "#alias",
        btnSave: "#submitAddress", //#submitAddress > span
        btnDelete: "#center_column > div.addresses > div > div > ul > li.address_update > a:nth-child(2)",
        textPageMyAddresses: ".breadcrumb > :nth-child(5)",
        backToYourAddressesBtn: "#center_column > ul > li > a",
        addMyFirstAddressBtn: "#center_column > div > div > ul > li:nth-child(1) > a > span", //'.myaccount-link-list > :nth-child(1) > a > span'
        textMyAccount: "#center_column > h1", //.breadcrumb > :nth-child(5)
        textYourAddress: ".info-title",
        textAddressDeleted: ".alert > a",
        textErrorAddressCreate: "#center_column > div > div > ol > li",
     
    },

    messages: {
        confirmAddressPage: "My addresses",
        confirmDelete: "Add a new address",
        confirmPageNewAddress: "\n\t\t\t\t\tTo add a new address, please fill out the form below.\n\t\t\t",
        errorAddressCreate: "The Zip/Postal code you've entered is invalid. It must follow this format: 00000",
    }
    

}