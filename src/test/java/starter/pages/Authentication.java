package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Authentication {

    protected static String url = "https://altashop-api.fly.dev/api/";




    //TC_Authentication_01 - Register [Positive]

    @Step("User input valid endpoint to create account")
    public String userInputValidEndpointToCreateAccount(){
        return url + "auth/register";
    }

    @Step("User request HTTP method POST in the request body and input valid email, password, fullname, and click Send Button")
    public void userRequestPOSTMethodAndInputWithValidDataAccount(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anaruth_shn12@gmail.com");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate success to create account and display detail account in the response body")
    public void successToCreateAccount(){
        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Fullname", equalTo("Ana Siahaan")));
        restAssuredThat(response -> response.body("data.Email", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Password", equalTo("siahaan123")));
    }





    //TC_Authentication_02 - Register [Negative 1]

    @Step("User request HTTP method POST in the request body and input email already exists and click Send Button")
    public void userRequestPOSTMethodAndInputEmailAlreadyExists(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan@gmail.com");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account and display error message {string} in the response body")
    public void failedToCreateAccountBecauseEmailAlreadyExists(String failedCreateAccount){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedCreateAccount)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Authentication_03 - Register [Negative 2]

    @Step("User request HTTP method POST and did not input email in the request body and click Send Button")
    public void userRequestPOSTMethodAndDidNotInputEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because did not input email and display error message {string} in the response body")
    public void failedToCreateAccountBecauseDidNotInputEmail(String failedBecauseDidNotInputEmail){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseDidNotInputEmail)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }






    //TC_Authentication_04 - Register [Negative 3]

    @Step("User request HTTP method POST and did not input password in the request body and click Send Button")
    public void userRequestPOSTMethodAndDidNotInputPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anaruthshn27@gmail.com");
        requestBody.put("password", "");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because did not input password and display error message {string} in the response body")
    public void failedToCreateAccountBecauseDidNotInputPassword(String failedBecauseDidNotInputPassword){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseDidNotInputPassword)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Authentication_05 - Register [Negative 4]

    @Step("User request HTTP method POST and did not input fullname in the request body and click Send Button")
    public void userRequestPOSTMethodAndDidNotInputFullname(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anaruthshn27@gmail.com");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because did not input fullname and display error message {string} in the response body")
    public void failedToCreateAccountBecauseDidNotInputFullname(String failedBecauseDidNotInputFullname){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseDidNotInputFullname)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Authentication_06 - Register [Negative 5]

    @Step("User request HTTP method POST and input invalid email in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputInvalidEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "ana#__12345678");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because input invalid email and display error message in the response body")
    public void failedToCreateAccountBecauseInputInvalidEmail(String failedBecauseInvalidEmail){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseInvalidEmail)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Authentication_07 - Register [Negative 6]

    @Step("User request HTTP method POST and input invalid password in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputInvalidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anashnruth@gmail.com");
        requestBody.put("password", 2703);
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because input invalid password and display error message {string} in the response body")
    public void failedToCreateAccountBecauseInputInvalidPassword(String failedBecauseInvalidPassword){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseInvalidPassword)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }






    //TC_Authentication_08 - Register [Negative 7]

    @Step("User request HTTP method POST and input invalid fullname in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputInvalidFullname(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anashnruth@gmail.com");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", 7);

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because input invalid fullname and display error message {string} in the response body")
    public void failedToCreateAccountBecauseInputInvalidFullname(String failedBecauseInvalidFullname){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseInvalidFullname)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Authentication_09 - Register [Negative 8]

    @Step("User request HTTP method POST and input email with a space in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputEmailWithSpace(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "                                                           ");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because input email with a space and display {string} in the response body")
    public void failedToCreateAccountBecauseInputEmailWithSpace(String failedBecauseEmailWithSpace){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseEmailWithSpace)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Authentication_10 - Register [Negative 9]

    @Step("User request HTTP method POST and input password with a space in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputPasswordWithSpace(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anashn273#_____@gmail.com");
        requestBody.put("password", "  ");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because input password with a space and display {string} in the response body")
    public void failedToCreateAccountBecauseInputPasswordWithSpace(String failedBecausePasswordWithSpace){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecausePasswordWithSpace)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Authentication_11 - Register [Negative 10]

    @Step("User request HTTP method POST and input fullname with a space in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputFullnameWithSpace(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anashn27320#______@gmail.com");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "  ");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because input fullname with a space and display {string} in the response body")
    public void failedToCreateAccountBecauseInputFullnameWithSpace(String failedBecauseFullnameWithSpace){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedBecauseFullnameWithSpace)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Authentication_12 - Register [Negative 11]

    @Step("User input invalid endpoint to create account")
    public String userInputInvalidEndpointToCreateAccount(){
        return url + "auth/registers";
    }


    @Step("User request HTTP method POST and input valid data in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputValidData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anashn-949597@gmail.com");
        requestBody.put("password", "siahaan123");
        requestBody.put("fullname", "Ana Siahaan");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputInvalidEndpointToCreateAccount());
    }

    @Step("Validate failed to create account because invalid endpoint and display {string} in the response body")
    public void failedToCreateAccountBecauseInputInvalidEndpoint(String failedBecauseInvalidEndpoint){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedBecauseInvalidEndpoint)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }






    //TC_Authentication_13 - Login [Positive]

    @Step("User input valid endpoint to login")
    public String userInputValidEndpointToLogin(){
        return url + "auth/login";
    }


    @Step("User request HTTP method POST and input valid email and valid password in the request body and click Send Button")
    public void userRequestPOSTMethodAndInputValidEmailAndPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan@gmail.com");
        requestBody.put("password", "siahaan123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because input valid endpoint and valid account and display token in the response body")
    public void successToLoginBecauseInputValidEndpointSNdAccount(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }





    //TC_Authentication_14 - Login [Negative 1]

    @Step("User input invalid endpoint to login")
    public String userInputInvalidEndpointToLogin(){
        return url + "auth/Login";
    }

    @Step("User request HTTP method POST and input valid email and valid password in request body and click Send Button")
    public void userRequestPostMethodAndInputValidData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan@gmail.com");
        requestBody.put("password", "siahaan123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputInvalidEndpointToLogin());
    }

    @Step("Validate failed to login because input invalid endpoint and display error message {string} in the response body")
    public void failedToLoginBecauseInputInvalidEndpoint(String failedLoginBecauseInvalidEndpoint){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedLoginBecauseInvalidEndpoint)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Authentication_15 - Login [Negative 2]

    @Step("User request HTTP method POST and input invalid email in request body and click Send Button")
    public void userRequestPOSTMethodToLoginAndInputInvalidEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan94@gmail.com");
        requestBody.put("password", "siahaan123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because input invalid email and display error message {string} in the response body")
    public void failedToLoginBecauseInputValidEndpointAndAccount(String failedLoginBecauseInvalidEmail){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedLoginBecauseInvalidEmail)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }




    //TC_Authentication_16 - Login [Negative 3]

    @Step("User request HTTP method POST and input invalid password in request body and click Send Button")
    public void userRequestPOSTMethodToLoginAndInputInvalidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan@gmail.com");
        requestBody.put("password", "siahaan12345");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because input invalid password and display error message {string} in the response body")
    public void failedToLoginBecauseInputInvalidPassword(String failedLoginBecauseInvalidPassword){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedLoginBecauseInvalidPassword)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }





    //TC_Authentication_17 - Login [Negative 4]

    @Step("User request HTTP method POST and input invalid email and password in request body and click Send Button")
    public void userRequestPOSTMethodToLoginAndInputInvalidEmailAndPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan94@gmail.com");
        requestBody.put("password", "siahaan12345");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because input invalid email and password and display error message {string} in the response body")
    public void failedToLoginBecauseInputInvalidEmailAndPassword(String failedLoginBecauseInvalidEmailAndPassword){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedLoginBecauseInvalidEmailAndPassword)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }






    //TC_Authentication_18 - Login [Negative 5]

    @Step("User request HTTP method POST and did not input email in request body and click Send Button")
    public void userRequestPOSTMethodToLoginAndDidNotInputEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "siahaan123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because did not input email and display error message {string} in the response body")
    public void failedToLoginBecauseDidNotInputEmail(String failedLoginBecauseDidNotInputEmail){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedLoginBecauseDidNotInputEmail)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



    // TC_Authentication_19 - Login [Negative 6]
    @Step("User request HTTP method POST and did not input password in request body and click Send Button")
    public void userRequestPOSTMethodToLoginAndDidNotInputPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "anasiahaan@gmail.com");
        requestBody.put("password", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because did not input password and display error message {string} in the response body")
    public void failedToLoginBecauseDidNotInputPassword(String failedLoginBecauseDidNotInputPassword){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedLoginBecauseDidNotInputPassword)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }







    //TC_Authentication_20 - Login [Negative 7]
    @Step("User request HTTP method POST and did not input email and password in request body and click Send Button")
    public void userRequestPOSTMethodToLoginAndDidNotInputEmailAndPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(userInputValidEndpointToLogin());
    }

    @Step("Validate failed to login because did not input email and password and display error message {string} in the response body")
    public void failedToLoginBecauseDidNotInputEmailAndPassword(String failedLoginBecauseDidNotInputEmailAndPassword){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 400 && responseBody.contains(failedLoginBecauseDidNotInputEmailAndPassword)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }
    }



    //TC_Authentication_21 - Get User Information [Positive]

    @Step("User input valid endpoint to get user information")
    public String userInputValidEndpointToGetUserInformation(){
        return url + "auth/info";
    }
    @Step("User request HTTP method GET to get user information and click Send Button")
    public void userRequestTheGETMethodToGetUserInformationCasePositive(){
        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").get(userInputValidEndpointToGetUserInformation()).then().statusCode(200);
    }

    @Step("Validate success to get user information and display information the account in the response body")
    public void successToGetUserInformation(){
        restAssuredThat(response -> response.body("$", notNullValue()));
    }





    //TC_Authentication_22 - Get User Information [Negative]

    @Step("User input invalid endpoint to get user information")
    public String userInputInvalidEndpointToGetUserInformation(){
        return url + "auth/Info";
    }
    @Step("User request a method HTTP GET and click Send Button")
    public void userRequestGETMethodCaseNegative(){
        SerenityRest.given().header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkFuYSBTaWFoYWFuIiwiRW1haWwiOiJhbmFzaWFoYWFuQG1haWwuY29tIn0.VeR1mxjEbpK8Xtw8L98h7stsaS9kB3EAuVeQ2EqeLKw").get(userInputInvalidEndpointToGetUserInformation()).then().statusCode(404);
    }

    @Step("Validate failed to get user information and display error message {string} in the response body")
    public void failedToGetUserInformationBecauseInvalidEndpoint(String failedToGetUserInformation){
        Response response = SerenityRest.then().extract().response();
        String responseBody = response.asString();

        if (response.getStatusCode() == 404 && responseBody.contains(failedToGetUserInformation)) {
            // Validasi berhasil, pesan sesuai dengan yang diharapkan
        } else {
            // Validasi gagal
            throw new AssertionError("Response did not match the expected message.");
        }    }

}
