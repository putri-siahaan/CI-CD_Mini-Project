package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Authentication;

public class AuthenticationSteps {

    @Steps
    Authentication authentication;

    //TC_Authentication_01 - Register [Positive]

    @Given("User input valid endpoint to create account")
    public void userInputValidEndpointToCreateAccount() {
        authentication.userInputValidEndpointToCreateAccount();
    }

    @When("User request HTTP method POST in the request body and input valid email, password, fullname, and click Send Button")
    public void userRequestHTTPMethodPOSTAndInTheRequestBodyAndInputValidEmailPasswordFullnameAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputWithValidDataAccount();
        
    }

    @Then("Validate success to create account and display detail account in the response body")
    public void validateSuccessToCreateAccountAndDisplayDetailAccountInTheResponseBody() {
        authentication.successToCreateAccount();
    }





    //TC_Authentication_02 - Register [Negative 1]

    @When("User request HTTP method POST in the request body and input email already exists and click Send Button")
    public void userRequestHTTPMethodPOSTInTheRequestBodyAndInputEmailAldreadyExistsAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputEmailAlreadyExists();
    }

    @Then("Validate failed to create account and display error message {string} in the response body")
    public void validateFailedToCreateAccountAndDisplayErrorMessageUsers_email_keyInTheResponseBody(String failedCreateAccount) {
        authentication.failedToCreateAccountBecauseEmailAlreadyExists("duplicate key value violates unique constraint \\\"users_email_key\\\" (SQLSTATE 23505)");
    }





    //TC_Authentication_03 - Register [Negative 2]

    @When("User request HTTP method POST and did not input email in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndDidNotInputEmailInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndDidNotInputEmail();
    }

    @Then("Validate failed to create account because did not input email and display error message {string} in the response body")
    public void validateFailedToCreateAccountBecauseDidNotInputEmailAndDisplayErrorMessageInTheResponseBody(String failedBecauseDidNotInputEmail) {
        authentication.failedToCreateAccountBecauseDidNotInputEmail("email is required");
    }





    //TC_Authentication_04 - Register [Negative 3]
    
    @When("User request HTTP method POST and did not input password in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndDidNotInputPasswordInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndDidNotInputPassword();
    }

    @Then("Validate failed to create account because did not input password and display error message {string} in the response body")
    public void validateFailedToCreateAccountBecauseDidNotInputPasswordAndDisplayErrorMessageInTheResponseBody(String failedBecauseDidNotInputPassword) {
        authentication.failedToCreateAccountBecauseDidNotInputPassword("password is required");
    }




    //TC_Authentication_05 - Register [Negative 4]

    @When("User request HTTP method POST and did not input fullname in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndDidNotInputFullnameInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndDidNotInputFullname();
    }

    @Then("Validate failed to create account because did not input fullname and display error message {string} in the response body")
    public void validateFailedToCreateAccountBecauseDidNotInputFullnameAndDisplayErrorMessageInTheResponseBody(String failedBecauseDidNotInputFullname) {
        authentication.failedToCreateAccountBecauseDidNotInputFullname("fullname is required");
    }





    //TC_Authentication_06 - Register [Negative 5]

    @When("User request HTTP method POST and input invalid email in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidEmailInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputInvalidEmail();
    }

    @Then("Validate failed to create account because input invalid email and display error message in the response body")
    public void validateFailedToCreateAccountBecauseInputInvalidEmailAndDisplayErrorMessageInTheResponseBody(String failedBecauseInvalidEmail) {
        authentication.failedToCreateAccountBecauseInputInvalidEmail("email is wrong");
    }





    //TC_Authentication_07 - Register [Negative 6]
    
    @When("User request HTTP method POST and input invalid password in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidPasswordInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputInvalidPassword();
    }

    @Then("Validate failed to create account because input invalid password and display error message {string} in the response body")
    public void validateFailedToCreateAccountBecauseInputInvalidPasswordAndDisplayErrorMessageInTheResponseBody(String failedBecauseInvalidPassword) {
        authentication.failedToCreateAccountBecauseInputInvalidPassword("json: cannot unmarshal number into Go struct field AuthRegisterRequest.password of type string");
    }




    //TC_Authentication_08 - Register [Negative 7]
    
    @When("User request HTTP method POST and input invalid fullname in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidFullnameInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputInvalidFullname();
    }

    @Then("Validate failed to create account because input invalid fullname and display error message {string} in the response body")
    public void validateFailedToCreateAccountBecauseInputInvalidFullnameAndDisplayErrorMessageInTheResponseBody(String failedBecauseInvalidFullname) {
        authentication.failedToCreateAccountBecauseInputInvalidFullname("json: cannot unmarshal number into Go struct field AuthRegisterRequest.fullname of type string");
    }





    //TC_Authentication_09 - Register [Negative 8]

    @When("User request HTTP method POST and input email with a space in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputEmailWithASpaceInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputEmailWithSpace();
    }

    @Then("Validate failed to create account because input email with a space and display {string} in the response body")
    public void validateFailedToCreateAccountBecauseInputEmailWithASpaceAndDisplayErrorMessageInTheResponseBody(String failedBecauseEmailWithSpace) {
        authentication.failedToCreateAccountBecauseInputEmailWithSpace("error message");
    }




    //TC_Authentication_10 - Register [Negative 9]

    @When("User request HTTP method POST and input password with a space in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputPasswordWithASpaceInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputPasswordWithSpace();
    }

    @Then("Validate failed to create account because input password with a space and display {string} in the response body")
    public void validateFailedToCreateAccountBecauseInputPasswordWithASpaceAndDisplayInTheResponseBody(String failedBecausePasswordWithSpace) {
        authentication.failedToCreateAccountBecauseInputPasswordWithSpace("error message");
    }




    //TC_Authentication_11 - Register [Negative 10]

    @When("User request HTTP method POST and input fullname with a space in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputFullnameWithASpaceInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputFullnameWithSpace();
    }

    @Then("Validate failed to create account because input fullname with a space and display {string} in the response body")
    public void validateFailedToCreateAccountBecauseInputFullnameWithASpaceAndDisplayInTheResponseBody(String failedBecauseFullnameWithSpace) {
        authentication.failedToCreateAccountBecauseInputFullnameWithSpace("error message");
    }





    
    //TC_Authentication_12 - Register [Negative 11]
    
    @Given("User input invalid endpoint to create account")
    public void userInputInvalidEndpointToCreateAccount() {
        authentication.userInputInvalidEndpointToCreateAccount();
    }

    @When("User request HTTP method POST and input valid data in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputValidDataInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputValidData();
    }

    @Then("Validate failed to create account because invalid endpoint and display {string} in the response body")
    public void validateFailedToCreateAccountBecauseInvalidEndpointAndDisplayInTheResponseBody(String failedBecauseInvalidEndpoint) {
        authentication.failedToCreateAccountBecauseInputInvalidEndpoint("not found");
    }





    //TC_Authentication_13 - Login [Positive]
    
    @Given("User input valid endpoint to login")
    public void userInputValidEndpointToLogin() {
        authentication.userInputValidEndpointToLogin();
    }

    @When("User request HTTP method POST and input valid email and valid password in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputValidEmailAndValidPasswordInTheRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodAndInputValidEmailAndPassword();
        
    }

    @Then("Validate failed to login because input valid endpoint and valid account and display token in the response body")
    public void validateFailedToLoginBecauseInputValidEndpointAndValidAccountAndDisplayInTheResponseBody() {
        authentication.successToLoginBecauseInputValidEndpointSNdAccount();
    }





    //TC_Authentication_14 - Login [Negative 1]
    
    @Given("User input invalid endpoint to login")
    public void userInputInvalidEndpointToLogin() {
        authentication.userInputInvalidEndpointToLogin();
    }

    @When("User request HTTP method POST and input valid email and valid password in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputValidEmailAndValidPasswordInRequestBodyAndClickSendButton() {
        authentication.userRequestPostMethodAndInputValidData();
    }

    @Then("Validate failed to login because input invalid endpoint and display error message {string} in the response body")
    public void validateFailedToLoginBecauseInputInvalidEndpointAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseInvalidEndpoint) {
        authentication.failedToLoginBecauseInputInvalidEndpoint("not found");
    }







    //TC_Authentication_15 - Login [Negative 2]

    @When("User request HTTP method POST and input invalid email in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidEmailInRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodToLoginAndInputInvalidEmail();
    }

    @Then("Validate failed to login because input invalid email and display error message {string} in the response body")
    public void validateFailedToLoginBecauseInputInvalidEmailAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseInvalidEmail) {
        authentication.failedToLoginBecauseInputValidEndpointAndAccount("record not found");

    }






    //TC_Authentication_16 - Login [Negative 3]

    @When("User request HTTP method POST and input invalid password in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidPasswordInRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodToLoginAndInputInvalidPassword();
    }

    @Then("Validate failed to login because input invalid password and display error message {string} in the response body")
    public void validateFailedToLoginBecauseInputInvalidPasswordAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseInvalidPassword) {
        authentication.failedToLoginBecauseInputInvalidPassword("\"email or password is invalid");
    }






    //TC_Authentication_17 - Login [Negative 4]

    @When("User request HTTP method POST and input invalid email and password in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidEmailAndPasswordInRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodToLoginAndInputInvalidEmailAndPassword();
    }

    @Then("Validate failed to login because input invalid email and password and display error message {string} in the response body")
    public void validateFailedToLoginBecauseInputInvalidEmailAndPasswordAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseInvalidEmailAndPassword) {
        authentication.failedToLoginBecauseInputInvalidEmailAndPassword("record not found");
    }





    //TC_Authentication_18 - Login [Negative 5]

    @When("User request HTTP method POST and and did not input email in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndDidNotInputEmailInRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodToLoginAndDidNotInputEmail();
    }

    @Then("Validate failed to login because did not input email and display error message {string} in the response body")
    public void validateFailedToLoginBecauseDidNotInputEmailAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseDidNotInputEmail) {
        authentication.failedToLoginBecauseDidNotInputEmail("email is required");
    }





    //TC_Authentication_19 - Login [Negative 6]

    @When("User request HTTP method POST and did not input password in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndAndDidNotInputPasswordInRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodToLoginAndDidNotInputPassword();
    }

    @Then("Validate failed to login because did not input password and display error message {string} in the response body")
    public void validateFailedToLoginBecauseDidNotInputPasswordAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseDidNotInputPassword) {
        authentication.failedToLoginBecauseDidNotInputPassword("password is required");
    }





    //TC_Authentication_20 - Login [Negative 7]

    @When("User request HTTP method POST and did not input email and password in request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndDidNotInputEmailAndPasswordInRequestBodyAndClickSendButton() {
        authentication.userRequestPOSTMethodToLoginAndDidNotInputEmailAndPassword();
    }

    @Then("Validate failed to login because did not input email and password and display error message {string} in the response body")
    public void validateFailedToLoginBecauseDidNotInputEmailAndPasswordAndDisplayErrorMessageInTheResponseBody(String failedLoginBecauseDidNotInputEmailAndPassword) {
        authentication.failedToLoginBecauseDidNotInputEmailAndPassword("email is required");
    }





    //TC_Authentication_21 - Get User Information [Positive]

    @Given("User input valid endpoint to get user information")
    public void userInputValidEndpointToGetUserInformation() {
        authentication.userInputValidEndpointToGetUserInformation();
    }


    @When("User request HTTP method GET to get user information and click Send Button")
    public void userRequestHTTPMethodGETtoGetUserInformationAndClickSendButton() {
        authentication.userRequestTheGETMethodToGetUserInformationCasePositive();
    }

    @Then("Validate success to get user information and display information the account in the response body")
    public void validateSuccessToGetUserInformationAndDisplayInformationTheAccountInTheResponseBody() {
        authentication.successToGetUserInformation();
    }






    //TC_Authentication_22 - Get User Information [Negative]

    @Given("User input invalid endpoint to get user information")
    public void userInputInvalidEndpointToGetUserInformation() {
        authentication.userInputInvalidEndpointToGetUserInformation();
    }

    @When("User request a method HTTP GET and click Send Button")
    public void userRequestAMethodHTTPGETAndClickSendButton() {
        authentication.userRequestGETMethodCaseNegative();
    }

    @Then("Validate failed to get user information and display error message {string} in the response body")
    public void validateFailedToGetUserInformationAndDisplayErrorMessageInTheResponseBody(String failedToGetUserInformation) {
        authentication.failedToGetUserInformationBecauseInvalidEndpoint("not found");
    }
}
