package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class Hello {

    protected static String url = "https://altashop-api.fly.dev/api/";



    //TC_Hello_01 - Index [Positive]

    @Step("User input endpoint hello")
    public String userInputEndpointHello(){
        return url + "hello";
    }

    @Step("User request HTTP method GET in the request body and click Send Button")
    public void userRequestGETMethodToGetIndex(){
        SerenityRest.given().header("Content-Type", "application/json").get(userInputEndpointHello());
    }

    @Step("Validate success to see data {string} in the response body")
    public void successToSeeTheIndex(String successGetIndex){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 200 && responseBody.contains(successGetIndex)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }






    //TC_Hello_02 - Index [Negative]

    @Step("User input endpoint hai")
    public String userInputEndpointHai(){
        return url + "hai";
    }

    @Step("User request HTTP method Get in the request body and click Send Button")
    public void userRequestGETMethodToGetIndexCaseNegative(){
        SerenityRest.given().header("Content-Type", "application/json").get(userInputEndpointHai());
    }

    @Step("Validate failed to see data hai and display message {string} in the response body")
    public void failedToSeeTheIndex(String failedGetIndex){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedGetIndex)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




}
