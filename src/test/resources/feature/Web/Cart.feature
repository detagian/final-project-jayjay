@web @web-cart
  Feature: Cart

    Scenario: user can add multiple item to cart
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      And user click login button
      And user see profile name "Welcome deta_mainuser"
      And user click item 1
      When user click button Add To Cart
      Then user see alert text "Product added."
      And user is on home page
      And user click item 2
      When user click button Add To Cart
      Then user see alert text "Product added."
      And user is on home page
      And user click item 3
      When user click button Add To Cart
      Then user see alert text "Product added."

    Scenario: user successfully delete item from cart
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      And user click login button
      And user see profile name "Welcome deta_mainuser"
      And user click cart button from navbar
      And user see at least 1 item in table products
      When user click delete button on item 1
      Then user see item 1 is deleted

    Scenario: user not input name or credit card in place order
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      And user click login button
      And user see profile name "Welcome deta_mainuser"
      And user click cart button from navbar
      And user see at least 1 item in table products
      When user click place order button
      And user click purchase button
      Then user see alert text "Please fill out Name and Creditcard."

    Scenario: user successfully place order items
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      And user click login button
      And user see profile name "Welcome deta_mainuser"
      And user click cart button from navbar
      And user see at least 1 item in table products
      When user click place order button
      And user input name "Deta" in place order form
      And user input card number "12345678" in place order form
      And user click purchase button
      Then user see successful pop-up
      And user see name "Deta" is correct in pop-up
      And user see card number "12345678" is correct in pop-up
      And user click ok button
