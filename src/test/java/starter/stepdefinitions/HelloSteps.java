package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Hello;

public class HelloSteps {

    @Steps
    Hello hello;

    //TC_Hello_01 - Index [Positive]
    
    @Given("User input endpoint hello")
    public void userInputEndpointHello() {
        hello.userInputEndpointHello();
    }

    @When("User request HTTP method GET in the request body and click Send Button")
    public void userRequestHTTPMethodGETInTheRequestBodyAndClickSendButton() {
        hello.userRequestGETMethodToGetIndex();
    }

    @Then("Validate success to see data {string} in the response body")
    public void validateSuccessToSeeDataInTheResponseBody(String successGetIndex) {
        hello.successToSeeTheIndex("hello");
    }

    
    
    

    //TC_Hello_02 - Index [Negative]

    @Given("User input endpoint hai")
    public void userInputEndpointHai() {
        hello.userInputEndpointHai();
    }

    @When("User request HTTP method Get in the request body and click Send Button")
    public void userRequestHTTPMethodGetInTheRequestBodyAndClickSendButton() {
        hello.userRequestGETMethodToGetIndexCaseNegative();
        
    }

    @Then("Validate failed to see data hai and display message {string} in the response body")
    public void validateFailedToSeeDataHaiAndDisplayMessageInTheResponseBody(String failedGetIndex) {
        hello.failedToSeeTheIndex("not found");
    }
}
