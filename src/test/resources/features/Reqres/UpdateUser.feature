Feature: Testing Reeqres API - Update User
  @Latihan
  Scenario: Put update user with valid json
    Given Put update user with valid json with id 2
    When Send request put update user
    Then should return status code 200
    And Response body name should be "Diah" and Job "QE"
    And validate json schema update user