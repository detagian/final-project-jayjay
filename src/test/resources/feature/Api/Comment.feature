@api
@api-comment

  Feature: comment
    Scenario: get list comment by default
      Given I set service api
      When I set Header method GET using Endpoint "/comment"
      Then I received a valid HTTP response code 200
      And I received a valid page index 0
      And I received a valid limit 20 user
      And I received a valid "comment/getListCommentByDefault.json"

    Scenario: get list comment by post id
      Given I set service api
      When I set Header method GET using Endpoint "/post/60d21b7967d0d8992e610d1b/comment"
      Then I received a valid HTTP response code 200
      And I received a valid page index 0
      And I received a valid limit 20 user
      And I received a valid post id "60d21b7967d0d8992e610d1b" from comment
      And I received a valid "comment/getListCommentByPostId.json"

    Scenario: get list comment by user id
      Given I set service api
      When I set Header method GET using Endpoint "/user/60d0fe4f5311236168a10a27/comment"
      Then I received a valid HTTP response code 200
      And I received a valid page index 0
      And I received a valid limit 20 user
      And I received a valid user id "60d0fe4f5311236168a10a27" from comment
      And I received a valid "comment/getListCommentByUserId.json"

    Scenario: create comment
      Given I set service api
      And I set user id "60d0fe4f5311236168a10a27"
      And I set comment id "60d21be167d0d8992e610e4f"
      And I set message to comment "Ini Comment"
      When I set Header method POST using Endpoint "/comment/create" to comment a post
      Then I received a valid HTTP response code 200
      And I received a valid message to comment "Ini Comment"
      And I received a valid "comment/createComment.json"
