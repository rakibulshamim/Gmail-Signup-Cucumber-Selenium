Feature: Signup to Gmail
  Scenario: Signup to gmail with invalid password
    Given user visits to gmail signup page
    When user inputs invalid data on signup page
      | firstname | lastname | username | password | confirmPassword |
      | Rakibul   | Shamim   | rakibulshmm | 1234  | 1234            |

    Then User registration should be unsuccessful


