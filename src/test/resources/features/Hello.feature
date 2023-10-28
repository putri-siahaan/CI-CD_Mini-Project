Feature: Hello

  As a user
  I want get the index
  So that I will see the data of index

  @TC_Hello_01 @Index
  Scenario: Index - Verify success to get index with valid endpoint
    Given User input endpoint hello
    When User request HTTP method GET in the request body and click Send Button
    And User receive a response with status code 200 OK
    Then Validate success to see data "hello" in the response body

  @TC_Hello_02
  Scenario: Index - Verify failed to get index because with invalid endpoint
    Given User input endpoint hai
    When User request HTTP method Get in the request body and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to see data hai and display message "not found" in the response body
