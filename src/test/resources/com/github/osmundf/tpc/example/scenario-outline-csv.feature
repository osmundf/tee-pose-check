#noinspection CucumberTableInspection
Feature: CSV Example

  Scenario Outline: Send CSV Row

    Given url baseUrl
    And path 'api/echo'
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
        line : '#ignore',
        name : '#string',
        unit : '#regex ea|kg|ml',
        cost : '#regex [+-]?[0-9]+\\.[0-9]{2}'
      }
    """
    Examples:
      | read('large' + '.csv') |
