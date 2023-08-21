@api
@api-post
Feature: post
  Scenario: get list post by default
    Given I set service api
    When I set Header method GET using Endpoint "/post"
    Then I received a valid HTTP response code 200
    And I received a valid page index 0
    And I received a valid limit 20 user
    And I received a valid "post/getListPostByDefault.json"

  Scenario: get list post by tag
    Given I set service api
    When I set Header method GET using Endpoint "/tag/water/post"
    Then I received a valid HTTP response code 200
    And I received a valid "post/getListPostByTag.json"

  Scenario: get all post by Specific User
    Given I set service api
    When I set Header method GET using Endpoint "/user/60d0fe4f5311236168a10a0b/post"
    Then I received a valid HTTP response code 200
    And I received a valid user id "60d0fe4f5311236168a10a0b" from post
    And I received a valid "post/getAllPostBySpecificUser.json"

  Scenario: get single post information
    Given I set service api
    When I set Header method GET using Endpoint "/post/60d21b3f67d0d8992e610c6f"
    Then I received a valid HTTP response code 200
    And I received a valid post id "60d21b3f67d0d8992e610c6f"
    And I received a valid "post/getSinglePostInformation.json"

  Scenario: create post
    Given I set service api
    And I set user id "60d0fe4f5311236168a109ca"
    And I set text to post "Ini post"
    When I set Header method POST using Endpoint "/post/create" to create post
    Then I received a valid HTTP response code 200
    And I received a valid text post "Ini post"
    And I received a valid "post/createPost.json"

  Scenario: update post
    Given I set service api
    And I set text to post "Ini post Update"
    When I set Header method PUT using Endpoint "/post/64ddad2afd4a651810c6449e" to create post
    Then I received a valid HTTP response code 200
    And I received a valid text post "Ini post Update"
    And I received a valid "post/updatePost.json"

