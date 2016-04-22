Feature: online page 
  Scenario: client makes call to GET /
    When the client calls /online?idEleccion=1
    Then the client receives status code of 200
    And the client receives the string "Resultado"