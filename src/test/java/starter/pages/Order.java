package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Order {
    protected static String url = "https://altashop-api.fly.dev/api/";

    //TC_Orders_01 - Create a new order [Positive]

    @Step("User input valid endpoint orders")
    public String userInputValidEndpointOrders(){
        return url + "orders";
    }

    @Step("User request HTTP method POST and input valid product id and quantity in the request body and click Send Button")
    public void userRequestPOSTMethodWithValidProductIDAndQuantity(){
        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 86235);
        orderItem.put("quantity", 3);
        orderItems.add(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();

        orderCreate.put("order_items", orderItems);
        requestBody.add(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(userInputValidEndpointOrders());
    }

    @Step("Validate success to order and display detail data order in the response body")
    public void successToOrder(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }





    //TC_Orders_02 - Create a new order [Negative 1]

    @Step("User request HTTP method POST and input invalid product id in the request body and click Send Button")
    public void userRequestPOSTMethodWithInvalidProductID(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("product_id", 2.5);
        requestBody.put("quantity", 1);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .body(requestBody.toJSONString())
                .post(userInputValidEndpointOrders()).then().statusCode(400);
    }

    @Step("Validate failed to order and display error message {string} in the response body")
    public void failedToOrderBecauseInvalidProductID(String failedCase1){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedCase1)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }







    //TC_Orders_03 - Create a new order [Negative 2]

    @Step("User request HTTP method POST and input invalid quantity in the request body and click Send Button")
    public void userRequestPOSTMethodWithInvalidQuantity(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("product_id", 2);
        requestBody.put("quantity", 3.5);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .body(requestBody.toJSONString())
                .post(userInputValidEndpointOrders()).then().statusCode(400);
    }

    @Step("Validate failed to order because invalid quantity and display error message {string} in the response body")
    public void failedToOrderBecauseInvalidQuantity(String failedCase2){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedCase2)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Orders_04 - Create a new order [Negative 3]

    @Step("User input invalid endpoint orders")
    public String userInputInvalidEndpointOrders(){
        return url + "order";
    }

    @Step("User request HTTP method POST and input valid quantity and product id in the request body and click Send Button")
    public void userRequestPOSTMethodWithValidQuantityAndProductID(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("product_id", 2);
        requestBody.put("quantity", 1);

        SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .body(requestBody.toJSONString())
                .post(userInputInvalidEndpointOrders()).then().statusCode(404);
    }

    @Step("Validate failed to order because invalid endpoint and display error message {string} in the response body")
    public void failedToOrderBecauseInvalidEndpoint(String failedCase3){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedCase3)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Orders_05 - Get all orders [Positive]

    @Step("User request HTTP method GET and click Send Button to get all orders")
    public void userRequestGETMethodWithValidEndpoint(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .get(userInputValidEndpointOrders()).then().statusCode(200);
    }

    @Step("Validate success to get all orders and display all data order in the response body")
    public void successToGetAllProducts(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }






    //TC_Orders_06 - Get all orders [Negative]

    @Step("User request method GET and click Send Button to get all orders")
    public void userRequestPOSTMethodWithInvalidEndpoint(){
               SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .get(userInputInvalidEndpointOrders()).then().statusCode(404);
    }

    @Step("Validate failed to get all orders and display message {string} in the response body")
    public void failedGetAllOrdersBecauseInvalidEndpoint(String failedGetAllOrders){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedGetAllOrders)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Orders_07 - Get order by iD [Positive]

    @Step("User input endpoint with valid id orders")
    public String userInputEndpointWithValidIDOrders(){
        return url + "orders/12305";
    }

    @Step("User request HTTP method GET and click Send Button to get the orders")
    public void userRequestHTTPGETMethodWithValidEndpoint(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .get(userInputEndpointWithValidIDOrders()).then().statusCode(200);
    }

    @Step("Validate success to get the orders and display detail data order in the response body")
    public void successToGetProductByID(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }








    //TC_Orders_08 - Get order by iD [Negative]

    @Step("User input endpoint with invalid id orders")
    public String userInputEndpointWithInvalidIDOrders(){
        return url + "orders/86235";
    }

    @Step("User request the HTTP method GET and click Send Button to get the orders")
    public void userRequestTheHTTPGETMethodWithValidEndpoint(){
        SerenityRest
                .given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw")
                .get(userInputEndpointWithInvalidIDOrders()).then().statusCode(404);
    }

    @Step("Validate failed to get the orders and display error message {string} in the response body")
    public void failedToGetOrderByIDBecauseInvalidID(String failedGetOrderByID){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedGetOrderByID)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



}
