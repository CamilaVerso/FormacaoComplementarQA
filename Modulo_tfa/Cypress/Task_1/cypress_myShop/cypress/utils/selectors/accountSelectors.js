export const accountSelectors = {
    selectors: {
        homePageInfo: "#home-page-tabs > li.active > a",
        homePageSignUpBtn: ".login",     
        emailField: "#email_create",
        passwordField: "#passwd",
        firstNameField: "#customer_firstname",
        lastNameField: "#customer_lastname",
        pronounMr: "#id_gender1",
        createAnAccountBtn: "#SubmitCreate > span",
        registerBtn: "#submitAccount > span",
        selectDay: "#days",
        selectMonth: "#months",
        selectYear: "#years",
        acceptationTerms: "#newsletter",      
        logoutBtn: ".logout",    
        errorMessageFirstNameRequired: "#center_column > div",
        textConfirmationCreate: ".alert",
        textConfirmLogout: ".page-heading",
        textInvalidEmail: "#create_account_error > ol > li",   
    },

    messages: {        
    accountCreated: "\n\t\tYour account has been created.\n\t",
    confirmLogout: "Authentication",
    msgInvalidEmail: "An account using this email address has already been registered. Please enter a valid password or request a new one. ",
    }

}