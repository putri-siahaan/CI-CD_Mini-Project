Feature: Products

  As a user
  I want to see all the data
  so that i can retrieve all data of products

  @TC_Products_01 @GetAllProduct
  Scenario: GET All Products - Verify success to get all product details with valid endpoint
    Given User input valid Endpoint
    When User request with the HTTP method GET and click Send Button to send a request
    And User receive a response with status code 200 OK
    Then Validate success receive detail all products in the response body

  @TC_Products_02
  Scenario: GET All Products - Verify failed to get all product details because invalid endpoint
    Given User input invalid Endpoint
    When User request HTTP method GET and click Send Button to send a request
    And User receive a response with status code is 404 Not Found
    Then Validate failed receive detail all products and display message "not found" in the response body

  @TC_Products_03 @CreateANewProduct
  Scenario: Create a new product - Verify success to create a new products with valid endpoint
    Given User input valid Endpoint
    When User request with the HTTP method POST and input data of a new product with valid data in the request body and click Send Button to send a request
    And User receive a response with status code 200 OK
    Then Validate success to create new product and display detail all products in the response body

  @TC_Products_04
  Scenario: Create a new product - Verify failed to create a new products because input invalid name of the request body
    Given User input valid Endpoint
    When User request with HTTP method POST and input data with invalid name of the new products in the request body and click Send Button to send a request
    And User receive a response with status code 500 Internal Server Error
    Then Validate failed to create a new product and display error message "ERROR: new row for relation \"products\" violates check constraint \"products_name_check\" (SQLSTATE 23514)" in the response body

  @TC_Products_05
  Scenario: Create a new product - Verify failed to create a new products because input invalid description in the request body
    Given User input valid Endpoint
    When User request with HTTP method POST and input data of a new product with invalid description in the request body and click Send Button to send a request
    And User receive a response with status code 400 Bad Request
    Then Validate failed create a new product and display error message "json: cannot unmarshal number into Go struct field ProductCreate.description of type string" in the response body

  @TC_Products_06
  Scenario: Create a new product - Verify failed to create a new products because input invalid price in the request body
    Given User input valid Endpoint
    When User request with HTTP method POST and input data of a new product with invalid price in the request body and click Send Button to send a request
    And User receive a response with status code 400 Bad Request
    Then Validate failed to create new product and display error message "json: cannot unmarshal string into Go struct field ProductCreate.price of type uint" in the response body


  @TC_Products_07
  Scenario: Create a new product - Verify failed to create a new products because input invalid categories in the request body
    Given User input valid Endpoint
    When User request with HTTP method POST and input data of a new product with invalid categories in the request body and click Send Button to send a request
    And User receive a response with status code 400 Bad Request
    Then Validate failed create new product and display error message "json: cannot unmarshal string into Go struct field ProductCreate.categories of type uint" in the response body


  @TC_Products_08
  Scenario: Create a new product - Verify failed to create a new products because input invalid endpoint
    Given User input invalid Endpoint
    When User request with the HTTP method POST and input data of a new product with valid data and click Send Button to send a request
    And User receive a response with status code is 404 Not Found
    Then Validate failed to create new a product and display error message "json: cannot unmarshal number into Go struct field ProductCreate.description of type string" in the response body

  @TC_Products_09 @GetProductByID
  Scenario: Get product By ID - Verify success to get a product by valid ID
    Given User input Endpoint with valid ID 86235
    When User is request with HTTP method GET and click Send Button to send a request
    And User receive a response with status code 200 OK
    Then Validate success to get the data with ID=86235 and display detail pf the products in the response body


  @TC_Products_10
  Scenario: Get product By ID - Verify failed to get a product because invalid ID
    Given User input endpoint with invalid ID = 100000
    When User request data with HTTP method GET and click Send Button to send a request
    And User receive a response with status code is 404 Not Found
    Then Validate failed execution and display error message "record not found" in the response body

  @TC_Products_11 @DeleteAProduct
  @ID_DINAMIS
  Scenario: Delete a product - Verify success to delete a product with valid ID = 86000
    Given User input endpoint with valid ID to Delete a product
    When User request with the HTTP method DELETE and click Send Button to send a request
    And User receive a response with status code 200 OK
    Then Validate success to delete the product and display message "null" data in the response body

  @TC_Products_12
  Scenario: Delete a product - Verify failed to delete a product because input invalid ID = 0
    Given User input endpoint with the invalid ID = 0
    When User request with the HTTP method DELETE and click Send Button to send request
    And User receive a response with status code 500 Internal Server Error
    Then Validate success to delete the product and display error message "WHERE conditions required" in the response body


  @TC_Products_13 @AssignAProductRating
  Scenario: Assign a product rating - Verify success to assign a product rating with valid ID and valid count star=3
    Given User input Endpoint with valid ID 86235 in case rating
    When User request with the method HTTP POST and input valid count of the star is 3 in the request body and click Send Button to send request
    And User receive a response with status code 200 OK
    Then Validate success to assign rating and display detail products that have been rated in the response body


  @TC_Products_14
  Scenario: Assign a product rating - Verify success to assign a product rating with valid count stars=0
    Given User input Endpoint with valid ID 86235 in case rating
    When User request with the method HTTP POST and input valid count of the star is 0 in the request body and click Send Button to send request
    And User receive a response with status code 200 OK
    Then Validate success to assign ratings and display detail products that have been rated in the response body


  @TC_Products_15
  Scenario: Assign a product rating - Verify failed to assign a product rating because input invalid ID
    Given User input endpoint with invalid ID to assign rating
    When User request with method HTTP POST and input valid count of the stars in the request body and click Send Button to send request
    And User receive a response with status code 500 Internal Server Error
    Then Validate failed execution and display message "record not found" in the response body


  @TC_Products_16
  Scenario: Assign a product rating - Verify failed to assign a product rating because input invalid request body
    Given User input Endpoint with valid ID 86235 in case rating
    When User request with method HTTP POST and input invalid count of the stars to be assigned and click Send Button to send request
    And User receive a response with status code 500 Internal Server Error
    Then Validate failed to assign ratings and display message "ERROR: new row for relation \"ratings\" violates check constraint \"ratings_count_check\" (SQLSTATE 23514)" in the response body


  @TC_Products_17 @GetProductRatings
  Scenario: Get product ratings - Verify success to get rating of the products with valid ID
    Given User input Endpoint with valid ID 86235 in case rating
    When User request with method HTTP GET and click Send Button to send request
    And User receive a response with status code 200 OK
    Then Validate success to get product ratings and display data=2 in the response body


  @TC_Products_18
  Scenario: Get product ratings - Verify failed to get rating of the products because input invalid ID
    Given User input endpoint with invalid ID to get product ratings
    When User request method HTTP GET and click Send Button
    And User receive a response with status code 500 Internal Server Error
    Then Validate failed to get product ratings and display error message "18446744073709551615 is greater than maximum value for Int4" in the response body


  @TC_Products_19 @CreateACommentForProduct
  Scenario: Create a comment for product - Verify success to create a comment for the product with valid endpoint and content in request body contains an explanation
    Given User input a valid endpoint to create comments
    When User request method HTTP POST and input a comment containing a sentence and click Send Button to send request
    And User receive a response with status code 200 OK
    Then Validate success to create comment for product and display detail of the product with the comment in the response body


  @TC_Products_20
  Scenario: Create a comment for product - Verify success to create a comment for the product with valid endpoint and input content in request body with only space
    Given User input a valid endpoint to create comments
    When User request method HTTP POST and input comment of a product with only space and click Send Button to send request
    And User receive a response with status code 200 OK
    Then Validate success to create comment for product and display detail product with the comment in the response body


  @TC_Products_21
  Scenario: Create a comment for product - Verify failed to create a comment for the product because invalid endpoint
    Given User input invalid Endpoint in the field
    When User request method HTTP POST and input valid comment of a product and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to create comment for product and display message "not found" in the response body


  @TC_Products_22
  Scenario: Create a comment for product - Verify failed to create a comment for the product because invalid request body
    Given User input Valid Endpoint in the field
    When User request method HTTP POST and input invalid comment of a product and click Send Button
    And User receive a response with status code 500 Internal Server Error
    Then Validate failed to create comment for product and display error message "ERROR: new row for relation \"comments\" violates check constraint \"comments_content_check\" (SQLSTATE 23514)" in the response body


  @TC_Products_23 @GetProductComments
  Scenario: Get product comments - Verify success to get the product comments with valid endpoint
    Given User input Valid Endpoint in the field
    When User request method GET and click Send Button
    And User receive a response with status code 200 OK
    Then Validate success to get product comment for product and display detail of the product with the comment in the response body

  @TC_Products_24
  Scenario: Get product comments - Verify failed to get the product comments because input invalid endpoint
    Given User input a invalid Endpoint in the field
    When User request http method GET and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to get product comment for product and display message "not found" in the response body
