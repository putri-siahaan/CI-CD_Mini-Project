Feature: Product Categories

  As a user
  I want to see all category of the product
  so that i can easily find the product

  @TC_Category_01 @CreateACategory
  Scenario: Create a category - Verify success to create category with valid endpoint and request body
    Given User input valid Endpoint with categories
    When User request HTTP method POST and input data of a new category with valid data in the request body and click Send Button to send a request
    And User receive a response with status code 200 OK
    Then Validate success to create new category and display detail all products in the response body

  @TC_Category_02
  Scenario: Create a new product - Verify success to create category without input description in the request body
    Given User input valid Endpoint with categories
    When User request HTTP method POST and data of description is empty in the request body and click Send Button to send a request
    And User receive a response with status code 200 OK
    Then Validate success to create new category and display detail all products in the response body but data of description is empty

  @TC_Category_03
  Scenario: Create a new product - Verify failed to create category because invalid name of the request body
    Given User input valid Endpoint with categories
    When User request method POST and input data of a new category with invalid name in the request body and click Send Button to send a request
    And User receive a response with status code 500 Internal Server Error
    Then Validate failed create a new category and display error message "ERROR: new row for relation \"categories\" violates check constraint \"categories_name_check\" (SQLSTATE 23514)" in the response body

  @TC_Category_04
  Scenario: Create a new product - Verify failed to create category because invalid description of the request body
    Given User input valid Endpoint with categories
    When User request method POST and input data of a new category with invalid description in the request body and click Send Button to send a request
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create new category and display error message "json: cannot unmarshal number into Go struct field CategoryCreate.description of type string" in the response body

  @TC_Category_05 @GetCategoryByID
  Scenario: Get category by ID - Verify success to get category by valid ID
    Given User input endpoint with valid ID to get Category
    When User request HTTP method GET and click Send Button
    And User receive a response with status code 200 OK
    Then Validate success to get category by ID and display detail data of category in the response body


  @TC_Category_06
  Scenario: Get category by ID - Verify failed to get category because input invalid ID
    Given User input invalid Endpoint to get category
    When User request with the HTTP method GET and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to get category and display error message "record not found" in the response body

  @TC_Category_07 @GetAllCategories
  Scenario: Get all categories - Verify success to get all category with valid endpoint
    Given User input valid Endpoint with categories
    When User request with the HTTP method GET and click Send Button to get all categories
    And User receive a response with status code 200 OK
    Then Validate success to get all category and display detail data in the response body

  @TC_Category_08
  Scenario: Get all categories - Verify failed to get all category because input invalid endpoint
    Given User input invalid Endpoint with category
    When User request method HTTP GET and click Send Button to get all categories
    And User receive a response with status code is 404 Not Found
    Then Validate failed to get all category and display error message "not found" in the response body

  @TC_Category_09 @DeleteACategory
  Scenario: Delete a category - Verify success to delete a category with valid ID
    Given User input Endpoint with valid ID=30000
    When User request DELETE method and click Send Button to remove the categories
    And User receive a response with status code 200 OK
    Then Validate success to delete a category and display message "null" in the response body

  @TC_Category_10
  Scenario: Delete a category - Verify failed to delete a category because input invalid ID
    Given User input Endpoint with invalid ID to delete a category
    When User request DELETE method and click send button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to delete a category and display error message "not found" in the response body
