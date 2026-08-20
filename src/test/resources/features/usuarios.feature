Feature: Users API

  Background:
    Given the API base is configured as "https://jsonplaceholder.typicode.com"

  Scenario: Get all users
    Given I query all users
    Then the response contains at least 1 user
    And each user has id, name and email

  Scenario: Get specific user
    Given I query user with identifier 1
    Then the user has valid name and email

  Scenario: Create valid user
    When I create a user with name "Karen Test", email "karen@test.com" and username "karentest"
    Then the user is created successfully

  Scenario: Query non-existent user
    Given I query user with identifier 99999
    Then the response status code is 404
