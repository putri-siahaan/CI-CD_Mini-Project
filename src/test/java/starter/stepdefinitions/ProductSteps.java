package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;
import starter.pages.Products;

public class ProductSteps {
    @Steps
    Products products;

    // TC_Products_01 - Get All Product [Positive]
    @Given("User input valid Endpoint")
    public void inputValidEndpoint() {
        products.userInputValidEndpoint();
    }

    @When("User request with the HTTP method GET and click Send Button to send a request")
    public void userRequestWithTheHTTPMethodGET() {
        products.userRequestHttpMethodGet();
    }

    @And("User receive a response with status code 200 OK")
    public void userClickSendButtonToSendARequestAndReceive200OK() {
        products.receiveHttpResponseCode200();
    }

    @Then("Validate success receive detail all products in the response body")
    public void validateReceiveDetailAllProductsInTheResponseBody() {
        products.validateDataUser();
    }


    //TC_Products_02 - Get All Product [Negative 1]
    @Given("User input invalid Endpoint")
    public void userInputInvalidEndpoint() {
        products.userInputInvalidEndpoint();
    }

    @When("User request HTTP method GET and click Send Button to send a request")
    public void userRequestHTTPMethodGET() {
        products.requestHttpMethodGet();
    }

    @And("User receive a response with status code is 404 Not Found")
    public void userClickSendButtonToSendARequestAndReceiveAResponseWithStatusCodeIsNotFound() {
        products.receiveHttpResponseCode404();
    }

    @Then("Validate failed receive detail all products and display message {string} in the response body")
    public void validateFailedReceiveDetailAllProductsInTheResponseBody(String messageResponse404) {
        products.validateFailedReceiveDetailAllProducts("not found");
    }



    //TC_Products_03 - Create a New Product [Positive]
    @When("User request with the HTTP method POST and input data of a new product with valid data in the request body and click Send Button to send a request")
    public void userRequestWithTheHTTPMethodPOSTAndInputDataOfANewProductWithValidDataInTheRequestBodyAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostCreateProductWithValidEndpoint();
    }

    @Then("Validate success to create new product and display detail all products in the response body")
    public void validateSuccessReceiveToCreateNewProductAndDisplayDetailAllProductsInTheResponseBody() {
        products.validateSuccessCreateNewProduct();
    }



    //TC_Products_04 - Create a New Product [Negative 1]

    @When("User request with HTTP method POST and input data with invalid name of the new products in the request body and click Send Button to send a request")
    public void userRequestWithHTTPMethodPOSTAndInputDataWithInvalidNameOfTheNewProductsInTheRequestBodyAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostCreateProductWithInvalidName();
    }

    @And("User receive a response with status code 500 Internal Server Error")
    public void userReceiveAResponseWithStatusCodeInternalServerError() {
        products.receiveHttpResponseCode500();
    }

    @Then("Validate failed to create a new product and display error message {string} in the response body")
    public void validateFailedToCreateANewProductAndDisplayErrorMessageProductsProducts_name_checkInTheResponseBody(String errorName) {
        products.validateFailedCreateNewProduct("ERROR: new row for relation \\\"products\\\" violates check constraint \\\"products_name_check\\\" (SQLSTATE 23514)");
    }




    //TC_Products_05 - Create a New Product [Negative 2]
    
    @When("User request with HTTP method POST and input data of a new product with invalid description in the request body and click Send Button to send a request")
    public void userRequestWithHTTPMethodPOSTAndInputDataOfANewProductWithInvalidDescriptionInTheRequestBodyAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostCreateProductWithInvalidDescription();
    }

    @And("User receive a response with status code 400 Bad Request")
    public void userReceiveAResponseWithStatusCodeBadRequest() {
        products.receiveHttpResponseCode400();
    }

    @Then("Validate failed create a new product and display error message {string} in the response body")
    public void validateFailedCreateANewProductAndDisplayErrorMessageInTheResponseBody(String errorDescription) {
        products.validateFailedCreateNewProductBecauseInvalidDescription("\"json: cannot unmarshal number into Go struct field ProductCreate.description of type string");
    }




    //TC_Products_06 - Create a New Product [Negative 3]

    @When("User request with HTTP method POST and input data of a new product with invalid price in the request body and click Send Button to send a request")
    public void userRequestWithHTTPMethodPOSTAndInputDataOfANewProductWithInvalidPriceInTheRequestBodyAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostCreateProductWithInvalidPrice();
    }

    @Then("Validate failed to create new product and display error message {string} in the response body")
    public void validateFailedToCreateNewProductAndDisplayErrorMessageInTheResponseBody(String errorPrice) {
        products.validateFailedCreateNewProductBecauseInvalidPrice("json: cannot unmarshal string into Go struct field ProductCreate.price of type uint");
    }





    //TC_Products_07 - Create a New Product [Negative 4]

    @When("User request with HTTP method POST and input data of a new product with invalid categories in the request body and click Send Button to send a request")
    public void userRequestWithHTTPMethodPOSTAndInputDataOfANewProductWithInvalidCategoriesInTheRequestBodyAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostCreateProductWithInvalidCategories();
    }

    @Then("Validate failed create new product and display error message {string} in the response body")
    public void validateFailedCreateNewProductAndDisplayErrorMessageInTheResponseBody(String errorCategories) {
        products.validateFailedCreateNewProductBecauseInvalidCategories("json: cannot unmarshal string into Go struct field ProductCreate.categories of type uint");
    }





    //TC_Products_08 - Create a New Product [Negative 5]

    @When("User request with the HTTP method POST and input data of a new product with valid data and click Send Button to send a request")
    public void userRequestWithTheHTTPMethodPOSTAndInputDataOfANewProductWithValidDataAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostCreateProductWithInvalidEndpoint();
    }

    @Then("Validate failed to create new a product and display error message {string} in the response body")
    public void validateFailedToCreateNewAProductAndDisplayErrorMessageInTheResponseBody(String errorInvalidEndpoint) {
        products.validateFailedCreateNewProductBecauseInvalidEndpoint("not found");
    }



    //TC_Products_09 - Get product By ID [Positive]

    @Given("User input Endpoint with valid ID 86235")
    public void userInputEndpointWithValidID() {
        products.userInputValidEndpoint86235();
    }

    @When("User is request with HTTP method GET and click Send Button to send a request")
    public void userIsRequestWithHTTPMethodGETAndClickSendButtonToSendARequest() {
        products.requestHttpMethodPostButtonToSendRequest();
    }

    @Then("Validate success to get the data with ID=86235 and display detail pf the products in the response body")
    public void validateSuccessToGetTheDataWithIDAndDisplayDetailPfTheProductsInTheResponseBody() {
        products.validateSuccessToGetProductByID();
    }




    //TC_Products_10 - Get product By ID [Negative]

    @Given("User input endpoint with invalid ID = 100000")
    public void userInputEndpointWithInvalidID() {
        products.userInputInvalidID100000();
    }

    @When("User request data with HTTP method GET and click Send Button to send a request")
    public void userRequestDataWithHTTPMethodGETAndClickSendButtonToSendARequest() {
        products.requestHttpMethodGetButtonToSendRequest();
    }

    @Then("Validate failed execution and display error message {string} in the response body")
    public void validateFailedExecutionAndDisplayErrorMessageInTheResponseBody(String errorRecordNotFound) {
        products.validateFailedExecutionRecordNotFound("record not found");
    }




    //TC_Products_11 - Delete a Product [Positive]

    @Given("User input endpoint with valid ID to Delete a product")
    public void userInputEndpointWithValidIDToDeleteAProduct() {
        products.userInputValidIDToDeleteProduct();
    }

    @When("User request with the HTTP method DELETE and click Send Button to send a request")
    public void userRequestWithTheHTTPMethodDELETEAndClickSendButtonToSendARequest() {
        products.requestHttpMethodDeleteButtonToRemoveProduct();
    }

    @Then("Validate success to delete the product and display message {string} data in the response body")
    public void validateSuccessToDeleteTheProductAndDisplayMessageDataInTheResponseBody(String successDelete) {
        products.validateSuccessToDeleteProduct("null");
    }




    //TC_Products_12 - Delete a Product [Negative]

    @Given("User input endpoint with the invalid ID = 0")
    public void userInputEndpointWithTheInvalidID() {
        products.userInputInvalidIDToDeleteProduct();
    }

    @When("User request with the HTTP method DELETE and click Send Button to send request")
    public void userRequestWithTheHTTPMethodDELETEAndClickSendButtonToSendRequest() {
        products.requestHttpMethodDeleteButtonCaseNegative();
    }

    @Then("Validate success to delete the product and display error message {string} in the response body")
    public void validateSuccessToDeleteTheProductAndDisplayErrorMessageInTheResponseBody(String failedDelete) {
        products.validateFailedToDeleteProduct("WHERE conditions required");
    }



    //TC_Products_13 - Assign a product rating [Positive 1]

    @Given("User input Endpoint with valid ID 86235 in case rating")
    public void userInputEndpointWithValidIDInCaseRating() {
        products.userInputValidIDToAssignRatingProduct();
    }

    @When("User request with the method HTTP POST and input valid count of the star is 3 in the request body and click Send Button to send request")
    public void userRequestWithTheMethodHTTPPOSTAndInputValidCountOfTheStarIs3InTheRequestBodyAndClickSendButtonToSendRequest() {
        products.requestHttpMethodPostAndInputRating3();
    }

    @Then("Validate success to assign rating and display detail products that have been rated in the response body")
    public void validateSuccessToAssignRatingAndDisplayDetailProductsThatHaveBeenRatedInTheResponseBody() {
        products.validateSuccessAssignRating();
    }




    //TC_Products_14 - Assign a product rating [Positive 2]

    @When("User request with the method HTTP POST and input valid count of the star is 0 in the request body and click Send Button to send request")
    public void userRequestWithTheMethodHTTPPOSTAndInputValidCountOfTheStarIs0InTheRequestBodyAndClickSendButtonToSendRequest() {
        products.requestHttpMethodPostAndInputRating0();
    }

    @Then("Validate success to assign ratings and display detail products that have been rated in the response body")
    public void validateSuccessToAssignRatingsAndDisplayDetailProductsThatHaveBeenRatedInTheResponseBody() {
        products.validateSuccessAssignRating0();
    }



    
    //TC_Products_15 - Assign a product rating [Negative 1]
    
    @Given("User input endpoint with invalid ID to assign rating")
    public void userInputEndpointWithInvalidIDToAssignRating() {
        products.userInputEndpointWithInvalidIDToAssignRatingProduct();
    }

    @When("User request with method HTTP POST and input valid count of the stars in the request body and click Send Button to send request")
    public void userRequestWithMethodHTTPPOSTAndInputValidCountOfTheStarsInTheRequestBodyAndClickSendButtonToSendRequest() {
        products.requestHttpMethodPostWithInvalidID();
        
    }

    @Then("Validate failed execution and display message {string} in the response body")
    public void validateFailedExecutionAndDisplayMessageInTheResponseBody(String failedAssignBecauseInvalidID) {
        products.validateFailedToAssignRatingBecauseInvalidID("record not found");
    }




    //TC_Products_16 - Assign a product rating [Negative 2]

    @When("User request with method HTTP POST and input invalid count of the stars to be assigned and click Send Button to send request")
    public void userRequestWithMethodHTTPPOSTAndInputInvalidCountOfTheStarsToBeAssignedAndClickSendButtonToSendRequest() {
        products.requestHttpMethodPostWithInvalidCount();
    }

    @Then("Validate failed to assign ratings and display message {string} in the response body")
    public void validateFailedToAssignRatingsAndDisplayMessageRatingsRatings_count_checkInTheResponseBody(String failedAssignBecauseInvalidCount) {
        products.validateFailedToAssignRatingBecauseInvalidCount("ERROR: new row for relation \\\"ratings\\\" violates check constraint \\\"ratings_count_check\\\" (SQLSTATE 23514)");
    }




    //TC_Products_17 - Get product ratings [Positive]

    @When("User request with method HTTP GET and click Send Button to send request")
    public void userRequestWithMethodHTTPGETAndClickSendButtonToSendRequest() {
        products.requestHttpMethodGETtoGetProductRatings();
    }

    @Then("Validate success to get product ratings and display data=2 in the response body")
    public void validateSuccessToGetProductRatingsAndDisplayDataInTheResponseBody() {
        products.validateSuccessGetProductRatings();
    }




    //TC_Products_18 - Get product ratings [Negative]

    @Given("User input endpoint with invalid ID to get product ratings")
    public void userInputEndpointWithValidIDToAssignRating() {
        products.userInputEndpointWithValidIDToGetProductRatings();
    }

    @When("User request method HTTP GET and click Send Button")
    public void userRequestMethodHTTPGETAndClickSendButton() {
        products.requestHttpMethodGETWithInvalidID();
    }

    @Then("Validate failed to get product ratings and display error message {string} in the response body")
    public void validateFailedToGetProductRatingsAndDisplayErrorMessageInTheResponseBody(String failedGetProductRatingBecauseInvalidID) {
        products.validateFailedToGetProductRatingsBecauseInvalidID("18446744073709551615 is greater than maximum value for Int4");
    }




    //TC_Products_19 - Create a comment for product [Positive 1]

    @Given("User input a valid endpoint to create comments")
    public void userInputAValidEndpointToCreateComments() {
        products.userInputEndpointValidEndpointToCreateComment();
    }

    @When("User request method HTTP POST and input a comment containing a sentence and click Send Button to send request")
    public void userRequestMethodHTTPPOSTAndInputACommentContainingASentenceAndClickSendButtonToSendRequest() {
        products.requestHttpMethodPOSTWithValidID();
    }

    @Then("Validate success to create comment for product and display detail of the product with the comment in the response body")
    public void validateSuccessToCreateCommentForProductAndDisplayDetailOfTheProductWithTheCommentInTheResponseBody() {
        products.validateSuccessCreateCommentWithValidID();
    }





    //TC_Products_20 - Create a comment for product [Positive 2]

    @When("User request method HTTP POST and input comment of a product with only space and click Send Button to send request")
    public void userRequestMethodHTTPPOSTAndInputCommentOfAProductWithOnlySpaceAndClickSendButtonToSendRequest() {
        products.requestHttpMethodPOSTWithInputOnlySpace();
    }

    @Then("Validate success to create comment for product and display detail product with the comment in the response body")
    public void validateSuccessToCreateCommentForProductAndDisplayDetailProductWithTheCommentInTheResponseBody() {
        products.validateSuccessToCreateCommentWithValidID();
    }





    //TC_Products_21 - Create a comment for product [Negative 1]

    @Given("User input invalid Endpoint in the field")
    public void userInputInvalidEndpointInTheField() {
        products.userInputInvalidEndpointInTheField();
    }

    @When("User request method HTTP POST and input valid comment of a product and click Send Button")
    public void userRequestMethodHTTPPOSTAndInputValidCommentOfAProductAndClickSendButton() {
        products.requestHttpMethodPOSTWithValidComment();

    }

    @Then("Validate failed to create comment for product and display message {string} in the response body")
    public void validateFailedToCreateCommentForProductAndDisplayMessageInTheResponseBody(String failedCreateCommentBecauseInvalidID) {
        products.validateFailedToCreateCommentBecauseInvalidID("not found");
    }




    //TC_Products_22 - Create a comment for product [Negative 2]

    @Given("User input Valid Endpoint in the field")
    public void userInputValidEndpointInTheField() {
        products.userInputValidEndpointInTheField();
    }

    @When("User request method HTTP POST and input invalid comment of a product and click Send Button")
    public void userRequestMethodHTTPPOSTAndInputInvalidCommentOfAProductAndClickSendButton() {
        products.requestHttpMethodPOSTWithInvalidComment();
        
    }

    @Then("Validate failed to create comment for product and display error message {string} in the response body")
    public void validateFailedToCreateCommentForProductAndDisplayErrorMessageCommnetsInTheResponseBody(String failedCreateCommentBecauseInvalidContent) {
        products.validateFailedToCreateCommentBecauseInvalidContent("ERROR: new row for relation \\\"comments\\\" violates check constraint \\\"comments_content_check\\\" (SQLSTATE 23514)");
    }




    //TC_Products_23 - Get product comments [Positive]

    @When("User request method GET and click Send Button")
    public void userRequestMethodGETAndClickSendButton() {
        products.requestHttpMethodGETWithValidID();
    }

    @Then("Validate success to get product comment for product and display detail of the product with the comment in the response body")
    public void validateSuccessToGetProductCommentForProductAndDisplayDetailOfTheProductWithTheCommentInTheResponseBody() {
        products.validateToGetProductCommentWithValidID();
    }


    
    

    //TC_Products_24 - Get product comments [Negative]

    @Given("User input a invalid Endpoint in the field")
    public void userInputAInvalidEndpointInTheField() {
        products.userInputInvalidEndpointSoFailedGetProductComments();
    }


    @When("User request http method GET and click Send Button")
    public void userRequestHttpMethodGETAndClickSendButton() {
        products.requestHttpMethodGETWithInvalidIDIs2();
    }

    @Then("Validate failed to get product comment for product and display message {string} in the response body")
    public void validateFailedToGetProductCommentForProductAndDisplayMessageInTheResponseBody(String failedGetProductCommentBecauseInvalidID) {
        products.validateFailedToGetProductCommentBecauseInvalidID("not found");
    }
}
