@apiTest
Feature: GET endpoints testing

  @get-positive
  Scenario: GET: get a list of people
    Given request headers are setup
    When user sends a "GET" request to the "star_wars_get_people" endpoint
    Then status code is 200
    And the response should match json schema of "get_people.json"

  @get-positive
  Scenario: GET: get the first person from the list
    Given request headers are setup
    When user sends a "GET" request to the "star_wars_get_person" endpoint
    Then status code is 200
    And the response should match json schema of "get_person.json"

  @get-negative
  Scenario: GET: get an invalid person
    When user sends a "GET" request to the "invalid_person" endpoint
    Then status code is 404
