#noinspection CucumberTableInspection
Feature: Serverless

  Scenario Outline: Per Row
    * def row =
    """
    {
      name: '<Name>',
      unit: '<Unit>',
      cost: '<Cost>',
    }
    """
    * match row ==
    """
      {
        name: '#ignore',
        unit: '#regex ea|kg|ml',
        cost: '#regex [+-]?[0-9]+\\.[0-9]{2}'
      }
    """
    Examples:
      | read('large' + '.csv') |
