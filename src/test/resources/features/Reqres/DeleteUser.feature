Feature: Testing Reeqres API - Delete User
  @Latihan
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Delete users with invalid id
    Given Delete user with invalid id <id>
    When Send request delete user
    Then should return status code 404
    Examples:
      | id   |
      | 0    |
      | 2000 |

  @Tugas
  Scenario Outline: Delete users with input String id
    Given Delete user with input string id "<id>"
    When Send request delete user
    Then should return status code 400
    Examples:
      | id     |
      | *&$##  |
      | ald)*& |

  @Tugas
  Scenario Outline: Delete users with invalid url
    Given Delete user with invalid url with id <id>
    When Send invalid request delete user
    Then should return status code 404
    Examples:
      | id |
      | 1  |
      | 2  |