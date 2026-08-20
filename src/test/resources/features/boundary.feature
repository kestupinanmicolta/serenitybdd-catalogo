Feature: Boundary values and edge cases

  Background:
    Given the API base is configured as "https://jsonplaceholder.typicode.com"

  # ==================== BOUNDARY VALUES ====================

  Scenario: Query product with ID 0
    Given I query product with identifier 0
    Then the response status code is 404

  Scenario: Query product with negative ID
    Given I query product with identifier -1
    Then the response status code is 404

  Scenario: Query product with very large ID
    Given I query product with identifier 999999999
    Then the response status code is 404

  # ==================== TYPE VALIDATION ====================

  Scenario: Create product with numeric title
    When I register a product with title "12345", description "Numeric test" and user 1
    Then the product is registered successfully

  Scenario: Create product with long title
    When I register a product with title "Very long product title for testing validation limits and string handling", description "Long title test" and user 1
    Then the product is registered successfully

  Scenario: Create product with special characters
    When I register a product with title "Product @#$%^&*()", description "Description with special chars" and user 1
    Then the product is registered successfully

  # ==================== RESPONSE VALIDATION ====================

  Scenario: Verify response time
    Given I query product with identifier 1
    Then the response is received in less than 2 seconds

  Scenario: Verify Content-Type
    Given I query product with identifier 1
    Then the Content-Type is "application/json; charset=utf-8"
