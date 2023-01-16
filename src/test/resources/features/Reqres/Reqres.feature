#Feature: Testing Reqres API
#  @Latihan
# Scenario Outline: Get list user with valid parameter page
#    Given Get list user with page <page>
#    When Send request get list user
#    Then should return status code 200
#    And Response body page should be <page>
#    And Validate json schema list user
#  Examples:
#    | page |
#    | 1    |
#    | 2    |

#  @Latihan
#  Scenario: Post create new user with valid json
#    Given Post create user with valid json
#    When Send request post create user
#    Then should return status code 201
#    And Response body name should be "Diah" and Job "QE"
#    And validate json schema create user

#  @Latihan
#  Scenario: Put update user with valid json
#    Given Put update user with valid json with id 2
#    When Send request put update user
#    Then should return status code 200
#    And Response body name should be "Diah" and Job "QE"
#    And validate json schema update user

#  @Latihan
#  Scenario Outline: Delete users with valid id
#    Given Delete user with valid id <id>
#    When Send request delete user
#    Then should return status code 204
#  Examples:
#    | id |
#    | 1  |
#    | 2  |
