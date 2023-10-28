package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.Order;

public class OrderSteps {

    @Steps
    Order order;

    //TC_Orders_01 - Create a new order [Positive]

    @Given("User input valid endpoint orders")
    public void userInputValidEndpointOrders() {
        order.userInputValidEndpointOrders();
    }

    @When("User request HTTP method POST and input valid product id and quantity in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputValidProductIdAndQuantityInTheRequestBodyAndClickSendButton() {
        order.userRequestPOSTMethodWithValidProductIDAndQuantity();
    }

    @Then("Validate success to order and display detail data order in the response body")
    public void validateSuccessToOrderAndDisplayDetailDataOrderInTheResponseBody() {
        order.successToOrder();
    }





    //TC_Orders_02 - Create a new order [Negative 1]

    @When("User request HTTP method POST and input invalid product id in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidProductIdInTheRequestBodyAndClickSendButton() {
        order.userRequestPOSTMethodWithInvalidProductID();
    }

    @Then("Validate failed to order and display error message {string} in the response body")
    public void validateFailedToOrderAndDisplayErrorMessageInTheResponseBody(String failedCase1) {
        order.failedToOrderBecauseInvalidProductID("json: cannot unmarshal");
    }



    //TC_Orders_03 - Create a new order [Negative 2]
    
    @When("User request HTTP method POST and input invalid quantity in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputInvalidQuantityInTheRequestBodyAndClickSendButton() {
        order.userRequestPOSTMethodWithInvalidQuantity();
    }

    @Then("Validate failed to order because invalid quantity and display error message {string} in the response body")
    public void validateFailedToOrderBecauseInvalidQuantityAndDisplayErrorMessageInTheResponseBody(String failedCase2) {
        order.failedToOrderBecauseInvalidQuantity("json: cannot unmarshal");
    }




    //TC_Orders_04 - Create a new order [Negative 3]

    @Given("User input invalid endpoint orders")
    public void userInputInvalidEndpointOrders() {
        order.userInputInvalidEndpointOrders();
    }

    @When("User request HTTP method POST and input valid quantity and product id in the request body and click Send Button")
    public void userRequestHTTPMethodPOSTAndInputValidQuantityAndProductIdInTheRequestBodyAndClickSendButton() {
        order.userRequestPOSTMethodWithValidQuantityAndProductID();
    }

    @Then("Validate failed to order because invalid endpoint and display error message {string} in the response body")
    public void validateFailedToOrderBecauseInvalidEndpointAndDisplayErrorMessageInTheResponseBody(String failedCase3) {
        order.failedToOrderBecauseInvalidEndpoint("not found");
    }





    //TC_Orders_05 - Get all orders [Positive]

    @When("User request HTTP method GET and click Send Button to get all orders")
    public void userRequestHTTPMethodGETAndClickSendButtonToGetAllOrders() {
        order.userRequestGETMethodWithValidEndpoint();
    }

    @Then("Validate success to get all orders and display all data order in the response body")
    public void validateSuccessToGetAllOrdersAndDisplayAllDataOrderInTheResponseBody() {
        order.successToGetAllProducts();
    }




    //TC_Orders_06 - Get all orders [Negative]

    @When("User request method GET and click Send Button to get all orders")
    public void userRequestMethodGETAndClickSendButtonToGetAllOrders() {
        order.userRequestPOSTMethodWithInvalidEndpoint();
    }

    @Then("Validate failed to get all orders and display message {string} in the response body")
    public void validateFailedToGetAllOrdersAndDisplayMessageInTheResponseBody(String failedGetAllOrders) {
        order.failedGetAllOrdersBecauseInvalidEndpoint("not found");
    }





    //TC_Orders_07 - Get order by iD [Positive]
    
    @Given("User input endpoint with valid id orders")
    public void userInputEndpointWithValidIdOrders() {
        order.userInputEndpointWithValidIDOrders();
    }

    @When("User request HTTP method GET and click Send Button to get the orders")
    public void userRequestHTTPMethodGETAndClickSendButtonToGetTheOrders() {
        order.userRequestHTTPGETMethodWithValidEndpoint();
        
    }

    @Then("Validate success to get the orders and display detail data order in the response body")
    public void validateSuccessToGetTheOrdersAndDisplayDetailDataOrderInTheResponseBody() {
        order.successToGetProductByID();
    }





    //TC_Orders_08 - Get order by iD [Negative]

    @Given("User input endpoint with invalid id orders")
    public void userInputEndpointWithInvalidIdOrders() {
        order.userInputEndpointWithInvalidIDOrders();
    }

    @When("User request the HTTP method GET and click Send Button to get the orders")
    public void userRequestTheHTTPMethodGETAndClickSendButtonToGetTheOrders() {
        order.userRequestTheHTTPGETMethodWithValidEndpoint();
    }

    @Then("Validate failed to get the orders and display error message {string} in the response body")
    public void validateFailedToGetTheOrdersAndDisplayErrorMessageInTheResponseBody(String failedToGetOrderByID) {
        order.failedToGetOrderByIDBecauseInvalidID("record not found");
    }
}
