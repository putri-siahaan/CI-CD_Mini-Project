Feature: Orders

  As a user
  I want to order something
  So that I can order item that I want

  @TC_Orders_01 @CreateANewOrder
  Scenario: Create a new order - Verify success to create a new order with valid endpoint and request body
    Given User input valid endpoint orders
    When User request HTTP method POST and input valid product id and quantity in the request body and click Send Button
    And User receive a response with status code 200 OK
    Then Validate success to order and display detail data order in the response body

  @TC_Orders_02
  Scenario: Create a new order - Verify failed to create a new order because input invalid product_id in request body
    Given User input valid endpoint orders
    When User request HTTP method POST and input invalid product id in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to order and display error message "json: cannot unmarshal" in the response body

  @TC_Orders_03
  Scenario: Create a new order - Verify failed to create a new order because input invalid quantity in request body
    Given User input valid endpoint orders
    When User request HTTP method POST and input invalid quantity in the request body and click Send Button
    And User receive a response with status code 400 Bad Request
    Then Validate failed to order because invalid quantity and display error message "json: cannot unmarshal" in the response body


  @TC_Orders_04
  Scenario: Create a new order - Verify failed to create a new order because input invalid endpoint
    Given User input invalid endpoint orders
    When User request HTTP method POST and input valid quantity and product id in the request body and click Send Button
    And User receive a response with status code is 404 Not Found
    Then Validate failed to order because invalid endpoint and display error message "not found" in the response body


  @TC_Orders_05 @GetAllOrders
  Scenario: Get all orders - Verify success to get data all orders with valid endpoint
    Given User input valid endpoint orders
    When User request HTTP method GET and click Send Button to get all orders
    And User receive a response with status code 200 OK
    Then Validate success to get all orders and display all data order in the response body

  @TC_Orders_06
  Scenario: Get all orders - Verify failed to get data all order because input invalid endpoint
    Given User input invalid endpoint orders
    When User request method GET and click Send Button to get all orders
    And User receive a response with status code is 404 Not Found
    Then Validate failed to get all orders and display message "not found" in the response body


  @TC_Orders_07 @GetOrderByID
  Scenario: Get order by ID - Verify success to get data order with valid ID
    Given User input endpoint with valid id orders
    When User request HTTP method GET and click Send Button to get the orders
    And User receive a response with status code 200 OK
    Then Validate success to get the orders and display detail data order in the response body

  @TC_Orders_08
  Scenario: Get order by ID - Verify failed to get data order because use invalid ID
    Given User input endpoint with invalid id orders
    When User request the HTTP method GET and click Send Button to get the orders
    And User receive a response with status code is 404 Not Found
    Then Validate failed to get the orders and display error message "record not found" in the response body

