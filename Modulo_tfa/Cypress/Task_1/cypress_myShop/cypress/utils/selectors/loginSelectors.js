export const loginSelector = {
    selectors: {
        homePageSignUpBtn: "#header > div.nav > div > div > nav > div.header_user_info > a",
        emailField: "#email",
        passwordField: "#passwd",
        signInBtn: "#SubmitLogin",
        loginInfoText: "#center_column > p",
        signOutBtn: "#header > div.nav > div > div > nav > div:nth-child(2) > a",
    },
    messages: {
        confirmPageLogin: "Welcome to your account. Here you can manage all of your personal information and orders.",
    }
}