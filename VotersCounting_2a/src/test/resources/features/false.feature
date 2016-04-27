Feature: false page 
  Scenario: client makes call to GET /
    When the client calls /foo
    Then the client receives status code of 404