Feature: Testing Reeqres API - List User
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with page <page>
    When Send request get list user
    Then should return status code 200
    And Response body page should be <page>
    And Validate json schema list user
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario Outline: Get list user with invalid url
    Given Get list user with page <page>
    When Send invalid request get list user
    Then should return status code 404
    And Validate json schema list user
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario: Get list user with valid parameter page
    Given Get list user with page 2
    When Send request get list user
    Then should return status code 200
    And Response body page should be 2, ID 9, Email "tobias.funke@reqres.in", and First Name "Tobias"
    And Validate json schema list user