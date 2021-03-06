Feature: Hello World

  Background:
    * url baseUrl

  Scenario: Create a Hello World Message
    Given path 'api/greeting'
    And header Content-Type = 'application/json'
    And request { name: 'World' }
    When method POST
    Then status 200
    And match $ == { message: "Hello World!" }
