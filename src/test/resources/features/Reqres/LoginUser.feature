Feature: Testing Reeqres API - Login User
  @Tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send request post login user
    Then should return status code 200
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And validate json schema login user

  @Tugas
  Scenario: Post unsuccessful login user
    Given Post login user without password
    When Send request post login user
    Then should return status code 400
    And Response body error message should be "Missing password"
    And validate json schema unsuccessful login user