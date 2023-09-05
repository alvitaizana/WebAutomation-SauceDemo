Feature: Login to webPage

  Background:
    Given access to page login
    And user input password
      | password |
      | secret_sauce |

  @regression
  Scenario: Login to valid account
    When user input username1
    | username1 |
    | standard_user |
    Then user success login to first account

      @regression
      Scenario: Login to valid account
        When user input username3
          | username3 |
          | problem_user |
        Then user success login to third account

        @regression
        Scenario: Login to valid account
          When user input username4
            | username4 |
            | performance_glitch_user |
          Then user success login to fourth account

  @regression
  Scenario: Login to locked out account
    When user input username2
      | username2 |
      | locked_out_user |
    Then user failed to login

    @regression
    Scenario: Failed login with wrong username
      When user input username5
      | username5 |
      | 12@sauce*demo |
      Then user failed login

      @regression
      Scenario: Failed login with empty username
        When username empty
        Then user failed login with empty username