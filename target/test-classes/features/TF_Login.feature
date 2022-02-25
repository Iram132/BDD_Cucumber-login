@Login @Smoke
Feature: Techfios login functionality validation

  @Scenario1
  Scenario Outline: 1User should be able to login with valid credentials
    Given User is on techfios login page  
    When User enters username as "<username>" 
    When User enters password as "<password>"
    And User clicks on Signin button 
    Then User should land on Dashboard page

    Examples: 
      | username           | password |
      | demo@techfios.com  | abc123   |
      | demo@techfios.com  | abc124   |
      | demo2@techfios.com | abc123   |
      | demo2@techfios.com | abc124   | 
