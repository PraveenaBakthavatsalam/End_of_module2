#Author:Praveena
  Feature: Signin
    In order to access the Selenium Practice portal
  As a user
  I want to enter valid credentials for successful login and logout

  Scenario Outline:
    Given I have to launch the browser
    Given I navigate to the website
    When I find and click signin link
    When I enter <email>
    When I enter valid <password>
    And I click signin button
    Then verify my <name> appears in TopMenu
    Then I click sign out on TopMenu
    Then verify signin link appears

    Examples:
      | email                         | password      | name            |  |
      | "cheerful.praveena@gmail.com" | "Testing@123" | "Praveena Bala" |  |