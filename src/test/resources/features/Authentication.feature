Feature: Authentication

  As a user
  I want to register
  So that I will hava a account to login

#  @TC_Authentication_01 @Register
#  Scenario: Register - Verify success to create new account with valid endpoint and request body
#    Given User input valid endpoint to create account
#    When User request HTTP method POST in the request body and input valid email, password, fullname, and click Send Button
#    And User receive a response with status code 200 OK
#    Then Validate success to create account and display detail account in the response body


  @TC_Authentication_02
  Scenario: Register - Verify failed to create new account because email the registered account already exists
    Given User input valid endpoint to create account
    When User request HTTP method POST in the request body and input email already exists and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create account and display error message "duplicate key value violates unique constraint \"users_email_key\" (SQLSTATE 23505)" in the response body


  @TC_Authentication_03
  Scenario: Register - Verify failed to create new account because email is empty
    Given User input valid endpoint to create account
    When User request HTTP method POST and did not input email in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create account because did not input email and display error message "email is required" in the response body


  @TC_Authentication_04
  Scenario: Register - Verify failed to create new account because password is empty
    Given User input valid endpoint to create account
    When User request HTTP method POST and did not input password in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create account because did not input password and display error message "password is required" in the response body


  @TC_Authentication_05
  Scenario: Register - Verify failed to create new account because fullname field is empty
    Given User input valid endpoint to create account
    When User request HTTP method POST and did not input fullname in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create account because did not input fullname and display error message "fullname is required" in the response body


#  @TC_Authentication_06
#  Scenario: Register - Verify failed to create new account because input invalid email in the request body
#    Given User input valid endpoint to create account
#    When User request HTTP method POST and input invalid email in the request body and click Send Button
#    And User receive a response with status code 400 Bad Request
#    Then Validate failed to create account because input invalid email and display error message in the response body


  @TC_Authentication_07
  Scenario: Register - Verify failed to create new account because invalid password in the request body
    Given User input valid endpoint to create account
    When User request HTTP method POST and input invalid password in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create account because input invalid password and display error message "json: cannot unmarshal number into Go struct field AuthRegisterRequest.password of type string" in the response body

  @TC_Authentication_08
  Scenario: Register - Verify failed to create new account because invalid fullname in the request bod
    Given User input valid endpoint to create account
    When User request HTTP method POST and input invalid fullname in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create account because input invalid fullname and display error message "json: cannot unmarshal number into Go struct field AuthRegisterRequest.fullname of type string" in the response body

#  @TC_Authentication_09
#  Scenario: Register - Verify failed to create new account because input email with only space in the request body
#    Given User input valid endpoint to create account
#    When User request HTTP method POST and input email with a space in the request body and click Send Button
#    And User receive a response with status code 400 Bad Request
#    Then Validate failed to create account because input email with a space and display "error message" in the response body
#
#  @TC_Authentication_10
#  Scenario: Register - Verify failed to create new account because input password with only space in the request body
#    Given User input valid endpoint to create account
#    When User request HTTP method POST and input password with a space in the request body and click Send Button
#    And User receive a response with status code 400 Bad Request
#    Then Validate failed to create account because input password with a space and display "error message" in the response body
#
#
#  @TC_Authentication_11
#  Scenario: Register - Verify failed to create new account because input fullname with only space in the request body
#    Given User input valid endpoint to create account
#    When User request HTTP method POST and input fullname with a space in the request body and click Send Button
#    And User receive a response with status code 400 Bad Request
#    Then Validate failed to create account because input fullname with a space and display "error message" in the response body


  @TC_Authentication_12
  Scenario: Register - Verify failed to create new account becuase invalid endpoint
    Given User input invalid endpoint to create account
    When User request HTTP method POST and input valid data in the request body and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to create account because invalid endpoint and display "not found" in the response body


  @TC_Authentication_13 @Login
  Scenario: Login - Verify success to login with valid endpoint and request body
    Given User input valid endpoint to login
    When User request HTTP method POST and input valid email and valid password in the request body and click Send Button
    And User receive a response with status code 200 OK
    Then Validate failed to login because input valid endpoint and valid account and display token in the response body

  @TC_Authentication_14
  Scenario: Login - Verify failed to login because input invalid endpoint
    Given User input invalid endpoint to login
    When User request HTTP method POST and input valid email and valid password in request body and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to login because input invalid endpoint and display error message "not found" in the response body

  @TC_Authentication_15
  Scenario: Login - Verify failed to login because input invalid email in the request body
    Given User input valid endpoint to login
    When User request HTTP method POST and input invalid email in request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to login because input invalid email and display error message "record not found" in the response body

  @TC_Authentication_16
  Scenario: Login - Verify failed to login because input invalid password in the request body
    Given User input valid endpoint to login
    When User request HTTP method POST and input invalid password in request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to login because input invalid password and display error message "email or password is invalid" in the response body


  @TC_Authentication_17
  Scenario: Login - Verify failed to login because input invalid email and password in the request body
    Given User input valid endpoint to login
    When User request HTTP method POST and input invalid email and password in request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to login because input invalid email and password and display error message "record not found" in the response body


  @TC_Authentication_18
  Scenario: Login - Verify failed to login because did not input email in the request body
    Given User input valid endpoint to login
    When User request HTTP method POST and and did not input email in request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to login because did not input email and display error message "email is required" in the response body

  @TC_Authentication_19
  Scenario: Login - Verify failed to login because did not input password in the request body
    Given User input valid endpoint to login
    When User request HTTP method POST and did not input password in request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to login because did not input password and display error message "password is required" in the response body


  @TC_Authentication_20
  Scenario: Login - Verify failed to login because did not input email and password in the request body
    Given User input valid endpoint to login
    When User request HTTP method POST and did not input email and password in request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to login because did not input email and password and display error message "email is required" in the response body


  @TC_Authentication_21 @GetUserInformation
  Scenario: Get User information - Verify success to get information of the user with valid endpoint
    Given User input valid endpoint to get user information
    When User request HTTP method GET to get user information and click Send Button
    And User receive a response with status code 200 OK
    Then Validate success to get user information and display information the account in the response body


  @TC_Authentication_22
  Scenario: Get User information - Verify failed to get information of the user because input invalid endpoint
    Given User input invalid endpoint to get user information
    When User request a method HTTP GET and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to get user information and display error message "not found" in the response body
