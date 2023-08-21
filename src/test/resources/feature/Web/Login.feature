@web
@web-login
  Feature: login

    @negative
    Scenario: user login with invalid username
      Given user is on home page
      And user click login button from navbar
      And user input login username "thisIsUserNotFound99999"
      And user input login password "password"
      When user click login button
      Then user see alert text "User does not exist."

    @negative
    Scenario: user login with invalid password
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "wrong_password"
      When user click login button
      Then user see alert text "Wrong password."

    @negative
    Scenario: user not input username or password
      Given user is on home page
      And user click login button from navbar
      When user click login button
      Then user see alert text "Please fill out Username and Password."

    @positive
    Scenario: user logout successfully
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      And user click login button
      And user see profile name "Welcome deta_mainuser"
      When user click logout button
      Then user don't see profile name
      And user see login button from navbar is visible

    @positive
    Scenario: user login successfully login with valid credential
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      When user click login button
      Then user see profile name "Welcome deta_mainuser"




