#noinspection CucumberTableInspection
Feature: CSV Example

  Scenario: Reset To One
    Given url baseUrl
    And path 'api/reset'
    When method GET
    Then status 200

  # https://www.baeldung.com/karate-rest-api-testing
  Scenario Outline: Count CSV Row

    Given url baseUrl
    And path 'api/counter'
    And header Content-Type = 'application/json'
    And request
    """
    {
      line: '<Line>',
      name: '<Name>',
      unit: '<Unit>',
      cost: '<Cost>',
    }
    """
    When method POST
    Then status 200
    And match response.name == '#notnull'
    And match response ==
    """
      {
        _id  : '#ignore',
        line : '#ignore',
        name : '#string',
        unit : '#regex ea|kg|ml',
        cost : '#regex [+-]?[0-9]+\\.[0-9]{2}',
      }
    """
    Examples:
      | read('large' + '.csv') |
