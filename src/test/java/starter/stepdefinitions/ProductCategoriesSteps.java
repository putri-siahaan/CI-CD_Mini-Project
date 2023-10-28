package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.ProductCategories;

public class ProductCategoriesSteps {

    @Steps
    ProductCategories productCategories;

    //TC_Category_01 - Create a category [Positive 1]
    @Given("User input valid Endpoint with categories")
    public void userInputValidEndpointWithCategories() {
        productCategories.userInputValidEndpointWithCategories();
    }

    @When("User request HTTP method POST and input data of a new category with valid data in the request body and click Send Button to send a request")
    public void userRequestHTTPMethodPOSTAndInputDataOfANewCategoryWithValidDataInTheRequestBodyAndClickSendButtonToSendARequest() {
        productCategories.userRequestPOSTMethodAndInputWithValidDataCategory();
    }

    @Then("Validate success to create new category and display detail all products in the response body")
    public void validateSuccessToCreateNewCategoryAndDisplayDetailAllProductsInTheResponseBody() {
        productCategories.successToCreateNewCategory();
    }



    //TC_Category_02 - Create a category [Positive 2]

    @When("User request HTTP method POST and data of description is empty in the request body and click Send Button to send a request")
    public void userRequestHTTPMethodPOSTAndDataOfDescriptionIsEmptyInTheRequestBodyAndClickSendButtonToSendARequest() {
        productCategories.userRequestPOSTMethodWithDataDescriptionIsEmpty();
    }

    @Then("Validate success to create new category and display detail all products in the response body but data of description is empty")
    public void validateSuccessToCreateNewCategoryAndDisplayDetailAllProductsInTheResponseBodyButDataOfDescriptionIsEmpty() {
        productCategories.successToCreateNewCategoryWithDescriptionIsEmpty();
    }




    //TC_Category_03 - Create a category [Negative 1]

    @When("User request method POST and input data of a new category with invalid name in the request body and click Send Button to send a request")
    public void userRequestMethodPOSTAndInputDataOfANewCategoryWithInvalidNameInTheRequestBodyAndClickSendButtonToSendARequest() {
        productCategories.userRequestPOSTMethodWithInvalidName();

    }

    @Then("Validate failed create a new category and display error message {string} in the response body")
    public void validateFailedCreateANewCategoryAndDisplayErrorMessageCategoriesCategories_name_checkInTheResponseBody(String errorInvalidName) {
        productCategories.failedToCreateNewCategoryWithInvalidName("ERROR: new row for relation \\\"categories\\\" violates check constraint \\\"categories_name_check\\\" (SQLSTATE 23514)");
    }




    //TC_Category_04 - Create a category [Negative 2]

    @When("User request method POST and input data of a new category with invalid description in the request body and click Send Button to send a request")
    public void userRequestMethodPOSTAndInputDataOfANewCategoryWithInvalidDescriptionInTheRequestBodyAndClickSendButtonToSendARequest() {
        productCategories.userRequestPOSTMethodWithInvalidDescription();
    }

    @Then("Validate failed to create new category and display error message {string} in the response body")
    public void validateFailedToCreateNewCategoryAndDisplayErrorMessageInTheResponseBody(String errorInvalidDescription) {
        productCategories.failedToCreateNewCategoryWithInvalidDescription("json: cannot unmarshal number into Go struct field CategoryCreate.description of type string");
    }



    //TC_Category_05 - Get category by ID [Positive]

    @Given("User input endpoint with valid ID to get Category")
    public void userInputEndpointWithValidIDToGetCategory() {
        productCategories.userInputEndpointWithValidIDToGetCategory();
    }

    @When("User request HTTP method GET and click Send Button")
    public void userRequestHTTPMethodGETAndClickSendButton() {
        productCategories.userRequestGETMethodAndClickSendButton();
    }

    @Then("Validate success to get category by ID and display detail data of category in the response body")
    public void validateSuccessToGetCategoryByIDAndDisplayDetailDataOfCategoryInTheResponseBody() {
        productCategories.successToGetCategoryByValidID();
    }

   


    //TC_Category_06 - Get category by ID [Negative]

    @Given("User input invalid Endpoint to get category")
    public void userInputInvalidEndpointToGetCategory() {
        productCategories.userInputEndpointWithInvalidIDToGetCategory();
    }


    @When("User request with the HTTP method GET and click Send Button")
    public void userRequestWithTheHTTPMethodGETAndClickSendButton() {
        productCategories.userRequestGetMethodAndClickSendButton();
    }

    @Then("Validate failed to get category and display error message {string} in the response body")
    public void validateFailedToGetCategoryAndDisplayErrorMessageInTheResponseBody(String failedGetCategory) {
        productCategories.failedToGetCategoryBecauseInvalidID("record not found");
    }




    //TC_Category_07 - Get all categories [Positive]

    @When("User request with the HTTP method GET and click Send Button to get all categories")
    public void userRequestWithTheHTTPMethodGETAndClickSendButtonToGetAllCategories() {
        productCategories.userRequestGETMethodToGetAllCategories();
    }

    @Then("Validate success to get all category and display detail data in the response body")
    public void validateSuccessToGetAllCategoryAndDisplayDetailDataInTheResponseBody() {
        productCategories.successToGetAllCategory();
    }




    //TC_Category_08 - Get all categories [Negative]

    @Given("User input invalid Endpoint with category")
    public void userInputInvalidEndpointWithCategory() {
        productCategories.userInputInvalidEndpointWithCategory();
    }

    @When("User request method HTTP GET and click Send Button to get all categories")
    public void userRequestMethodHTTPGETAndClickSendButtonToGetAllCategories() {
        productCategories.userRequestGetMethodCaseNegative();
    }

    @Then("Validate failed to get all category and display error message {string} in the response body")
    public void validateFailedToGetAllCategoryAndDisplayErrorMessageInTheResponseBody(String failedGetAllCategory) {
        productCategories.failedToGetAllCategoryBecauseInvalidEndpoint("not found");
    }




    //TC_Category_09 - Delete a category [Positive]

    @Given("User input Endpoint with valid ID=30000")
    public void userInputEndpointWithValidID() {
        productCategories.userInputEndpointWithValidID30000();
    }
    
    @When("User request DELETE method and click Send Button to remove the categories")
    public void userRequestDELETEMethodAndClickSendButtonToRemoveTheCategories() {
        productCategories.userRequestDELETEMethodToRemoveCategories();
    }

    @Then("Validate success to delete a category and display message {string} in the response body")
    public void validateSuccessToDeleteACategoryAndDisplayMessageInTheResponseBody(String successDeleteCategory) {
        productCategories.successToDeleteCategoryBecauseValidEndpoint("null");
    }

    

    
    

    //TC_Category_10 - Delete a category [Negative]

    @Given("User input Endpoint with invalid ID to delete a category")
    public void userInputEndpointWithInvalidIDToDeleteACategory() {
        productCategories.userInputEndpointWithInvalidID();
    }

    @When("User request DELETE method and click send button")
    public void userRequestDELETEMethodAndClickSendButton() {
        productCategories.userRequestDELETEMethodCaseNegative();
    }

    @Then("Validate failed to delete a category and display error message {string} in the response body")
    public void validateFailedToDeleteACategoryAndDisplayErrorMessageInTheResponseBody(String failedDeleteCategory) {
        productCategories.failedToDeleteCategoryBecauseInvalidEndpoint("not found");
    }
}



