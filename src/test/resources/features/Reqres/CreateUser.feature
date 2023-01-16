Feature: Testing Reeqres API - Create User

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then should return status code 201
    And Response body name should be "Diah" and Job "QE"
    And validate json schema create user

  @Tugas
  Scenario: Post create new user without input name field
    Given Post create user without input name
    When Send request post create user
    Then should return status code 400
    And validate json schema create user

  @Tugas
  Scenario: Post create new user with invalid url
    Given Post create user with invalid url
    When Send request post create user and invalid url
    Then should return status code 404
    And validate json schema create user

  @Tugas
  Scenario: Post create user with invalid json
    Given Post create new input with invalid json
    When Send request post create user
    Then should return status code 201
    And Response body name should be 87086, Job 20, and "2023-01-15T23:06:57.270Z"
    And validate json schema create user