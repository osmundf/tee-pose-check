Feature: Hello World Example

  Background:
    * url baseUrl

  Scenario: Create a employee
    Given path 'greeting'
    And header Content-Type = 'application/json'
    And request { name: "World" }
    When method POST
    Then status 200
    And match $ == { message: "Hello World!" }
