@api
@api-user
  Feature: User

    Scenario: get list user by default
      Given I set service api
      When I set Header method GET using Endpoint "/user"
      Then I received a valid HTTP response code 200
      And I received a valid page index 0
      And I received a valid limit 20 user
      And I received a valid "user/getListUserByDefault.json"

    Scenario: get list user by page
      Given I set service api
      When I set Header method GET using Endpoint "/user?page=1"
      Then I received a valid HTTP response code 200
      And I received a valid page index 1
      And I received a valid limit 20 user
      And I received a valid "user/getListUserByPage.json"


    Scenario: get user list limited
      Given I set service api
      When I set Header method GET using Endpoint "/user?limit=5"
      Then I received a valid HTTP response code 200
      And I received a valid page index 0
      And I received a valid limit 5 user
      And I received a valid "user/getUserListLimited.json"

    Scenario: get a specific user information
      Given I set service api
      When I set Header method GET using Endpoint "/user/60d0fe4f5311236168a109ca"
      Then I received a valid HTTP response code 200
      And I received a valid id "60d0fe4f5311236168a109ca"
      And I received a valid "user/getSpecificUserInformation.json"

    Scenario: create a new user
      Given I set service api
      And I set first name "deta" and last name "gian"
      And I set my email name "detagian" and email domain "@rocketmail.com"
      When I set Header method POST using Endpoint "/user/create" to create new user
      Then I received a valid HTTP response code 200
      And I received a valid "user/createNewUser.json"

    Scenario: update user information
      Given I set service api
      And I want to update last name to "AZIZI JKT48"
      When I set Header method PUT using Endpoint "/user/64dc94aefd4a65b6cec53d83"
      Then I received a valid HTTP response code 200
      And I received an update last name to "AZIZI JKT48"
      And I received a valid "user/updateUserInformation.json"
