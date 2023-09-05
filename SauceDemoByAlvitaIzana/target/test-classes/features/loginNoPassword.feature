Feature: Login with no passsword

  Background:
    Given access to page login

  @regression
  Scenario: Login with empty password
    When user input username7
    | username7 |
    | sauce12@yopmail.com |
    And password is empty
    Then user failed to login with emptyPassword

    @regression
    Scenario: Login with empty username and password
      When username is empty
      And password empty
      Then user failed login with emptyField

      @regression
      Scenario: Failed login with wrong password
        When user input valid username
          | username |
          | standard_user |
        And input wrong password
        | password |
        | secret_saus |
        Then login failed