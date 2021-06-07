Feature: One Shot CSV Example

  Background:
    * url baseUrl

  Scenario: Send CSV
    Given path 'api/echo'
    And header Content-Type = 'application/json'
    And request read('input.csv')
    When method POST
    Then status 200
    And match $ == [{"Unit":"ea","Cost":"34.50","Name":"Cheese"},{"Unit":"ea","Cost":"55.54","Name":"Cake"},{"Unit":"kg","Cost":"35.90","Name":"Chicken"}]
