Feature: Signup to Gmail
  Scenario Outline: Signup to gmail with invalid password
    Given user visits to gmail signup page
    When user inputs password less than 8 chars on signup page
      | firstname       | <firstname>       |
      | lastname        | <lastname>        |
      | username        | <username>        |
      | password        | <password>        |
      | confirmPassword | <confirmPassword> |

    Then User registration should be unsuccessful
    Examples:
      | firstname | lastname |  username    | password | confirmPassword |
      | Rakibul   | Shamim   | rakibulshmm  | 1234     | 1234            |
      | Karim     | Mia      | karimmia4041 | abc@123  | abc@123         |
      | Faruk     | Hasan    | farukhsn580  | khn#456  | khn#456         |


  Scenario Outline: Signup to gmail with invalid password
    Given user visits to gmail signup page
    When user inputs password more than 8 chars but it is not strong
      | firstname       | <firstname>       |
      | lastname        | <lastname>        |
      | username        | <username>        |
      | password        | <password>        |
      | confirmPassword | <confirmPassword> |

    Then User registration should be unsuccessful again
    Examples:
      | firstname | lastname |  username    | password  | confirmPassword |
      | Tarek     | Sarkar   | tarekskr047  | 12345678  | 12345678        |
      | Ripon     | Khan     | riopkhan3654 | 987654321 | 987654321       |
      | Faysal    | Mahmud   | faysalmhd489 | 123456789 | 123456789       |