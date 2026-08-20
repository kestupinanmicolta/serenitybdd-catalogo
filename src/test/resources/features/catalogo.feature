Feature: Product catalog management

  Background:
    Given the API base is configured as "https://jsonplaceholder.typicode.com"

  # ==================== PRODUCT QUERIES ====================

  Scenario: Get an existing product detail
    Given I query product with identifier 1
    Then the response returns product 1 titled "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"

  Scenario: Get all available products
    Given I query all products
    Then the response contains at least 1 product
    And each product has id, title and userId

  Scenario: Query product with invalid ID
    Given I query product with identifier 99999
    Then the response status code is 404

  # ==================== PRODUCT REGISTRATION ====================

  Scenario: Register a new product
    When I register a product with title "Wireless Headphones", description "Testing product" and user 7
    Then the product is registered with title "Wireless Headphones"

  Scenario: Register product without title
    When I register a product with title "", description "No title" and user 1
    Then the product is registered successfully

  Scenario: Register product with minimal data
    When I register a product with title "Minimal", description "Test" and user 1
    Then the product is registered with title "Minimal"

  # ==================== PRODUCT UPDATE ====================

  Scenario: Update product with PUT
    Given I query product with identifier 1
    When I update product 1 with title "Updated Product" and description "Updated content"
    Then the response status code is 200

  Scenario: Update product partially with PATCH
    Given I query product with identifier 1
    When I partially update product 1 with title "Only Title"
    Then the response status code is 200

  # ==================== PRODUCT DELETION ====================

  Scenario: Delete an existing product
    Given I query product with identifier 1
    When I delete product 1
    Then the operation returns status code 200

  # ==================== SCHEMA VALIDATION ====================

  Scenario: Validate product response structure
    Given I query product with identifier 1
    Then the response contains fields: id, title, body, userId

  # ==================== USER FILTER ====================

  Scenario: Filter products by user
    Given I filter products by user 1
    Then all products belong to user 1

  # ==================== COMMENTS ====================

  Scenario: Get comments for a product
    Given I query comments for product 1
    Then the response contains at least 1 comment
    And each comment has postId, id, name, email and body
