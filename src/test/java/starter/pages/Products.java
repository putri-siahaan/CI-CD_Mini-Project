package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Products {
    protected static String url = "https://altashop-api.fly.dev/api/";

    //TC_Products_01 - Get All Product [Positive]
    @Step("User input valid Endpoint")
    public String userInputValidEndpoint(){
        return url + "products";
    }

    @Step("User request with the HTTP method GET and click Send Button to send a request")
    public void userRequestHttpMethodGet(){
        SerenityRest.given()
                .when()
                .get(userInputValidEndpoint());
    }

    @Step("User receive a response with status code 200 OK")
    public void receiveHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("Validate success receive detail all products in the response body")
    public void validateDataUser(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }




    //TC_Products_02 - Get All Product [Negative]


    @Step("User input invalid Endpoint")
    public String userInputInvalidEndpoint(){
        return url + "product";
    }

    @Step("User request HTTP method GET and click Send Button to send a request")
    public void requestHttpMethodGet(){
        SerenityRest.given()
                .when()
                .get(userInputInvalidEndpoint());
    }

    @Step("User receive a response with status code is 404 Not Found")
    public void receiveHttpResponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("Validate failed receive detail all products and display message {string} in the response body")
    public void validateFailedReceiveDetailAllProducts(String messageResponse404){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(messageResponse404)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



    //TC_Products_03 - Create a New Product [Positive]

    @Step("User request with the HTTP method POST and input data of a new product with valid data in the request body and click Send Button to send a request")
    public void requestHttpMethodPostCreateProductWithValidEndpoint(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Lenovo");
        requestBody.put("description", "laptop");
        requestBody.put("price", 8000000);
        // Membuat array JSON untuk categories
        JSONArray categories = new JSONArray();
        categories.add(1);
        categories.add(2);
        categories.add(3);

        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpoint());
    }

    @Step("Validate success to create new product and display detail all products in the response body")
    public void validateSuccessCreateNewProduct(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }



    //TC_Products_04 - Create a New Product [Negative1]

    @Step("User request with HTTP method POST and input data with invalid name of the new products in the request body and click Send Button to send a request")
    public void requestHttpMethodPostCreateProductWithInvalidName(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("description", "laptop");
        requestBody.put("price", 8000000);
        // Membuat array JSON untuk categories
        JSONArray categories = new JSONArray();
        categories.add(1);
        categories.add(2);
        categories.add(3);

        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpoint());
    }

    @Step("User receive a response with status code 500 Internal Server Error")
    public void receiveHttpResponseCode500(){
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("Validate failed to create a new product and display error message {string} in the response body")
    public void validateFailedCreateNewProduct(String errorName){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(errorName)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Products_05 - Create a New Product [Negative2]

    @Step("User request with HTTP method POST and input data of a new product with invalid description in the request body and click Send Button to send a request")
    public void requestHttpMethodPostCreateProductWithInvalidDescription(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Lenovo");
        requestBody.put("description", 2);
        requestBody.put("price", 8000000);
        // Membuat array JSON untuk categories
        JSONArray categories = new JSONArray();
        categories.add(1);
        categories.add(2);
        categories.add(3);

        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpoint());
    }

    @Step("User receive a response with status code 400 Bad Request")
    public void receiveHttpResponseCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("Validate failed create a new product and display error message {string} in the response body")
    public void validateFailedCreateNewProductBecauseInvalidDescription(String errorDescription){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(errorDescription)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Products_06 - Create a New Product [Negative3]

    @Step("User request with HTTP method POST and input data of a new product with invalid price in the request body and click Send Button to send a request")
    public void requestHttpMethodPostCreateProductWithInvalidPrice(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Lenovo");
        requestBody.put("description", "laptop");
        requestBody.put("price", "8.000.000");
        // Membuat array JSON untuk categories
        JSONArray categories = new JSONArray();
        categories.add(1);
        categories.add(2);
        categories.add(3);

        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpoint());
    }

    @Step("Validate failed to create new product and display error message {string} in the response body")
    public void validateFailedCreateNewProductBecauseInvalidPrice(String errorPrice){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(errorPrice)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



    //TC_Products_07 - Create a New Product [Negative 4]

    @Step("User request with HTTP method POST and input data of a new product with invalid categories in the request body and click Send Button to send a request")
    public void requestHttpMethodPostCreateProductWithInvalidCategories(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Lenovo");
        requestBody.put("description", "laptop");
        requestBody.put("price", 8000000);
        // Membuat array JSON untuk categories
        JSONArray categories = new JSONArray();
        categories.add("Laptop");
        categories.add("Electronics");
        categories.add("Computer Hardware");

        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpoint());
    }

    @Step("Validate failed create new product and display error message {string} in the response body")
    public void validateFailedCreateNewProductBecauseInvalidCategories(String errorCategories){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(errorCategories)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



    //TC_Products_08 - Create a New Product [Negative 5]

    @Step("User request with the HTTP method POST and input data of a new product with valid data and click Send Button to send a request")
    public void requestHttpMethodPostCreateProductWithInvalidEndpoint(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Lenovo");
        requestBody.put("description", "laptop");
        requestBody.put("price", 8000000);
        // Membuat array JSON untuk categories
        JSONArray categories = new JSONArray();
        categories.add(1);
        categories.add(2);
        categories.add(3);

        requestBody.put("categories", categories);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputInvalidEndpoint());
    }

    @Step("Validate failed to create new a product and display error message {string} in the response body")
    public void validateFailedCreateNewProductBecauseInvalidEndpoint(String errorInvalidEndpoint){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(errorInvalidEndpoint)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Products_09 - Get Product By ID [Positive]

    @Step("User input Endpoint with valid ID 86235")
    public String userInputValidEndpoint86235(){
        return url + "products/86235";
    }

    @Step("User is request with HTTP method GET and click Send Button to send a request")
    public void requestHttpMethodPostButtonToSendRequest(){
        SerenityRest.given()
                .when()
                .get(userInputValidEndpoint86235());
    }

    @Step("Validate success to get the data with ID=86235 and display detail pf the products in the response body")
    public void validateSuccessToGetProductByID(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }




    //TC_Products_10 - Get product By ID [Negative]

    @Step("User input endpoint with invalid ID = 100000")
    public String userInputInvalidID100000(){
        return url + "products/100000";
    }

    @Step("User request data with HTTP method GET and click Send Button to send a request")
    public void requestHttpMethodGetButtonToSendRequest(){
        SerenityRest.given()
                .when()
                .get(userInputInvalidID100000());
    }

    @Step("Validate failed execution and display error message {string} in the response body")
    public void validateFailedExecutionRecordNotFound(String errorRecordNotFound){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(errorRecordNotFound)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



    //TC_Products_11 - Delete a Product [Positive]

    @Step("User input endpoint with valid ID to Delete a product")
    public String userInputValidIDToDeleteProduct(){
        return url + "products/86001";
    }

    @Step("User request with the HTTP method DELETE and click Send Button to send a request")
    public void requestHttpMethodDeleteButtonToRemoveProduct(){
        SerenityRest.given()
                .when()
                .delete(userInputValidIDToDeleteProduct());
    }

    @Step("Validate success to delete the product and display message {string} data in the response body")
    public void validateSuccessToDeleteProduct(String successDelete){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 200 && responseBody.contains(successDelete)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Products_12 - Delete a Product [Negative]

    @Step("User input endpoint with the invalid ID = 0")
    public String userInputInvalidIDToDeleteProduct(){
        return url + "products/0";
    }

    @Step("User request with the HTTP method DELETE and click Send Button to send request")
    public void requestHttpMethodDeleteButtonCaseNegative(){
        SerenityRest.given()
                .when()
                .delete(userInputInvalidIDToDeleteProduct());
    }

    @Step("Validate success to delete the product and display error message {string} in the response body")
    public void validateFailedToDeleteProduct(String failedDelete){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(failedDelete)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Products_13 - Assign a product rating [Positive]

    @Step("User input Endpoint with valid ID 86235 in case rating")
    public String userInputValidIDToAssignRatingProduct(){
        return url + "products/86235/ratings";
    }

    @Step("User request with the method HTTP POST and input valid count of the star is 3 in the request body and click Send Button to send request")
    public void requestHttpMethodPostAndInputRating3(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 3);

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputValidIDToAssignRatingProduct()).then().statusCode(200);

    }
    @Step("Validate success to assign rating and display detail products that have been rated in the response body")
    public void validateSuccessAssignRating(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }




    //TC_Products_14 - Assign a product rating [Positive 2]

    @Step("User request with the method HTTP POST and input valid count of the star is 0 in the request body and click Send Button to send request")
    public void requestHttpMethodPostAndInputRating0(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 0);

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputValidIDToAssignRatingProduct()).then().statusCode(200);

    }
    @Step("Validate success to assign ratings and display detail products that have been rated in the response body")
    public void validateSuccessAssignRating0(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }





    //TC_Products_15 - Assign a product rating [Negative 1]

    @Step("User input endpoint with invalid ID to assign rating")
    public String userInputEndpointWithInvalidIDToAssignRatingProduct(){
        return url + "products/1/ratings";
    }

    @Step("User request with method HTTP POST and input valid count of the stars in the request body and click Send Button to send request")
    public void requestHttpMethodPostWithInvalidID(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputEndpointWithInvalidIDToAssignRatingProduct()).then().statusCode(500);

    }
    @Step("Validate failed execution and display message {string} in the response body")
    public void validateFailedToAssignRatingBecauseInvalidID(String failedAssignBecauseInvalidID){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(failedAssignBecauseInvalidID)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Products_16 - Assign a product rating [Negative 2]

    @Step("User request with method HTTP POST and input invalid count of the stars to be assigned and click Send Button to send request")
    public void requestHttpMethodPostWithInvalidCount(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 10);

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputValidIDToAssignRatingProduct()).then().statusCode(500);

    }
    @Step("Validate failed to assign ratings and display message {string} in the response body")
    public void validateFailedToAssignRatingBecauseInvalidCount(String failedAssignBecauseInvalidCount){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(failedAssignBecauseInvalidCount)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Products_17 - Get product ratings [Positive]

    @Step("User request with method HTTP GET and click Send Button to send request")
    public void requestHttpMethodGETtoGetProductRatings(){

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").get(userInputValidIDToAssignRatingProduct()).then().statusCode(200);
    }
    @Step("Validate success to get product ratings and display data=3 in the response body")
    public void validateSuccessGetProductRatings(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }




    //TC_Products_18 - Get product ratings [Negative]

    @Step("User input endpoint with invalid ID to get product ratings")
    public String userInputEndpointWithValidIDToGetProductRatings(){
        return url + "products/-1/ratings";
    }

    @Step("User request method HTTP GET and click Send Button")
    public void requestHttpMethodGETWithInvalidID(){

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").get(userInputEndpointWithValidIDToGetProductRatings()).then().statusCode(500);

    }
    @Step("Validate failed to get product ratings and display error message {string} in the response body")
    public void validateFailedToGetProductRatingsBecauseInvalidID(String failedGetProductRatingBecauseInvalidID){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(failedGetProductRatingBecauseInvalidID)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Products_19 - Create a comment for product [Positive 1]

    @Step("User input a valid endpoint to create comments")
    public String userInputEndpointValidEndpointToCreateComment(){
        return url + "products/86235/comments";
    }

    @Step("User request method HTTP POST and input a comment containing a sentence and click Send Button to send request")
    public void requestHttpMethodPOSTWithValidID(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "Laptopnya sangat bagus dan tahan lama");

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputEndpointValidEndpointToCreateComment()).then().statusCode(200);

    }
    @Step("Validate success to create comment for product and display detail of the product with the comment in the response body")
    public void validateSuccessCreateCommentWithValidID(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }



    //TC_Products_20 - Create a comment for product [Positive 2]

    @Step("User request method HTTP POST and input comment of a product with only space and click Send Button to send request")
    public void requestHttpMethodPOSTWithInputOnlySpace(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", " ");

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputEndpointValidEndpointToCreateComment()).then().statusCode(200);

    }
    @Step("Validate success to create comment for product and display detail product with the comment in the response body")
    public void validateSuccessToCreateCommentWithValidID(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }




    //TC_Products_21 - Create a comment for product [Negative 1]

    @Step("User input invalid Endpoint in the field")
    public String userInputInvalidEndpointInTheField(){
        return url + "products/ 86235/comments";
    }

    @Step("User request method HTTP POST and input valid comment of a product and click Send Button")
    public void requestHttpMethodPOSTWithValidComment(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "Laptopnya sangat bagus dan tahan lama");

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputInvalidEndpointInTheField()).then().statusCode(404);

    }

    @Step("Validate failed to create comment for product and display message {string} in the response body")
    public void validateFailedToCreateCommentBecauseInvalidID(String failedCreateCommentBecauseInvalidID){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedCreateCommentBecauseInvalidID)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }


    //TC_Products_22 - Create a comment for product [Negative 2]

    @Step("User input Valid Endpoint in the field")
    public String userInputValidEndpointInTheField(){
        return url + "products/2/comments";
    }

    @Step("User request method HTTP POST and input invalid comment of a product and click Send Button")
    public void requestHttpMethodPOSTWithInvalidComment(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "");

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").body(requestBody.toJSONString()).post(userInputValidEndpointInTheField()).then().statusCode(500);

    }

    @Step("Validate failed to create comment for product and display error message {string} in the response body")
    public void validateFailedToCreateCommentBecauseInvalidContent(String failedCreateCommentBecauseInvalidContent){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(failedCreateCommentBecauseInvalidContent)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Products_23 - Get product comments [Positive]

    @Step("User request method GET and click Send Button")
    public void requestHttpMethodGETWithValidID(){

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").get(userInputValidEndpointInTheField()).then().statusCode(200);

    }

    @Step("Validate success to get product comment for product and display detail of the product with the comment in the response body")
    public void validateToGetProductCommentWithValidID(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }





    //TC_Products_24 - Get product comments [Negative]

    @Step("User input a invalid Endpoint in the field")
    public String userInputInvalidEndpointSoFailedGetProductComments(){
        return url + "products/ 2/comments";
    }

    @Step("User request http method GET and click Send Button")
    public void requestHttpMethodGETWithInvalidIDIs2(){

        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").get(userInputInvalidEndpointSoFailedGetProductComments()).then().statusCode(404);

    }

    @Step("Validate failed to get product comment for product and display message {string} in the response body")
    public void validateFailedToGetProductCommentBecauseInvalidID(String failedGetProductCommentBecauseInvalidID){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedGetProductCommentBecauseInvalidID)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }
}
