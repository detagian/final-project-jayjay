@web
@web-signup
Feature: signup

  @negative
  Scenario: user signup empty username and password
    Given user is on home page
    And user click singup button from navbar
    When user click signup button
    Then user see alert text "Please fill out Username and Password."

  @negative
  Scenario: user signup with existed credentials
    Given user is on home page
    And user click singup button from navbar
    And user input signup username "deta_mainuser"
    And user input signup password "deta_mainuser"
    When user click signup button
    Then user see alert text "This user already exist."

  @negative
  Scenario: user signup with existed credentials
    Given user is on home page
    And user click singup button from navbar
    And user input signup username "deta_mainuser"
    And user input signup password "deta_mainuser"
    When user click signup button
    Then user see alert text "This user already exist."

  @negative
  Scenario: user signup successfully
    Given user is on home page
    And user click singup button from navbar
    And user input signup unique username "deta_mainuser"
    And user input signup password "password"
    When user click signup button
    Then user see alert text "Sign up successful."

