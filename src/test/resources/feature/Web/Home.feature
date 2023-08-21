@web
@web-home
  Feature: home
    Scenario: user can see items products at home
      Given user is on home page
      When browser is fully loaded
      Then user see maximum 9 items per page
      And user see item name
      And user see item price
      And user see item descriptions
      And user see item image

    Scenario: user can see products details
      Given user is on home page
      And user focus on item 1
      When user click item 1
      Then user on item 1 details page
      And user see item name from details page
      And user see item price from details page
      And user see item descriptions from details page
      And user see Add to Cart button





