Feature: Sign up to Gmail
  Scenario Outline: Sign up to gmail with invalid password
    Given user visits to gmail signup page
    When user inputs field and "<values>"
    Then user can not Sign up
    Examples:
      | field     | values      |
      | firstname | Rakib       |
      | lastname  | Shamim      |
      | username  | rakibulshmm |
      | password  | 12345678    |


