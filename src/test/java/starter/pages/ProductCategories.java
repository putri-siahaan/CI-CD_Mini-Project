package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class ProductCategories {
    protected static String url = "https://altashop-api.fly.dev/api/";

    //TC_Products_01 - Get All Product [Positive 1]
    @Step("User input valid Endpoint with categories")
    public String userInputValidEndpointWithCategories(){
        return url + "categories";
    }

    @Step("User request HTTP method POST and input data of a new category with valid data in the request body and click Send Button to send a request")
    public void userRequestPOSTMethodAndInputWithValidDataCategory() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Laptop");
        requestBody.put("description", "Intel(R) Core(TM) i5-8250U CPU @ 1.60GHz 1.80 GHz");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointWithCategories());
    }

    @Step("Validate success to create new category and display detail all products in the response body")
    public void successToCreateNewCategory(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }



    //TC_Category_02 - Create a category [Positive 2]

    @Step("User request HTTP method POST and data of description is empty in the request body and click Send Button to send a request")
    public void userRequestPOSTMethodWithDataDescriptionIsEmpty() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Laptop");
        requestBody.put("description", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointWithCategories());
    }

    @Step("Validate success to create new category and display detail all products in the response body but data of description is empty")
    public void successToCreateNewCategoryWithDescriptionIsEmpty(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }





    //TC_Category_03 - Create a category [Negative 1]

    @Step("User request method POST and input data of a new category with invalid name in the request body and click Send Button to send a request")
    public void userRequestPOSTMethodWithInvalidName() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("description", "Intel(R) Core(TM) i5-8250U CPU @ 1.60GHz 1.80 GHz");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointWithCategories());
    }

    @Step("Validate failed create a new category and display error message {string} in the response body")
    public void failedToCreateNewCategoryWithInvalidName(String errorInvalidName){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 500 && responseBody.contains(errorInvalidName)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Category_04 - Create a category [Negative 2]

    @Step("User request method POST and input data of a new category with invalid description in the request body and click Send Button to send a request")
    public void userRequestPOSTMethodWithInvalidDescription() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Laptop");
        requestBody.put("description", 3);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointWithCategories());
    }

    @Step("Validate failed to create new category and display error message {string} in the response body")
    public void failedToCreateNewCategoryWithInvalidDescription(String errorInvalidDescription){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(errorInvalidDescription)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Category_05 - Get category by ID [Positive]

    @Step("User input endpoint with valid ID to get Category")
    public String userInputEndpointWithValidIDToGetCategory(){
        return url + "categories/30114";
    }

    @Step("User request HTTP method GET and click Send Button")
    public void userRequestGETMethodAndClickSendButton() {
        SerenityRest.given().header("Content-Type", "application/json").get(userInputEndpointWithValidIDToGetCategory());
    }

    @Step("Validate success to get category by ID and display detail data of category in the response body")
    public void successToGetCategoryByValidID(){
        restAssuredThat(response -> response.body("data.ID", equalTo(30114)));
        restAssuredThat(response -> response.body("data.Name", equalTo("Laptop")));
        restAssuredThat(response -> response.body("data.Description", equalTo("Intel(R) Core(TM) i5-8250U CPU @ 1.60GHz 1.80 GHz")));
    }



    //TC_Category_06 - Get category by ID [Negative]

    @Step("User input invalid Endpoint to get category")
    public String userInputEndpointWithInvalidIDToGetCategory(){
        return url + "categories/1";
    }

    @Step("User request with the HTTP method GET and click Send Button")
    public void userRequestGetMethodAndClickSendButton() {
        SerenityRest.given().header("Content-Type", "application/json").get(userInputEndpointWithInvalidIDToGetCategory());
    }

    @Step("Validate failed to get category and display error message {string} in the response body")
    public void failedToGetCategoryBecauseInvalidID(String failedGetCategory){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedGetCategory)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Category_07 - Get all categories [Positive]

    @Step("User request with the HTTP method GET and click Send Button to get all categories")
    public void userRequestGETMethodToGetAllCategories() {
        SerenityRest.given().header("Content-Type", "application/json").get(userInputValidEndpointWithCategories());
    }

    @Step("Validate success to get all category and display detail data in the response body")
    public void successToGetAllCategory(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }




    //TC_Category_08 - Get all categories [Negative]

    @Step("User input invalid Endpoint with category")
    public String userInputInvalidEndpointWithCategory(){
        return url + "category";
    }

    @Step("User request method HTTP GET and click Send Button to get all categories")
    public void userRequestGetMethodCaseNegative() {
        SerenityRest.given().header("Content-Type", "application/json").get(userInputInvalidEndpointWithCategory());
    }

    @Step("Validate failed to get all category and display error message {string} in the response body")
    public void failedToGetAllCategoryBecauseInvalidEndpoint(String failedGetAllCategory){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedGetAllCategory)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Category_09 - Delete a category [Positive]

    @Step("User input Endpoint with valid ID=30000")
    public String userInputEndpointWithValidID30000(){
        return url + "categories/30000";
    }

    @Step("User request DELETE method and click Send Button to remove the categories")
    public void userRequestDELETEMethodToRemoveCategories() {
        SerenityRest.given().header("Content-Type", "application/json").delete(userInputEndpointWithValidID30000());
    }

    @Step("Validate success to delete a category and display message {string} in the response body")
    public void successToDeleteCategoryBecauseValidEndpoint(String successDeleteCategory){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 200 && responseBody.contains(successDeleteCategory)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }






    //TC_Category_10 - Delete a category [Negative]

    @Step("User input Endpoint with invalid ID to delete a category")
    public String userInputEndpointWithInvalidID(){
        return url + "categories/ 30000";
    }

    @Step("User request DELETE method and click send button")
    public void userRequestDELETEMethodCaseNegative() {
        SerenityRest.given().header("Content-Type", "application/json").delete(userInputEndpointWithInvalidID());
    }

    @Step("Validate failed to delete a category and display error message {string} in the response body")
    public void failedToDeleteCategoryBecauseInvalidEndpoint(String failedDeleteCategory){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedDeleteCategory)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }

}
